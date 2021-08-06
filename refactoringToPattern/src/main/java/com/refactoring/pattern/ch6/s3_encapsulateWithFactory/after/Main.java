package com.refactoring.pattern.ch6.s3_encapsulateWithFactory.after;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/8/5
 */
public class Main {

    protected List<AttributeDescriptor> createAttributeDescriptor(){
        List<AttributeDescriptor> result = new ArrayList<>();
        result.add(AttributeDescriptor.forInteger("remoteId", getClass()));
        result.add(AttributeDescriptor.forDate("createdDate", getClass()));
        result.add(AttributeDescriptor.forDate("lastChangedDate", getClass()));
        result.add(AttributeDescriptor.forReference("createdBy", getClass(), User.class));
        result.add(AttributeDescriptor.forReference("lastChangedBy", getClass(), User.class));
        result.add(AttributeDescriptor.forInteger("optimisticLockVersion",getClass()));
        return result;
    }

}
