package com.udemy.spring.spring_selenium.spring_configurations.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

/**
 * @ConditionalOnExpression
 *
 * This annotation allows you to conditionally create a bean based on an expression.
 * It checks whether the specified expression evaluates to true before creating the bean.
 * You can use it to control bean creation based on properties, environment variables, or other conditions.
 *
 * If either property is missing or evaluates to false, the bean won’t be created.
 * The values for these properties are defined in your application.properties file.
 */
@ConditionalOnExpression("${log.enabled:true} && ${logging.level.root:INFO}") // These values are defined under application.properties
public class LoggingService {
    /**
     * Logging Levels
     *
     * ● ERROR
     * ● WARN
     * ● INFO
     * ● DEBUG
     * ● TRACE
     */
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void logMessage(String message) {
        logger.info(message);
    }

    public void info(String message) {
        logger.info("# INFO : " + message);
    }

    public void warn(String message) {
        logger.warn("# WARN : " + message);
    }
}
