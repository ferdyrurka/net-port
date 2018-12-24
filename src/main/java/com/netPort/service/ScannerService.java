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
     *
     * @param socketService the socket service
     * @return the linked list
     */
    public LinkedList<String> scan(SocketService socketService) {
        for (int currentPort = this.startPort; currentPort <= this.endPort; currentPort++) {
            if (socketService.scan(currentPort)) {
                this.resultScanList.add("Port: " + currentPort + " is open!");
                continue;
            }

            this.resultScanList.add("Port: " + currentPort + " is close!");
        }

        return resultScanList;
    }
}
