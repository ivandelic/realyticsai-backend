package ai.realitics.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RealyticsAiExceptionMapper implements ExceptionMapper<RealyticsAiException> {

	@Override
	public Response toResponse(RealyticsAiException exception) {
		return Response.status(Status.BAD_REQUEST).entity(exception.getMessageCodes()).build();
	}

}
