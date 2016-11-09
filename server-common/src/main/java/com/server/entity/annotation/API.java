package com.server.entity.annotation;

import java.lang.annotation.*;

/**
 * api标示
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface API {
}
