package com.udemy.spring.spring_selenium.conditional_annotations;
import com.udemy.spring.spring_selenium.config.LoggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ACCORD")
//@ConditionalOnExpression("${car.speed} < 70")
public class Accord implements Car {
    @Lazy
    @Autowired
    LoggerConfig loggerConfig;
    @Override
    public void run() {
        loggerConfig.getloggingService().logMessage("..........................");
        loggerConfig.getloggingService().logMessage("...........Accord.........");
    }

    @Override
    public void definition() {
        loggerConfig.getloggingService().logMessage("A car typically has four wheels and is primarily designed for passenger transportation.");
        loggerConfig.getloggingService().logMessage("Run primarily on roads and can seat one to eight people.");
    }
}