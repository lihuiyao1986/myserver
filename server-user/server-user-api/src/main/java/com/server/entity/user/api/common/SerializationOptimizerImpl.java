package com.server.entity.user.api.common;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.server.entity.user.web.UserRespEntity;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * SerializationOptimizerImpl
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        classes.add(UserRespEntity.class);
        return classes;
    }
}
