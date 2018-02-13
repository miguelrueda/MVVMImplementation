package com.example.utils;

import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UncaughtExceptionHandlerInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(UncaughtExceptionHandlerInitializer.class);

    public static void initUncaughtExceptionHandler() {
        if(Thread.getDefaultUncaughtExceptionHandler() != null) {
            throw new IllegalStateException("Default DefaultUncaughtExceptionHandler is already set: " + Thread.getDefaultUncaughtExceptionHandler());
        }
        Thread.setDefaultUncaughtExceptionHandler(new LoggingExceptionHandler());
        System.setProperty("sun.awt.exception.handler", LoggingExceptionHandler.class.getName());
    }

    public static class LoggingExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            LOGGER.error("Unhandled exception in AWT Thread. Will log and rethrow: " + t + " : " + e.getMessage());
        }

        public void handle(final Throwable thrown) {
            LOGGER.error("Unhandled exception in AWT Thread. Will log and rethrow: " + thrown.getMessage(), thrown);
            Throwables.propagate(thrown);
        }
    }

}
