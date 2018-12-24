package com.netPort;

import com.netPort.factory.ScannerServiceFactory;
import com.netPort.presenter.ScanPresenter;
import com.netPort.service.console.Output;
import java.util.LinkedList;

/**
 * The type Net port.
 */
public class netPort {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        Output output = new Output(System.out);
        ScanPresenter scanPresenter = new ScanPresenter(output);

        scanPresenter.startedScan();

        ScannerServiceFactory scannerServiceFactory = new ScannerServiceFactory(
                args[0],
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2])
        );

        LinkedList<String> result = scannerServiceFactory.getScannerService().scan(scannerServiceFactory.getSocketService());

        scanPresenter.writeResultScan(result);
    }
}
