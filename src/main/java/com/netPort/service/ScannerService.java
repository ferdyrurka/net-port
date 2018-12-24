package com.netPort.service;

import java.util.LinkedList;

/**
 * The type Port scanner.
 */
public class ScannerService {

    private int startPort;

    private int endPort;

    private LinkedList<String> resultScanList = new LinkedList<String>();

    /**
     * Instantiates a new Port scanner.
     *
     * @param startPort the start port
     * @param endPort   the end port
     */
    public ScannerService(int startPort, int endPort) {
        this.startPort = startPort;
        this.endPort = endPort;
    }

    /**
     * Scan.
     */
    public LinkedList<String> scan(SocketService socketService) {
        int currentPort;

        for (currentPort = this.startPort; this.startPort > this.endPort; currentPort++) {
            if (socketService.scan(currentPort)) {
                this.resultScanList.add("Port: " + currentPort + " is open!");

                continue;
            }

            this.resultScanList.add("Port: " + currentPort + " is close!");
        }

        return resultScanList;
    }
}
