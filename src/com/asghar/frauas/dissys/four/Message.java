package com.asghar.frauas.dissys.four;

import java.io.Serializable;

public class Message implements Serializable {
    private String libraryName;
    private String methodName;
    private String[] parameters;

    public Message(String libraryName, String methodName, String[] parameters) {
        this.libraryName = libraryName;
        this.methodName = methodName;
        this.parameters = parameters;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String[] getParameters() {
        return parameters;
    }
}
