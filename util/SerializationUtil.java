package util;

import model.Joueur;
import model.Partie;
import model.Plateau;

import java.io.*;

public class SerializationUtil {


    public static void serialize (Plateau plateau) throws IOException {

        FileOutputStream fos = new FileOutputStream("partie.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(plateau);

        oos.close();
    }

    public static Plateau deserialize () throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("partie.bin");
        ObjectInputStream oos = new ObjectInputStream(fis);

        Plateau plateau1 = (Plateau) oos.readObject();
        return plateau1;
    }
}
