package model;
public class Partie {
	Plateau p;
	Joueur J;
	
	
	public Partie(Joueur J, Plateau p) {
		this.J=J;
		this.p=p;
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
			
    }
	
	
	

