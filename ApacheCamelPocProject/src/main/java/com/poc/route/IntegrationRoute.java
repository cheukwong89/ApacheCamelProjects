package com.poc.route;

import org.apache.camel.builder.RouteBuilder;

import com.poc.vo.InputConstants;

public class IntegrationRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("cxfrs:bean:efilingWS").choice().when(header(InputConstants.OPERATION_NAME).isEqualTo("sendData")).to("direct:startMethod1")
											 .when(header(InputConstants.OPERATION_NAME).isEqualTo("sendData2")).to("direct:startMethod2");
		
		from("direct:startMethod1").process("processorOne");

		from("direct:startMethod2").process("processorTwo");
		
	}

}
