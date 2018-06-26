package com.sqlServer.validator;

public interface Validator<T> {
    /**
     * Generic validator
     * @param data
     * @return
     */
    boolean validate(T data);
}
