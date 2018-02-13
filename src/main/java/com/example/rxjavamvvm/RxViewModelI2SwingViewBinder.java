package com.example.rxjavamvvm;

import hu.akarnokd.rxjava2.swing.SwingSchedulers;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import static com.example.utils.PreserveFullStackTraceOperator.preserveFullStackTraceOperator;

public class RxViewModelI2SwingViewBinder {

    public static BooleanBindOfAble bindViewModelBoolean(Flowable<Boolean> source) {
        return new BooleanBindOfAble(source);
    }

    public static StringBindOfAble bindViewModelString(Flowable<String> source) {
        return new StringBindOfAble(source);
    }

    public static <T> BindOfAble<T> bindViewModel(Flowable<T> source) {
        return new BindOfAble<>(source);
    }

    public static class BooleanBindOfAble {

        private final Flowable<Boolean> source;

        public BooleanBindOfAble(final Flowable<Boolean> source) {
            this.source = source;
        }

        public void toSwingViewEnabledPropertyOf(JComponent target) {
            source.onBackpressureLatest()
                    .observeOn(SwingSchedulers.edt())
                    .lift(preserveFullStackTraceOperator())
                    .subscribe(target::setEnabled);
        }
    }

    public static class StringBindOfAble {

        private final Flowable<String> source;

        public StringBindOfAble(final Flowable<String> source) {
            this.source = source;
        }

        public void toSwingViewText(JTextComponent target) {
            source.onBackpressureLatest()
                    .observeOn(SwingSchedulers.edt())
                    .lift(preserveFullStackTraceOperator())
                    .subscribe(target::setText);
        }

        public void toSwingViewLabel(JLabel target) {
            source.onBackpressureLatest()
                    .observeOn(SwingSchedulers.edt())
                    .lift(preserveFullStackTraceOperator())
                    .subscribe(target::setText);
        }
    }

    public static class BindOfAble<T> {

        private final Flowable<T> source;

        public BindOfAble(final Flowable<T> source) {
            this.source = source;
        }

        public void toAction(Consumer<T> action) {
            source.observeOn(SwingSchedulers.edt())
                    .lift(preserveFullStackTraceOperator())
                    .subscribe(action);
        }
    }
}
