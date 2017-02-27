package com.hcm.challenge.endpoint;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hcm.challenge.domain.Coordinate;
import com.hcm.challenge.service.RobotService;


@Path("/mars")
public class RobotEndpoint{
	
	@EJB
	RobotService robot;
	
	//Não há necessidade de ser um post.
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{command}")
	public Coordinate command(@PathParam("command") String command) {
		return robot.moveOnTheMars(command);
	}

}



