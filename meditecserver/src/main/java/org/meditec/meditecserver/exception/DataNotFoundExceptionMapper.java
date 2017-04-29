package org.meditec.meditecserver.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.meditec.meditecserver.model.ErrorMessage;

// Provider maps the class into JAX-RS
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404, "https://www.meditec.tec.cr/help");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
