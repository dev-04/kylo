package com.thinkbiganalytics.rest.exception;

/*-
 * #%L
 * thinkbig-service-app
 * %%
 * Copyright (C) 2017 ThinkBig Analytics
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.thinkbiganalytics.rest.model.RestResponseStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 */
public class BaseExceptionMapper {

    private static final Logger log = LoggerFactory.getLogger(BaseExceptionMapper.class);
    @Context
    protected HttpServletRequest req;

    @Value("${application.debug}")
    protected boolean debugMode;


    public Response defaultResponse(Throwable e) {
        log.error("toResponse() caught Exception: {}, {} ", e.getClass().getName(), e.getMessage(), e);
        RestResponseStatus.ResponseStatusBuilder builder = new RestResponseStatus.ResponseStatusBuilder();
        builder.url(req.getRequestURI());
        builder.message(e.getMessage());

        return Response.accepted(builder.buildError()).status(Response.Status.BAD_REQUEST).build();
    }


}
