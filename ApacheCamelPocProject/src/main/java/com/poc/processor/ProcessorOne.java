package com.poc.processor;

import java.util.logging.Logger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.poc.vo.OutputResponseVO;

@Component("processorOne")
public class ProcessorOne  implements Processor {

	Logger logger = Logger.getLogger(ProcessorOne.class.getName());
	
	public void process(Exchange exchange) throws Exception {
		
		String request = exchange.getIn().getBody(String.class);
		logger.info("request :: "+request);
		
		String outputMessage = "Hello "+request+" From Processor-1";
		logger.info(outputMessage);
		
		OutputResponseVO outputResponseVO = new OutputResponseVO();
		outputResponseVO.setResponse(outputMessage);
		
		exchange.getOut().setBody(outputResponseVO);
	}

}
