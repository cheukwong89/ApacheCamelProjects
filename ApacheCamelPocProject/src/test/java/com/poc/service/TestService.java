package com.poc.service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.poc.processor.ProcessorOne;
import com.poc.vo.OutputResponseVO;

@RunWith(CamelSpringJUnit4ClassRunner.class)
public class TestService extends TestApplicationContext {

	@EndpointInject(uri = "direct:start")
	private ProducerTemplate template;
	
	@EndpointInject(uri = "mock:sendData")
	private MockEndpoint sendDataEndPoint;
	
	Logger logger = Logger.getLogger(ProcessorOne.class.getName());
	
	@Test
	public void testsendData() throws Exception {
		// Defining Test input
		String testInput = "Krishna";
		
		// Setting Expected response
		OutputResponseVO expectedResponse = new OutputResponseVO();
		expectedResponse.setResponse("Hello Krishna Chaitanya From Processor-1");
		
		// Creating header for Apache Router
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put(CxfConstants.OPERATION_NAME, "sendData");
		
		// Setting Expected output body from End-point URL
		sendDataEndPoint.expectedBodiesReceived(expectedResponse);
		
		// Making a call to Router/service using ProducerTemplate
		template.sendBodyAndHeaders(testInput, headers);
		
		// Checking the Test Output from the Router call
		sendDataEndPoint.assertIsSatisfied();
	}
}

