package com.udemy.spring.cucumberwithspringboot.spring_configurations.scope;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;
import java.util.Objects;

/**
 * SimpleThreadScope used for managing bean instances (objects) within a custom scope called "browserscope".
 * SimpleThreadScope also implementing Scope.
 * The custom scope seems to be related to browser sessions.
 */
public class BrowserScope extends SimpleThreadScope {
    /**
     * We have to override get() of SimpleThreadScope to implement thread-local storage internally.
     * When a thread requests a browser instance, we check if the browser is active and hasn’t been quit.
     * If it’s still active, we return the existing browser instance.
     * If the browser has been quit, we remove it from the map, create a new browser instance, add it to the map, and then return the new instance.
     *
     * The purpose of this code seems to be handling the session ID for a WebDriver object.
     *
     * @param name
     * @param objectFactory
     * @return
     */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object object = super.get(name, objectFactory); // Retrieves the bean. Getting WebDriver object
        SessionId sessionId = ((RemoteWebDriver) object).getSessionId(); // Checking session id
        if (Objects.isNull(sessionId)) {
            /**
             * If the session ID is null, it removes the object from the map (assuming it’s stored in some kind of map or cache) and,
             * retrieves it again.
             */
            super.remove(name);
            object = super.get(name, objectFactory);
        }
        return object;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // We want to remove the below warning message coming from SimpleThreadScope hence, the method is override.
        // Warning Message - "SimpleThreadScope does not support destruction callbacks. Consider using RequestScope in a web environment."
        // It doesn’t do anything in this case.
    }
}
