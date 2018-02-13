package com.example.utils;

import com.google.common.collect.Iterables;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;


public class PreserveFullStackTraceOperator<T> implements FlowableOperator<T, T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreserveFullStackTraceOperator.class);
    private final RuntimeException asyncOriginalStackTraceProvider = new RuntimeException("async origin");
    private final long originThreadID = Thread.currentThread().getId();

    public static <T> PreserveFullStackTraceOperator<T> preserveFullStackTraceOperator() {
        return new PreserveFullStackTraceOperator<>();
    }

    @Override
    public Subscriber<? super T> apply(Subscriber<? super T> observer) throws Exception {
        return new Op(observer);
    }

    private class Op implements FlowableSubscriber<T>, Subscription {

        final Subscriber<? super T> child;
        Subscription s;

        private Op(Subscriber<? super T> child) {
            this.child = child;
        }

        @Override
        public void onSubscribe(Subscription s) {
            this.s = s;
            child.onSubscribe(s);
        }

        @Override
        public void onNext(T t) {
            child.onNext(t);
        }

        @Override
        public void onError(Throwable throwable) {
            if (Thread.currentThread().getId() != originThreadID) {
                List<StackTraceElement> origianlStackTraceElement = Lists.newArrayList(throwable.getStackTrace());
                List<StackTraceElement> additionalAsyncOriginStackTraceElements = asList(asyncOriginalStackTraceProvider.getStackTrace())
                        .stream().filter(element -> !PreserveFullStackTraceOperator.class.getName().equals(element.getClassName()))
                        .collect(Collectors.toList());
                Iterable<StackTraceElement> modifiedStackTraceElements = Iterables.concat(origianlStackTraceElement, additionalAsyncOriginStackTraceElements);
                throwable.setStackTrace(Iterables.toArray(modifiedStackTraceElements, StackTraceElement.class));

            }
        }

        @Override
        public void onComplete() {
            child.onComplete();
        }

        @Override
        public void request(long l) {
            s.request(l);
        }

        @Override
        public void cancel() {
            s.cancel();
        }
    }

}
