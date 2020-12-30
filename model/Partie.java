package model;

import javax.swing.text.Document;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public class Partie implements Serializable {
	Plateau p;
	Joueur J;
	
	public Partie (Plateau p) {
		this(null, p);
	}

	public Partie(Joueur J, Plateau p) {
		this.J=J;
		this.p=p;
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

	
	public void Jouer() {
	
		
			
			
			J.demanderNom();
		    System.out.println("START");
		    System.out.println("Voilà le plateau, allons-y !");
		    p.placeShapes();
		   
		    System.out.println(" ");
		    p.init();
		   
		   
		    p.displayColors();
		    while(J.veutJouer())
		    	
			{p.reinit_tab();
		    int[] tab =J.demanderCoordonnes();//On demande les coordonnées de la case à supprimer;
			
			p.eliminer_Voisines(tab[0],tab[1]);
			for(int i=0;i<64;i++) {
			p.use_tab();}
			
			p.reorganisation();	
			
		    System.out.println("Après Supression");
		    p.displayColors();
		    System.out.println("Après réorganisation bas");
		    p.goDown();
		    p.displayColors();
		    System.out.println("Après réorganisation gauche"); 
		    p.pushToLeft();
		    p.displayColors();
		    J.veutJouer();
			}
		    //if(p.IfAllSaved(2)) System.out.println("Yeah you winned !!!");
		    
		    p.jeuGagne(4);
		    }


//	public static void main(String[] args) throws FileNotFoundException {
//		Partie p = new Partie();
//		System.out.println(p.nameFill(3));
//	}
    }
	
	
	

