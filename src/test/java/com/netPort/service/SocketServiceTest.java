package com.netPort.service;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

public class SocketServiceTest {

    @Test
    public void testScan() {
        SocketService socketService = new SocketService("192.168.1.1");

        boolean scanResult = socketService.scan(80);

        try {
            new Socket("192.168.1.1", 80);

            Assert.assertTrue(scanResult);
        }catch (IOException e) {
            Assert.assertFalse(scanResult);
        }
    }
}
