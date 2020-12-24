
public class Partie {
	Plateau p;
	Joueur J;
	
	
	public Partie(Joueur J, Plateau p) {
		this.J=J;
		this.p=p;
	}
	
	
	public void Jouer() {
	
	p.init();
    System.out.println("START");
    System.out.println("Voilà le plateau, allons-y !");
    p.placeShapes();
   // p.displayValues();
    System.out.println(" ");
    p.displayColors();
	int[] tab =J.demanderCoordonnes();//On demande les coordonnées de la case à supprimer;
	p.eliminer_Voisines(tab[0],tab[1]);
	p.use_tab();
	p.reorganisation();	
	/*p.goDown();
    p.pushToLeft();*/
    System.out.println("Après Supression");
    p.displayColors();
    System.out.println("Après réorganisation bas");
    p.goDown();
    p.displayColors();
    System.out.println("Après réorganisation gauche"); 
    p.pushToLeft();
    p.displayColors();
    
    }
	
	
	

}
