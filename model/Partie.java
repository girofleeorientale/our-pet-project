package model;

import javax.swing.text.Document;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Partie implements Serializable {
	Plateau plateau;
	Joueur J;
	Scanner scanReponse;


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
					Integer.parseInt(devData[3])));
		}
		return res;
	}

	public void initializeBoard (int level) throws FileNotFoundException {
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
				break;
		}
		plateau.StockFusee = findLevel().get(level-1).get(1);
		plateau.obstaclesNumber = findLevel().get(level-1).get(2);
	}

public void ColorGuide() {
	System.out.println("***GUIDE***");
	System.out.println("W -> white -> Empty Cell");
	System.out.println("P -> Blue ->  Blue Cell ");
	System.out.println("R -> Red ->   Red Cell");
	System.out.println("G -> Green -> Green Cell");
	System.out.println("Y -> Yellow-> Yellow Cell");
	System.out.println("M -> Marron -> Obstacle");
	System.out.println("B  ->  Black -> Animal" );
	
}
//	public void setupLevel(int id) throws levelNotFoundException{
//		//somehow like this
//		Document doc = parse("levels.json");
//		for(Element elm: doc.get("levels")){
//			if(Integer.parseInt(elm.get("id")).equals(id)){
//				//setup your level
//			}
//		}
//	}

	public String nameFill (int id) throws FileNotFoundException {
		File devFile = new File("levels.txt");
		Scanner devScanner = new Scanner(devFile);
		String res = "";
		while (devScanner.hasNext()) {
			String nextLine = devScanner.nextLine();
			String[] devData = nextLine.split(",");
			if (Long.parseLong(devData[0]) == id) {
				res = devData[1];
			}

		}
		return res;
	}

	public int chooseLevel () {
		System.out.println("Quel niveau choisissez-vous ?");
		scanReponse = new Scanner(System.in);
		int reponse = scanReponse.nextInt();
		return reponse;
	}

	
	public void Jouer() throws FileNotFoundException {

			J.demanderNom();
		    //this.ColorGuide();
		    System.out.println("Voilà le plateau, allons-y !");
		    int s = chooseLevel();
		    switch (s) {
				case 1: initializeBoard(1);
					break;
				case 2: initializeBoard(2);
					break;
				case 3: initializeBoard(3);
					break;
				case 4: initializeBoard(4);
					break;
				case 5: initializeBoard(5);
					break;
			}
//		    plateau.placeShapes();
//		    plateau.displayColors();
		    plateau.getTab();
		    System.out.println(" ");
		    plateau.init();
		   
		   
		    plateau.displayColors1();
		    while(J.veutJouer())
		    	
			{plateau.reinit_tab();
		    int[] tab =J.demanderCoordonnes();//On demande les coordonnées de la case à supprimer;
			
			plateau.eliminer_Voisines(tab[0],tab[1]);
			for(int i=0;i<64;i++) {
			plateau.use_tab();}
			
			plateau.reorganisation();
			
		   System.out.println("Après Supression");
		   plateau.getTab();
		   plateau.displayColors1();
		    System.out.println("Après réorganisation bas");
		    plateau.goDown();
		    plateau.getTab();
		    plateau.displayColors1();
		    System.out.println("Après réorganisation gauche"); 
		    plateau.pushToLeftbis();
		    plateau.getTab();
		    plateau.displayColors1();
		    
		   //p.AddAnimals(3);
		   // System.out.println("après l'ajout des animaux");
		    //p.displayColors1();
		    J.veutJouer();
			}
		    //if(p.IfAllSaved(2)) System.out.println("Yeah you winned !!!");
		    
		    plateau.jeuGagne(4);
		    }



    }
	
	
	

