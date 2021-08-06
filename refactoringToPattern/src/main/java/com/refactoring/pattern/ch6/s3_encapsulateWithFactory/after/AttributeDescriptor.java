package com.refactoring.pattern.ch6.s3_encapsulateWithFactory.after;

import java.util.Date;

/**
 * @author zhangyu201
 * @date 2021/8/5
 */
public abstract class AttributeDescriptor {

    protected AttributeDescriptor(){

    }

    static AttributeDescriptor forInteger(String remoteId, Class clazz){
        return new DefaultDescriptor(remoteId, clazz,Integer.TYPE);
    }

    static DefaultDescriptor forDate(String createdDate, Class clazz) {
        return new DefaultDescriptor(createdDate, clazz, Date.class);
    }

    static ReferenceDescriptor forReference(String createdBy, Class<?> clazz, Class<?> type) {
        return new ReferenceDescriptor(createdBy, clazz, type);
    }
}
