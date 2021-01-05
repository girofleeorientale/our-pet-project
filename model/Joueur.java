package model;

import java.io.Serializable;
import java.util.Scanner;

public class Joueur implements Serializable {
    private String nom;
    transient Scanner scanReponse;

    public Joueur() {
        nom = "Anonyme";
        scanReponse = new Scanner(System.in);
    }

    public void setNom(String s) {
        this.nom = s;
    }

    public String getNom() {
        return this.nom;
    }

    public void finish() {
        scanReponse.close();
    }

    public boolean veutJouer() {
        System.out.println("   ");

        String reponse = scanReponse.nextLine();
        while (!reponse.equals("oui") && !reponse.equals("non")) {
            System.out.println("Veuillez répondre par oui ou non SVP ");
            reponse = scanReponse.nextLine();
        }

        if (reponse.equals("oui")) return true;
        return false;
    }


    public boolean veutContinuer() {

        String reponse = scanReponse.nextLine();
        while (!reponse.equals("oui") && !reponse.equals("non")) {
            System.out.println("Veuillez répondre par oui ou non ");
            this.veutContinuer();
        }

        if (reponse.equals("oui")) return true;
        return false;
    }


    public String demanderNom() {
        System.out.println("Quel est votre nom ?");

        String reponse = scanReponse.nextLine();
        return reponse;
    }


    public int[] demanderCoordonnes() {// de la case à éliminer
        System.out.println("Quelles sont les coordonnées de la case à éliminer?");
        System.out.print("coordonné X   :");
        int X = scanReponse.nextInt();
        System.out.print("coordonnée  Y :");
        int Y = scanReponse.nextInt();
        while (!(X < 8 && X >= 0 && Y >= 0 && Y < 8)) {
            System.out.println("Les coordonnées choisies sortent des bords du plateau");
            System.out.println("Veuillez réessayez SVP, choisissez des nombre entre 0 et 7");
            System.out.print("coordonné X   :");
            X = scanReponse.nextInt();
            System.out.print("coordonnée  Y :");
            Y = scanReponse.nextInt();

        }
        int tab[] = new int[2];
        tab[0] = X;
        tab[1] = Y;

        return tab;
    }


    public void AfficherNom(String name) {

        System.out.println("                        Joueur:" + "|" + name + "|");
    }


    public boolean Fusee() {
        String reponse = scanReponse.nextLine();
        while (!reponse.equals("oui") && !reponse.equals("non")) {
            System.out.println("Veuillez répondre par oui ou non Svp");
            reponse = scanReponse.nextLine();
        }
        if (reponse.equals("oui")) return true;
        return false;
    }


}
