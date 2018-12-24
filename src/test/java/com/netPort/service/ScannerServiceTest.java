package com.netPort.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ScannerServiceTest {

    @Mock
    private SocketService socketService;


    @Test
    public void testScan() {
        Mockito.when(socketService.scan(Mockito.isA(Integer.class))).thenReturn(true, false);

        ScannerService scannerService = new ScannerService(10, 11);
        LinkedList<String> result = scannerService.scan(socketService);

        Iterator<String> iterator = result.iterator();
        boolean resultIterator = true;

        while (iterator.hasNext()) {
            String next = iterator.next();

            if (!next.matches("^Port: 10 is open!$") && !next.matches("^Port: 11 is close!$")) {
                resultIterator = false;
            }
        }

        assertTrue(resultIterator);

        Mockito.verify(socketService).scan(10);
        Mockito.verify(socketService).scan(11);
    }
}
