package model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import model.Plateau;


public class Lanceur {
    private Plateau p = new Plateau(8, 8);
    private Joueur j = new Joueur();
    private Partie par = new Partie(j, p);


    public static void main(String[] args) throws FileNotFoundException {
        Plateau p = new Plateau(8, 8);
        Joueur j = new Joueur();
        Partie par = new Partie(j, p);
        par.Play();

    }
}
