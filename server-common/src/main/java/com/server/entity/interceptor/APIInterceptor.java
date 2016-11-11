package com.server.entity.interceptor;

import com.server.entity.annotation.API;
import com.server.entity.constants.ErrorcodeInfoLoader;
import com.server.entity.constants.GlobalErrorcode;
import com.server.entity.exception.APIException;
import com.server.entity.model.APIRespEntity;
import com.server.entity.utils.StringUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * api拦截器
 */
public class APIInterceptor implements MethodInterceptor {

    private Logger logger = LoggerFactory.getLogger(APIInterceptor.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (methodInvocation.getMethod().isAnnotationPresent(API.class)){
            return interceptInvocation(methodInvocation);
        }else{
            return methodInvocation.proceed();
        }
    }

    /**
     * 拦截调用
     * @param methodInvocation
     */
    private Object interceptInvocation(MethodInvocation methodInvocation)throws Throwable{
        logMethodInvokeBefore(methodInvocation);
        try{
            Object invokeResult = methodInvocation.proceed();
            if (invokeResult instanceof APIRespEntity) {
                APIRespEntity response = (APIRespEntity) invokeResult;
                if (response != null && !response.isSucc()) {
                    String code = StringUtils.trimNull(response.getCode(), GlobalErrorcode.FAIL_CODE);
                    String errorMsg = StringUtils.trimNull(response.getMessage(), GlobalErrorcode.FAIL_MSG);
                    response.setCode (code);
                    response.setMessage (inflateErrorMsg(code,errorMsg));
                }
                return response;
            }else{
                return invokeResult;
            }
        }catch (Exception ex){
            return handleException(ex,methodInvocation);
        }finally {
            logMethodInvokeAfter(methodInvocation);
        }
    }

    /**
     *@Description: 调用后记录日志
     *@Author: 李焱生
     *@Since: 2015年4月30日下午12:52:10
     *@param invokeHandler
     */
    private void logMethodInvokeAfter(MethodInvocation invokeHandler){
        Object[] objs = invokeHandler.getArguments ();
        String methodName = invokeHandler.getMethod ().getName ();
        String clazzName = invokeHandler.getThis ().getClass ().getName ();
        StringBuffer sb = new StringBuffer ();
        sb.append ("调用方法结束:");
        sb.append ("参数[");
        for ( Object obj : objs ) {
            sb.append (obj.toString ());
            sb.append (",");
        }
        sb.append ("]");
        sb.append ("方法[").append (methodName).append ("]");
        sb.append ("类[").append (clazzName).append ("]");
        logger.debug (sb.toString ());
    }

    /**
     *@Description: 调用前记录日志
     *@Author: 李焱生
     *@Since: 2015年4月30日上午11:31:15
     *@param invokeHandler
     */
    private void logMethodInvokeBefore(MethodInvocation invokeHandler){
        Object[] objs = invokeHandler.getArguments ();
        String methodName = invokeHandler.getMethod ().getName ();
        String clazzName = invokeHandler.getThis ().getClass ().getName ();
        StringBuffer sb = new StringBuffer ();
        sb.append ("开始调用方法:");
        sb.append ("参数[");
        for ( Object obj : objs ) {
            sb.append (obj.toString ());
            sb.append (",");
        }
        sb.append ("]");
        sb.append ("方法[").append (methodName).append ("]");
        sb.append ("类[").append (clazzName).append ("]");
        logger.debug (sb.toString ());
    }

    /**
     * 处理异常
     * @param ex
     * @return
     */
    private Object handleException(Exception ex,MethodInvocation invokeHandler)throws Throwable{
        invokeHandler.getMethod ().getReturnType ();
        if (invokeHandler.getMethod ().getReturnType ().isAssignableFrom(APIRespEntity.class)){
            APIRespEntity respEntity = new APIRespEntity();
            String errorCode = GlobalErrorcode.FAIL_CODE;
            String errorMsg = GlobalErrorcode.FAIL_MSG;
            if (ex instanceof APIException){
                errorCode = ((APIException)ex).getErrorCode();
                errorMsg = ((APIException)ex).getErrorMsg();
            }
            respEntity.setMessage(inflateErrorMsg(errorCode,errorMsg));
            respEntity.setCode(errorCode);
            return respEntity;
        }else{
             throw ex;
        }
    }

    /**
     * 解析错误代码
     * @return
     */
    private String inflateErrorMsg(String code,String errorMsg){
        String errorCode = StringUtils.trimNull(code,GlobalErrorcode.FAIL_CODE);
        String message = StringUtils.trimNull(errorMsg,GlobalErrorcode.FAIL_MSG);
        return ErrorcodeInfoLoader.getInstance().getMessage(errorCode,message);
    }
}
