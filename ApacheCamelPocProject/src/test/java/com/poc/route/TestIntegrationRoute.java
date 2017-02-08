package com.poc.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.poc.vo.InputConstants;

@Component("testRouteBuilder")
public class TestIntegrationRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("direct:start").choice().when(header(InputConstants.OPERATION_NAME).isEqualTo("sendData")).to("direct:startMethod11")
									 .when(header(InputConstants.OPERATION_NAME).isEqualTo("sendData2")).to("direct:startMethod12");
		
		from("direct:startMethod11").process("processorOne");

		from("direct:startMethod12").process("processorTwo");
		
	}

}
