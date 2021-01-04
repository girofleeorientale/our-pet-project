package model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lanceur {
	Plateau p = new Plateau(8,8);
	Joueur j = new Joueur();
	Partie par = new Partie(j,p);



	public String chooseLevel () {
		System.out.println("Quel niveau choisissez-vous ?");
		Scanner scanReponse = null;
		String reponse = scanReponse.nextLine();
		return reponse;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Plateau p = new Plateau(8,8);
		Joueur j = new Joueur();
		Partie par = new Partie(j,p);
		par.Jouer();

	}
	
	

}
