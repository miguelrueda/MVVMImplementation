package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface BaseLogger {

    Logger LOGGER = LoggerFactory.getLogger(BaseLogger.class);

    default Logger getLogger() {
        return LOGGER;
    }

}
