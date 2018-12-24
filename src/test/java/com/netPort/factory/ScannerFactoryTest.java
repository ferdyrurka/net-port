package com.netPort.factory;

import com.netPort.service.ScannerService;
import com.netPort.exception.FailedValidateException;
import com.netPort.service.SocketService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ScannerFactoryTest {

    @Test(expected = FailedValidateException.class)
    public void testFailedAddress() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("https://example", 10, 10);
    }

    @Test(expected = FailedValidateException.class)
    public void testTooBigStartPort() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 65536, 65538);
    }

    @Test(expected = FailedValidateException.class)
    public void testTooBigEndPort() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 65534, 65538);
    }

    @Test(expected = FailedValidateException.class)
    public void testStartPortLessZero() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", -1, 10);
    }

    @Test(expected = FailedValidateException.class)
    public void testEndPortLessZero() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 10, -20);
    }

    @Test(expected = FailedValidateException.class)
    public void testStartPortTooBigToEndPort() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 200, 20);
    }

    @Test
    public void testGetScannerService() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 10, 20);
        assertEquals(ScannerService.class, scannerServiceFactory.getScannerService().getClass());
    }

    @Test
    public void testGetSocketService() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 10, 20);
        assertEquals(SocketService.class, scannerServiceFactory.getSocketService().getClass());
    }
}
