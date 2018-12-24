package com.netPort.presenter;

import com.netPort.service.console.Output;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * The type Scan presenter.
 */
public class ScanPresenter {

    private Output output;

    /**
     * Instantiates a new Scan presenter.
     *
     * @param output the output
     */
    public ScanPresenter(Output output) {
        this.output = output;
    }

    /**
     * Write result scan.
     *
     * @param list the list
     */
    public void writeResultScan(LinkedList<String> list) {
        Iterator<String> iterator = list.iterator();
        int i = 1;

        while (iterator.hasNext()) {
            output.println("#" + i + ": " + iterator.next());

            ++i;
        }
    }


    /**
     * Started scan.
     */
    public void startedScan() {
        output.println("Hello, scan is started! Write result after scan...");
    }

    public void failedArgs() {
        output.println("No specified all arguments. Required is [address] [start port] [end port]");
    }
}
