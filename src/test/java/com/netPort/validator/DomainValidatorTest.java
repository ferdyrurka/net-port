package com.netPort.validator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class DomainValidatorTest {

    DomainValidator domainValidator;

    @Before
    public void setUp() {
        this.domainValidator = new DomainValidator();
    }

    @Test
    public void testFailedIp() {
        assertFalse(domainValidator.validate("192.168.2555.2555"));
    }

    @Test
    public void testGoodIp() {
        assertTrue(domainValidator.validate("192.168.1.1"));
    }

    @Test
    public void testFailedDomain() {
        assertFalse(domainValidator.validate("https://example"));
    }

    @Test
    public void testGoodDomain() {
        assertTrue(domainValidator.validate("google.com"));
    }
}
