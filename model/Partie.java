package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Partie implements Serializable {
	private Plateau plateau;
	private Joueur J;
	private Scanner scanReponse;
	static int iter =64;
    private int Level=1;
    private boolean LevelUP=false;
    private boolean [] Levels= new boolean[5];
    private int SaveScore=0;
    private boolean veutJouer=false;
    
 public void AfficherVides(int n) {
	for(int i=0;i<n;i++) { 
	System.out.println(" ")	;
 }
	
 }  
    
 public void AfficherScore(int score) {
	 System.out.println("                              Score:"+"|"+score +"|"); 
	 
 }
public void AfficherFusees(int stock) {
	System.out.println("                              Nombre de fusées     :"+"|"+stock +"|");
}
 
 
	public Partie (Plateau plateau) {
		this(null, plateau);
	}

	public Partie(Joueur J, Plateau plateau) {
		this.J=J;
		this.plateau=plateau;
	}

	public static ArrayList<List<Integer>> findLevel () throws FileNotFoundException {
		File devFile = new File("levels.txt");
		Scanner devScanner = new Scanner(devFile);
		ArrayList<List<Integer>> res = new ArrayList<>();
		while (devScanner.hasNext()) {
			String nextLine = devScanner.nextLine();
			String[] devData = nextLine.split(",");
			res.add(Arrays.asList(Integer.parseInt(devData[0]), Integer.parseInt(devData[2]),
					Integer.parseInt(devData[3]),Integer.parseInt(devData[4])));
		}
		return res;
	}

	public void initializeBoard (int level) throws FileNotFoundException {
		
		plateau.setAnimalsNumber(findLevel().get(level-1).get(3));
		switch (level) {
			case 1 : plateau.placeShapes();
			break;
			case 2 : plateau.placeShapesL2();
				break;
			case 3 : plateau.placeShapesL3();
				break;
			case 4 : plateau.placeShapesL4();
				break;
			case 5 : plateau.placeShapesL5();
				break;}
				
		
		plateau.setStockFusee(findLevel().get(level-1).get(1));
		plateau.setObstaclesNumber(findLevel().get(level-1).get(2));
		
		
	}

public void ColorGuide() {
	System.out.println("***GUIDE***");
	System.out.println("W -> white -> case videl");
	System.out.println("B -> Blue ->  case blue");
	System.out.println("R -> Red ->   case rouge");
	System.out.println("G -> Green -> case verte");
	System.out.println("Y -> Yellow-> case jaune");
	System.out.println("M -> Marron -> case marron");
	System.out.println("O  -> Orchid  -> animal" );
	System.out.println("A  -> Azur -> animal" );
}


	public int chooseLevel () {
		System.out.println("Quel niveau choisissez-vous ?");
		
		scanReponse = new Scanner(System.in);
		
		Object reponse = scanReponse.nextInt();
		
		while((int)reponse !=1 && (int)reponse !=2 && (int)reponse !=3 && (int)reponse !=4 && (int)reponse !=5)
		{System.out.println("Veuillez taper un chiffre qui correspond à un niveau");
		reponse=scanReponse.nextInt();
		}
	    return (int) reponse;
	}

	   public void Play() throws FileNotFoundException {
		   boolean b = false;
System.out.println(" **********************************Pet Rescue Saga *********************************************");
		this.AfficherVides(2);
		if(Level==1) J.setNom(J.demanderNom());
		 J.AfficherNom(J.getNom());
		System.out.println("**__Commencons une partie du niveau__** "+this.Level);
		this.AfficherVides(1);
		this.ColorGuide();
		this.AfficherVides(2);
		if(Level==1)this.initializeBoard(Level);
		
		this.AfficherVides(1);
		plateau.init();
		
		plateau.displayColors();
		System.out.println(" ");
		System.out.println("Voulez vous jouer ? oui/non");
		this.veutJouer=J.veutJouer();
		
		while(veutJouer && !this.plateau.jeuGagne(this.plateau.getAnimalsNumber()) && !this.plateau.jeuPerdu(plateau.getAnimalsNumber()))
		  {
			plateau.reinitTab();
			if(this.plateau.getStockFusee() >0){
			System.out.println("Voulez vous utiliser une fusée pour ce coup ?");
             b=J.Fusee();}
            //On demande les coordonnees de la case à éliminer
           int [] tab = J.demanderCoordonnes();
		  if(b==true) {
	if(plateau.getStockFusee()<=0)System.out.println("Vous n'avez plus de fusées");
	else{plateau.applyRocket(tab[0], tab[1], true);
		plateau.setStockFusee(plateau.getStockFusee() - 1);}
		    }
		    else {plateau.deleteNeighbours(tab[0],tab[1]);
		    for(int i=0;i<iter;i++) {
				plateau.useTab();}
		    }
		    
		
			//Partie réorganisation du Plateau

			plateau.reorganisation();
			plateau.goDown();
		    // On élimine les animaux qui arrivent en bas
		   plateau.removeAnimal();
		    // Réorganiser le plateau en poussant à gauche
		   plateau.pushToLeftbis();
		   System.out.println("Après la réorganisation du plateau");
		   
		   System.out.println(" ");
		   plateau.displayColors();
		   System.out.println(" ");
		    this.AfficherFusees(plateau.getStockFusee());
		    this.SaveScore=this.SaveScore+plateau.calculateScore();
		    this.AfficherScore(this.SaveScore+ plateau.calculateScore());
		    System.out.println("Voulez vous jouer ?");
		   	 veutJouer= J.veutJouer();
		   	
		   	 }
		if(!veutJouer) {
			
			 System.out.println("Merci d'avoir utilisé notre jeu !");
		   }
		else if(this.plateau.jeuGagne(plateau.getAnimalsNumber()) && Level<=5 ) { 
			
		    this.Level++;
		    this.LevelUP=true;
    System.out.println("______Tous les animaux ont été sauvés_____");
    System.out.println("____Félicitations ! Vous avez gagné ce niveau____ ");
    System.out.println("____Voulez vous passer au niveau suivant ? oui/non____");
    if(J.veutContinuer() && Level<=5) {
    	
    this.plateau.erase();
  initializeBoard(Level);this.Play();}
    else {  System.out.println("Merci d'avoir utilisé notre jeu !");
            
       }
		    }
		   if(this.plateau.jeuGagne(plateau.getAnimalsNumber()) && Level>5) {
				System.out.println("Vous avez déjà joué à tous les niveaux ! Bravo");
				System.out.println("Pas de niveau supérieur pour le moment...");
				System.out.println("Merci d'avoir joué !");
				
				  }
	   
		   else if(this.plateau.jeuPerdu(plateau.getAnimalsNumber())&& Level<=5 ) {
			   System.out.println("Aie ...Vous avez perdu ");
			   System.out.println("Voulez vous recommencer ce niveau ?");
			   if(J.veutRefaireNiveau()) {
				 
				   this.plateau.erase();
				   initializeBoard(Level);
				   this.Play();
			   }
			   else {  System.out.println("Merci d'avoir utilisé notre jeu !");}
			   }
		   
		   else if(!this.J.veutJouer()) {
			   System.out.println("Merci d'avoir utilisé notre jeu !");
			   
		   }
		   }
		   
		   
		 
	   }    	
		   
		    	
		    
			
	
	
	

    

	
	

