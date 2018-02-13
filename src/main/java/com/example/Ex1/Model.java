package com.example.Ex1;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Model {

    private static final Logger LOGGER = LoggerFactory.getLogger(Model.class);

    public Observable<String> infos() {
        Observable<String> texts = Observable.just("Hello World", "Hallo Welt", "Bounjour le monde", "Ciao mondo")
                .repeat();
        Observable<Long> trigger = Observable.interval(1, TimeUnit.SECONDS);

        return Observable.zip(texts, trigger, (text, aLong) -> text)
                .doOnNext(text -> LOGGER.info("Sending {}", text));
    }
}
