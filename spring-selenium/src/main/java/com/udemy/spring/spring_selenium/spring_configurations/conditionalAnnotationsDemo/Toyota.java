package com.udemy.spring.spring_selenium.spring_configurations.conditionalAnnotationsDemo;

import com.udemy.spring.spring_selenium.spring_configurations.config.LoggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@ConditionalOnExpression("${car.speed} > 70")
@Qualifier("TOYOTA")
public class Toyota implements Car {
    @Lazy
    @Autowired
    LoggerConfig loggerConfig;
    @Override
    public void run() {
        loggerConfig.getloggingService().logMessage("..........................");
        loggerConfig.getloggingService().logMessage("...........Toyota.........");
    }

    @Override
    public void definition() {
        loggerConfig.getloggingService().logMessage("A car typically has four wheels and is primarily designed for passenger transportation.");
        loggerConfig.getloggingService().logMessage("Run primarily on roads and can seat one to eight people.");
    }
}
