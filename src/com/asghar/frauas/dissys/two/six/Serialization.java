package com.asghar.frauas.dissys.two.six;

import java.io.*;

public class Serialization {
    private final String fileName;

    public Serialization(String fileName) {
        this.fileName = fileName;
    }

    public void serialize(Display[] displays) {
        try (ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            objectStream.writeObject(displays);
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    public Display[] deserialize() {
        try (ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream(this.fileName))) {
            return (Display[]) objectStream.readObject();
        } catch (IOException | ClassNotFoundException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }
}
