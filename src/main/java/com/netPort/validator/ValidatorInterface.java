package com.netPort.validator;

/**
 * The interface Validator interface.
 *
 * @param <T> the type parameter
 */
public interface ValidatorInterface<T> {
    /**
     * Validate boolean.
     *
     * @param args the args
     * @return the boolean
     */
    boolean validate(T args);
}
