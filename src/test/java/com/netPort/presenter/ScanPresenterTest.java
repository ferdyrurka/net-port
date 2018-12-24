package com.netPort.presenter;

import com.netPort.service.console.Output;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;

/**
 * The type Scan presenter test.
 */
@RunWith(MockitoJUnitRunner.class)
public class ScanPresenterTest {

    @Mock
    private Output output = new Output(System.out);

    private ScanPresenter scanPresenter;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        this.scanPresenter = new ScanPresenter(this.output);
    }

    /**
     * Test write result scan.
     */
    @Test
    public void testWriteResultScan() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First result");
        linkedList.add("Second result");

        Mockito.doNothing().when(this.output).println(Mockito.isA(String.class));

        this.scanPresenter.writeResultScan(linkedList);

        Mockito.verify(this.output).println("#1: " + linkedList.get(0));
        Mockito.verify(this.output).println("#2: " + linkedList.get(1));
    }

    /**
     * Test started scan.
     */
    @Test
    public void testStartedScan() {
        Mockito.doNothing().when(this.output).println(Mockito.isA(String.class));

        this.scanPresenter.startedScan();

        Mockito.verify(this.output, Mockito.times(1)).println("Hello, scan is started! Write result after scan...");
    }
}
