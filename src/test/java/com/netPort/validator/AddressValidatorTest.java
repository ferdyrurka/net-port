package com.netPort.validator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * The type Address validator test.
 */
public class AddressValidatorTest {

    /**
     * The Address validator.
     */
    AddressValidator addressValidator;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        this.addressValidator = new AddressValidator();
    }

    /**
     * Test failed ip.
     */
    @Test
    public void testFailedIp() {
        assertFalse(addressValidator.validate("192.168.2555.2555"));
    }

    /**
     * Test good ip.
     */
    @Test
    public void testGoodIp() {
        assertTrue(addressValidator.validate("192.168.1.1"));
    }

    /**
     * Test failed domain.
     */
    @Test
    public void testFailedDomain() {
        assertFalse(addressValidator.validate("https://example"));
    }

    /**
     * Test good domain.
     */
    @Test
    public void testGoodDomain() {
        assertTrue(addressValidator.validate("google.com"));
    }
}
