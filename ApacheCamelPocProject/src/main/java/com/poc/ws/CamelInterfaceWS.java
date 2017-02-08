package com.poc.ws;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.poc.vo.InputRequestVO;
import com.poc.vo.OutputResponseVO;

/**
 * 
 * @author chaitak0
 *
 */
@WebService
public interface CamelInterfaceWS {
	
	/**
	 * API to transfer user data using HTTP GET
	 * 
	 * @param request
	 * @return {@link OutputResponseVO}
	 */
	@GET
	@Path("/sendData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OutputResponseVO sendData(@QueryParam("request") String request);
	
	/**
	 * API to transfer user data using HTTP POST
	 * 
	 * @param request {@link InputRequestVO}
	 * @return {@link OutputResponseVO}
	 */
	@POST
	@Path("/sendData2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OutputResponseVO sendData2(InputRequestVO request);

}
