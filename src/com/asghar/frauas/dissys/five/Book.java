package com.asghar.frauas.dissys.five;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Book extends Remote {
    String getTitle() throws RemoteException;

    String getShelfMark() throws RemoteException;

    String getState() throws RemoteException;

    void setState(String state) throws RemoteException;
}
