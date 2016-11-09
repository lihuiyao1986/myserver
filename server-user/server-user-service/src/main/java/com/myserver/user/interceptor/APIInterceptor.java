package com.myserver.user.interceptor;

import com.server.entity.constants.GlobalErrorcode;
import com.server.entity.model.APIRespEntity;
import com.server.entity.utils.StringUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * api拦截器
 */
public class APIInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Object result = null;
        String methodname = methodInvocation.getMethod ().getName ();
        String clazzName = methodInvocation.getThis ().getClass().getName ();
        String taskName = "method[" + methodname + "]clazz[" + clazzName + "]";
        try{
            Object invokeResult = methodInvocation.proceed();
            if (invokeResult instanceof APIRespEntity) {
                APIRespEntity response = (APIRespEntity) invokeResult;
                if (response != null && !response.isSucc()) {
                    String code = StringUtils.trimNull(response.getCode(), GlobalErrorcode.FAIL_CODE);
                    String message = StringUtils.trimNull (response.getMessage (), GlobalErrorcode.FAIL_MSG);
                    response.setCode (code);
                    response.setMessage (message);
                }
            }
        }catch (Exception ex){

        }

        return null;
    }
}
