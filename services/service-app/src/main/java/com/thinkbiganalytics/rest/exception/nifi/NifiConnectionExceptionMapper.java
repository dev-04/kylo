package com.thinkbiganalytics.rest.exception.nifi;

import com.thinkbiganalytics.nifi.rest.client.NifiConnectionException;
import com.thinkbiganalytics.rest.exception.BaseExceptionMapper;
import com.thinkbiganalytics.rest.model.RestResponseStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by sr186054 on 6/20/16.
 */
@Provider
@Configuration
public class NifiConnectionExceptionMapper extends BaseExceptionMapper implements ExceptionMapper<NifiConnectionException> {

    private static final Logger log = LoggerFactory.getLogger(NifiConnectionExceptionMapper.class);

    @Override
    public Response toResponse(NifiConnectionException e) {
        log.error("toResponse() caught NifiConnectionException", e);
        RestResponseStatus.ResponseStatusBuilder builder = new RestResponseStatus.ResponseStatusBuilder();
        builder.url(req.getRequestURI());
        builder.message("Unable to connect to Nifi.");

        return Response.accepted(builder.buildError()).status(Response.Status.BAD_REQUEST).build();
    }

}
