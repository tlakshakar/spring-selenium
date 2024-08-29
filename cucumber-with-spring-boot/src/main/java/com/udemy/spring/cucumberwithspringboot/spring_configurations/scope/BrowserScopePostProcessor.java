package com.udemy.spring.cucumberwithspringboot.spring_configurations.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * In its postProcessBeanFactory method:
 * - It registers the custom scope "browserscope" with the bean factory.
 * - Associates it with an instance of the BrowserScope class.
 */
public class BrowserScopePostProcessor implements BeanFactoryPostProcessor {
    /**
     * postProcessBeanFactory - registers the custom scope "browserscope" with the bean factory.
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String scopeName = "browserscope";
        BrowserScope scope = new BrowserScope();
        /**
         * It registers the custom scope "browserscope" with the bean factory.
         * Associates it with an instance of the BrowserScope class.
         */
        beanFactory.registerScope(scopeName, scope);
    }
}
