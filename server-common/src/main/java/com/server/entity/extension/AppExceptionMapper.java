package com.server.entity.extension;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.server.entity.constants.GlobalErrorcode;
import com.server.entity.constants.ErrorcodeInfoLoader;
import com.server.entity.exception.APIException;
import com.server.entity.model.BaseRespEntity;
import com.server.entity.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 处理异常
 */
@Provider
public class AppExceptionMapper implements ExceptionMapper<Exception>,ContainerRequestFilter {

    private final static String ACCEPT = "USER-ACCEPT";

    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(Exception exception) {
        BaseRespEntity resp = new BaseRespEntity();
        String type = ContentType.APPLICATION_JSON_UTF_8;
        if (request!=null){
            String accept = StringUtils.trimNull((String) request.getAttribute(ACCEPT));
            if (accept.indexOf(MediaType.TEXT_XML)!=-1){
                type = ContentType.TEXT_XML_UTF_8;
            }
        }
        if (exception instanceof APIException){
            String errorCode = StringUtils.trimNull(((APIException) exception).getErrorCode(),GlobalErrorcode.FAIL_CODE);
            resp.setErrorcode(errorCode);
            resp.setErrormsg(inflateErrorMsg((APIException) exception));
        }else{
            resp.setErrorcode(GlobalErrorcode.FAIL_CODE);
            String errorMsg = ErrorcodeInfoLoader.getInstance().getMessage(GlobalErrorcode.FAIL_CODE,GlobalErrorcode.FAIL_MSG);
            resp.setErrormsg(StringUtils.trimNull(errorMsg));
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resp).type(type).build();
    }

    /**
     * 解析错误代码
     * @param exception
     * @return
     */
    private String inflateErrorMsg(APIException exception){
        String errorCode = StringUtils.trimNull(exception.getErrorCode(),GlobalErrorcode.FAIL_CODE);
        String message = StringUtils.trimNull(exception.getErrorMsg(),GlobalErrorcode.FAIL_MSG);
        return ErrorcodeInfoLoader.getInstance().getMessage(errorCode,message);
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MultivaluedMap<String, String> headers = requestContext.getHeaders();
        String type = MediaType.TEXT_XML;
        if(headers!=null){
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = StringUtils.trimNull(entry.getKey());
                StringBuilder value = new StringBuilder("");
                if ("accept".equals(key.toLowerCase())){
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        value.append(entry.getValue().get(i));
                        if (i < entry.getValue().size() - 1) {
                            value.append(", ");
                        }
                    }
                    type = value.toString();
                    break;
                }
            }
        }
        if (request!=null){
            request.setAttribute(ACCEPT,type);
        }
    }
}
