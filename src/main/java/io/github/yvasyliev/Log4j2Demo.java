package io.github.yvasyliev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Demo {
    private static final Logger LOGGER = LoggerFactory.getLogger(Log4j2Demo.class);

    public static void main(String[] args) {
        LOGGER.info("World");
    }
}
