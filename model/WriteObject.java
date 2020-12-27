package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) throws IOException {
        Joueur joueur = new Joueur();
        Plateau plateau = new Plateau(8 , 8);
        Partie partie = new Partie(joueur, plateau);

        FileOutputStream fos = new FileOutputStream("partie.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(partie);

        oos.close();
    }
}
