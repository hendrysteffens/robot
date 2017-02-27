package com.hcm.challenge.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@SuppressWarnings("serial")
@ApplicationException
public class OutOfWorldException extends WebApplicationException {
	
	public OutOfWorldException(String message) {
        super(Response.status(Response.Status.BAD_REQUEST)
            .entity(message).type(MediaType.TEXT_PLAIN).build());
    }

}
