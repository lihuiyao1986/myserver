package com.server.extension;

import com.server.constants.Errorcode;
import com.server.exception.APIException;
import com.server.model.APIResp;
import com.server.utils.JacksonUtil;
import com.server.utils.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 处理异常
 */
@Provider
public class AppExceptionMapper implements ExceptionMapper<Exception> {

    @Context
    private HttpServletRequest request;

    @Context
    private ServletContext servletContext;

    @Override
    public Response toResponse(Exception exception) {
        APIResp resp = new APIResp();
        if (exception instanceof APIException){
            resp.setCode(((APIException)exception).getErrorCode());
            resp.setMessage(((APIException) exception).getErrorMsg());
        }else{
            resp.setCode(Errorcode.FAIL_CODE);
            resp.setMessage(StringUtils.trimNull(exception.getLocalizedMessage(),Errorcode.FAIL_MSG));
        }
        return Response.ok(JacksonUtil.toJson(resp), MediaType.APPLICATION_JSON).status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
