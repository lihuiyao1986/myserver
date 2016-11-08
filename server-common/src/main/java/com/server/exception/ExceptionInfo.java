package com.server.exception;

import java.lang.annotation.*;

/**
 * 
 * 自定义注解，用于标注异常信息
 *
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExceptionInfo {
	
	/** 异常编号 */
    String key() default "";

    /** 异常信息 */
    String value() default "";
}
