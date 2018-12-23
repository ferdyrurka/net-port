package com.netPort.validator;

public interface ValidatorInterface<T> {
    boolean validate(T args);
}
