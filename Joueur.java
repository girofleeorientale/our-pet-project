import java.util.Scanner;

public class Joueur {
    String nom;
    Scanner scanReponse;

    public Joueur () {
        nom = "Anonyme";
        scanReponse = new Scanner(System.in);
    }

    public void setNom (String s) {
        this.nom = s;
    }

    public void finish() {
        scanReponse.close();
    }

    public boolean veutJouer () {
        boolean b = false;

        System.out.println("Voulez-vous jouer? oui / non");

        String reponse = scanReponse.nextLine(); 
        if (reponse.equals("oui")) {
            b = true;
        }
        else {
            b = false;
        }
        return b;
    }

    public String demanderNom () {
        System.out.println("Quel est votre nom ?");

        String reponse = scanReponse.nextLine();
        return reponse;
    }
    
    
    public int[] demanderCoordonnes () {// de la case à éliminer
       System.out.println("Quelles sont les coordonnées de la case à éliminer?");
       System.out.println("coord X");
       int X = scanReponse.nextInt();
       System.out.println("coord Y");
       int Y = scanReponse.nextInt();

        int tab [] = new int [2];
        tab[0] = X;
        tab[1] = Y;

        return tab;}
        
    
    
}