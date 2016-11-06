package com.server.user.api.common;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.server.user.api.model.User;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * SerializationOptimizerImpl
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        classes.add(User.class);
        return classes;
    }
}
