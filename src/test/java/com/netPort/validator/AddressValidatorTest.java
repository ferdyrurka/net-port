package com.netPort.validator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AddressValidatorTest {

    AddressValidator addressValidator;

    @Before
    public void setUp() {
        this.addressValidator = new AddressValidator();
    }

    @Test
    public void testFailedIp() {
        assertFalse(addressValidator.validate("192.168.2555.2555"));
    }

    @Test
    public void testGoodIp() {
        assertTrue(addressValidator.validate("192.168.1.1"));
    }

    @Test
    public void testFailedDomain() {
        assertFalse(addressValidator.validate("https://example"));
    }

    @Test
    public void testGoodDomain() {
        assertTrue(addressValidator.validate("google.com"));
    }
}
