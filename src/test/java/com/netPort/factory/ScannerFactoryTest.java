package com.netPort.factory;

import com.netPort.service.ScannerService;
import com.netPort.exception.FailedValidateException;
import com.netPort.service.SocketService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The type Scanner factory test.
 */
public class ScannerFactoryTest {

    /**
     * Test failed address.
     *
     * @throws FailedValidateException the failed validate exception
     */
    @Test(expected = FailedValidateException.class)
    public void testFailedAddress() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("https://example", 10, 10);
    }

    /**
     * Test too big start port.
     *
     * @throws FailedValidateException the failed validate exception
     */
    @Test(expected = FailedValidateException.class)
    public void testTooBigStartPort() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 65536, 65538);
    }

    /**
     * Test too big end port.
     *
     * @throws FailedValidateException the failed validate exception
     */
    @Test(expected = FailedValidateException.class)
    public void testTooBigEndPort() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 65534, 65538);
    }

    /**
     * Test start port less zero.
     *
     * @throws FailedValidateException the failed validate exception
     */
    @Test(expected = FailedValidateException.class)
    public void testStartPortLessZero() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", -1, 10);
    }

    /**
     * Test end port less zero.
     *
     * @throws FailedValidateException the failed validate exception
     */
    @Test(expected = FailedValidateException.class)
    public void testEndPortLessZero() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 10, -20);
    }

    /**
     * Test start port too big to end port.
     *
     * @throws FailedValidateException the failed validate exception
     */
    @Test(expected = FailedValidateException.class)
    public void testStartPortTooBigToEndPort() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 200, 20);
    }

    /**
     * Test get scanner service.
     *
     * @throws FailedValidateException the failed validate exception
     */
    @Test
    public void testGetScannerService() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 10, 20);
        assertEquals(ScannerService.class, scannerServiceFactory.getScannerService().getClass());
    }

    /**
     * Test get socket service.
     *
     * @throws FailedValidateException the failed validate exception
     */
    @Test
    public void testGetSocketService() throws FailedValidateException {
        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory("192.168.1.1", 10, 20);
        assertEquals(SocketService.class, scannerServiceFactory.getSocketService().getClass());
    }
}
