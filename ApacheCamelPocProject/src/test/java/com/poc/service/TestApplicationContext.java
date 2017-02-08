package com.poc.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@TestExecutionListeners({ TestApplicationContext.class, DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath:poc-app-config.xml", "classpath:poc-camel-config.xml", "classpath:poc-webservice-config.xml" })
public class TestApplicationContext extends AbstractTestExecutionListener {

}