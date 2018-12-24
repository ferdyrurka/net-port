package com.netPort.service.console;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

/**
 * The type Output test.
 */
@RunWith(MockitoJUnitRunner.class)
public class OutputTest {
    @Mock
    private PrintStream printStream;

    private Output output;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        this.output = new Output(this.printStream);
    }

    /**
     * Test println.
     */
    @Test
    public void testPrintln() {
        Mockito.doNothing().when(printStream).println(Mockito.isA(String.class));

        this.output.println("Hello World");

        Mockito.verify(printStream, Mockito.times(1))
                .println("Hello World");
    }
}
