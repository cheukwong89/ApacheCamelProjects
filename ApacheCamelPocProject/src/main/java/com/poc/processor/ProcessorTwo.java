package com.poc.processor;

import java.util.logging.Logger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.poc.vo.InputRequestVO;
import com.poc.vo.OutputResponseVO;

@Component("processorTwo")
public class ProcessorTwo implements Processor {

	Logger logger = Logger.getLogger(ProcessorTwo.class.getName());
	
	public void process(Exchange exchange) throws Exception {
		
		InputRequestVO request = exchange.getIn().getBody(InputRequestVO.class);
		
		String outputMessage = "Hello "+request.getfName()+" "+request.getlName()+" From Processor-2";
		logger.info(outputMessage);
		
		OutputResponseVO outputResponseVO = new OutputResponseVO();
		outputResponseVO.setResponse(outputMessage);
		exchange.getOut().setBody(outputResponseVO);
	}

}
