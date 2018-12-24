package com.netPort.factory;

import com.netPort.service.ScannerService;
import com.netPort.exception.FailedValidateException;
import com.netPort.service.SocketService;
import com.netPort.validator.AddressValidator;

/**
 * The type Port scanner factory.
 */
public class ScannerServiceFactory {

    private String address;

    private int startPort;

    private int endPort;

    /**
     * Instantiates a new Port scanner factory.
     *
     * @param address   the address
     * @param startPort the start port
     * @param endPort   the end port
     * @throws FailedValidateException the failed validate exception
     */
    public ScannerServiceFactory(String address, int startPort, int endPort) throws FailedValidateException{
        this.address = address;
        this.startPort = startPort;
        this.endPort = endPort;

        this.validateData();
    }

    /**
     * Gets port scanner.
     *
     * @return the port scanner
     */
    public ScannerService getScannerService() {
        return new ScannerService(this.startPort, this.endPort);
    }

    public SocketService getSocketService() {
        return new SocketService(this.address);
    }

    private void validateData() throws FailedValidateException {
        AddressValidator addressValidator = new AddressValidator();

        if (!addressValidator.validate(this.address)) {
            throw new FailedValidateException();
        }

        if (this.startPort > this.endPort || this.startPort <= 0 || this.startPort > 65535 || this.endPort <= 0 || this.endPort > 65535) {
            throw new FailedValidateException();
        }
    }
}
