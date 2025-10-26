package com.asghar.frauas.dissys.five;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BookImp extends UnicastRemoteObject implements Book {
    private final String title;
    private final String shelfMark;
    private String state;

    public BookImp(String title, String shelfMark, String state) throws RemoteException {
        this.title = title;
        this.shelfMark = shelfMark;
        this.state = state;
    }

    @Override
    public String getTitle() throws RemoteException {
        return title;
    }

    @Override
    public String getShelfMark() throws RemoteException {
        return shelfMark;
    }

    @Override
    public String getState() throws RemoteException {
        return state;
    }

    @Override
    public void setState(String state) throws RemoteException {
        this.state = state;
    }
}
