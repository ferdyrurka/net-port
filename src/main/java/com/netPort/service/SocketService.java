package com.netPort.service;

import java.io.IOException;
import java.net.Socket;

/**
 * The type Socket service.
 */
public class SocketService {

    private String address;

    /**
     * Instantiates a new Socket service.
     *
     * @param address the address
     */
    public SocketService(String address) {
        this.address = address;
    }

    /**
     * Return true, socket open. False is socket close.
     *
     * @param port the port
     * @return bool boolean
     */
    public boolean scan(int port) {
        try {
            new Socket(this.address, port);

            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
