package model;

import java.io.*;

public class ReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("partie.bin");
        ObjectInputStream oos = new ObjectInputStream(fis);

        Partie partie1 = (Partie) oos.readObject();
    }
}
