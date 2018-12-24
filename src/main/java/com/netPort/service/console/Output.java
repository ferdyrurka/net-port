package com.netPort.service.console;

import java.io.PrintStream;

/**
 * The type Output.
 */
public class Output {

    private PrintStream printStream;

    /**
     * Instantiates a new Output.
     *
     * @param printStream the print stream
     */
    public Output(PrintStream printStream) {
        this.printStream = printStream;
    }

    /**
     * Println.
     *
     * @param value the value
     */
    public void println(String value) {
        this.printStream.println(value);
    }
}
