package com.netPort.service;

import java.io.IOException;
import java.net.Socket;

public class SocketService {

    private String address;

    public SocketService(String address) {
        this.address = address;
    }

    /**
     * Return true, socket open. False is socket close.
     *
     * @param port
     * @return bool
     */
    public boolean scan(int port) {
        try {
            new Socket(this.address, port);

            return false;
        } catch (IOException e) {
            return true;
        }
    }
}
