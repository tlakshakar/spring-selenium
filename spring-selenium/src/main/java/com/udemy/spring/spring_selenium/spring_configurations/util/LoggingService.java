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
 */
@ConditionalOnExpression("${log.enabled:true} && ${logging.level.root:INFO}")
public class LoggingService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);
    public void logMessage(String message) {
        logger.info(message);
    }
}
