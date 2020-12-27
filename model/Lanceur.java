package model;


public class Lanceur {
	Plateau p = new Plateau(8,8);
	Joueur j = new Joueur();
	Partie par = new Partie(j,p);
	
	public static void main(String[] args) {
		Plateau p = new Plateau(8,8);
		Joueur j = new Joueur();
		Partie par = new Partie(j,p);
		par.Jouer();

	}
	
	

}
