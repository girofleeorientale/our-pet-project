

import java.util.*;

public class Plateau {
    int hauteur;
    int largeur;
    // si cases false la case est vide; remplie sinon
    boolean[][] cases;
    // dans etats 0 = vide, 1 = couleur; 2 = animal
    int[][] etats;
    // int [][] couleurs indique les etats
    int[][] couleurs;
    // valeurs pour les shapes (carre - 1, L - 2, T - 3, I horizontal/vertical - 4)
    int[][] valeurs;
    int[][] tab ;
    public Plateau(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.cases = new boolean[hauteur][largeur];
        this.etats = new int[hauteur][largeur];
        this.couleurs = new int[hauteur][largeur];
        this.valeurs = new int[hauteur][largeur];
    }
    
    public void init() { tab = new int [this.hauteur][this.largeur];}

    public boolean placeSquare() {
        boolean res = false;

        Random r = new Random();
        int x0 = r.nextInt(this.largeur - 1);
        int y0 = r.nextInt(this.hauteur - 1);
        int color = r.nextInt(3) + 1;

        Carre carre = new Carre(this, x0, y0);
//        System.out.println("CARRE x: " + x0 + "y :" + y0);

        if (carre.notOutOfBoundsLeft(x0, y0) && carre.notOutOfBoundsRight(this, x0, y0)
                && carre.notOutOfBoundsUp(x0, y0) && carre.notOutOfBoundsDown(this, x0, y0)) {
            if
            (this.cases[x0][y0] == false &&
                    this.cases[x0][y0 + 1] == false &&
                    this.cases[x0 + 1][y0] == false &&
                    this.cases[x0 + 1][y0 + 1] == false) {
                this.valeurs[x0][y0] = 1;
                this.valeurs[x0][y0 + 1] = 1;
                this.valeurs[x0 + 1][y0] = 1;
                this.valeurs[x0 + 1][y0 + 1] = 1;

                this.couleurs[x0][y0] = color;
                this.couleurs[x0][y0 + 1] = color;
                this.couleurs[x0 + 1][y0] = color;
                this.couleurs[x0 + 1][y0 + 1] = color;

                this.cases[x0][y0] = true;
                this.cases[x0][y0 + 1] = true;
                this.cases[x0 + 1][y0] = true;
                this.cases[x0 + 1][y0 + 1] = true;

                res = true;
            }
        }
        return res;
    }

    public boolean placeLetterL1() {
        boolean res = false;

        Random r = new Random();
        int x0 = r.nextInt(this.largeur - 1);
        int y0 = r.nextInt(this.hauteur - 1);
        int color = r.nextInt(3) + 1;

        LetterL1 letterL1 = new LetterL1(this, x0, y0);
//        System.out.println("Letter L1 x: " + x0 + " y :" + y0);

        if (letterL1.notOutOfBoundsLeft(x0, y0) && letterL1.notOutOfBoundsRight(this, x0, y0)
                && letterL1.notOutOfBoundsUp(x0, y0) && letterL1.notOutOfBoundsDown(this, x0, y0)) {
            if (
                    this.cases[x0][y0] == false &&
                            this.cases[x0 + 1][y0] == false &&
                            this.cases[x0 + 1][y0 + 1] == false
            ) {
                this.valeurs[x0][y0] = 2;
                this.valeurs[x0 + 1][y0] = 2;
                this.valeurs[x0 + 1][y0 + 1] = 2;

                this.couleurs[x0][y0] = color;
                this.couleurs[x0 + 1][y0] = color;
                this.couleurs[x0 + 1][y0 + 1] = color;

                this.cases[x0][y0] = true;
                this.cases[x0 + 1][y0] = true;
                this.cases[x0 + 1][y0 + 1] = true;

                res = true;
            }
        }
        return res;
    }

    public boolean placeLetterL2() {
        boolean res = false;

        Random r = new Random();
        int x0 = r.nextInt(this.largeur - 1);
        int y0 = r.nextInt(this.hauteur - 1);
        int color = r.nextInt(3) + 1;

        LetterL2 letterL2 = new LetterL2(this, x0, y0);
//        System.out.println("Letter L2 x: " + x0 + " y :" + y0);


        if (letterL2.notOutOfBoundsLeft(x0, y0) && letterL2.notOutOfBoundsRight(this, x0, y0)
                && letterL2.notOutOfBoundsUp(x0, y0) && letterL2.notOutOfBoundsDown(this, x0, y0)) {
            if (
                    this.cases[x0][y0] == false &&
                            this.cases[x0 + 1][y0] == false &&
                            this.cases[x0][y0 + 1] == false
            ) {
                this.valeurs[x0][y0] = 2;
                this.valeurs[x0][y0 + 1] = 2;
                this.valeurs[x0 + 1][y0] = 2;

                this.couleurs[x0][y0] = color;
                this.couleurs[x0][y0 + 1] = color;
                this.couleurs[x0 + 1][y0] = color;

                this.cases[x0][y0] = true;
                this.cases[x0 + 1][y0] = true;
                this.cases[x0][y0 + 1] = true;

                res = true;
            }
        }
        return res;
    }

    public boolean placeLetterIHorizontal() {
        boolean res = false;

        Random r = new Random();
        int x0 = r.nextInt(this.largeur - 1);
        int y0 = r.nextInt(this.hauteur - 1);
        int color = r.nextInt(3) + 1;

        LetterIHorizontal letterIH = new LetterIHorizontal(this, x0, y0);

        if (letterIH.notOutOfBoundsLeft(x0, y0) && letterIH.notOutOfBoundsRight(this, x0, y0)
                && letterIH.notOutOfBoundsUp(x0, y0) && letterIH.notOutOfBoundsDown(this, x0, y0)) {
            if (
                    this.cases[x0][y0] == false &&
                            this.cases[x0][y0 + 1] == false &&
                            this.cases[x0][y0 + 2] == false &&
                            this.cases[x0][y0 + 3] == false
            ) {
                this.valeurs[x0][y0] = 4;
                this.valeurs[x0][y0 + 1] = 4;
                this.valeurs[x0][y0 + 2] = 4;
                this.valeurs[x0][y0 + 3] = 4;

                this.couleurs[x0][y0] = color;
                this.couleurs[x0][y0 + 1] = color;
                this.couleurs[x0][y0 + 2] = color;
                this.couleurs[x0][y0 + 3] = color;

                this.cases[x0][y0] = true;
                this.cases[x0][y0 + 1] = true;
                this.cases[x0][y0 + 2] = true;
                this.cases[x0][y0 + 3] = true;

                res = true;
            }
        }
        return res;
    }

    public boolean placeLetterIVertical() {
        boolean res = false;

        Random r = new Random();
        int x0 = r.nextInt(this.largeur - 1);
        int y0 = r.nextInt(this.hauteur - 1);
        int color = r.nextInt(3) + 1;

        LetterIVertical letterIV = new LetterIVertical(this, x0, y0);

        if (letterIV.notOutOfBoundsLeft(x0, y0) && letterIV.notOutOfBoundsRight(this, x0, y0)
                && letterIV.notOutOfBoundsUp(x0, y0) && letterIV.notOutOfBoundsDown(this, x0, y0)) {
            if (
                    this.cases[x0][y0] == false &&
                            this.cases[x0 + 1][y0] == false &&
                            this.cases[x0 + 2][y0] == false &&
                            this.cases[x0 + 3][y0] == false
            ) {
                this.valeurs[x0][y0] = 4;
                this.valeurs[x0 + 1][y0] = 4;
                this.valeurs[x0 + 2][y0] = 4;
                this.valeurs[x0 + 3][y0] = 4;

                this.couleurs[x0][y0] = color;
                this.couleurs[x0 + 1][y0] = color;
                this.couleurs[x0 + 2][y0] = color;
                this.couleurs[x0 + 3][y0] = color;

                this.cases[x0][y0] = true;
                this.cases[x0 + 1][y0] = true;
                this.cases[x0 + 2][y0] = true;
                this.cases[x0 + 3][y0] = true;

                res = true;
            }
        }
        return res;
    }

    public boolean placeLetterTHorizontal() {
        boolean res = false;

        Random r = new Random();
        int x0 = r.nextInt(this.largeur - 1);
        int y0 = r.nextInt(this.hauteur - 1);
        int color = r.nextInt(3) + 1;

        LetterTHorizontal letterTHorizontal = new LetterTHorizontal(this, x0, y0);

        if (letterTHorizontal.notOutOfBoundsLeft(x0, y0) && letterTHorizontal.notOutOfBoundsRight(this, x0, y0)
                && letterTHorizontal.notOutOfBoundsUp(x0, y0) && letterTHorizontal.notOutOfBoundsDown(this, x0, y0)) {
            if (
                    this.cases[x0][y0] == false &&
                            this.cases[x0][y0 + 1] == false &&
                            this.cases[x0][y0 + 2] == false &&
                            this.cases[x0 + 1][y0 + 1] == false
            ) {
                this.valeurs[x0][y0] = 3;
                this.valeurs[x0][y0 + 1] = 3;
                this.valeurs[x0][y0 + 2] = 3;
                this.valeurs[x0 + 1][y0 + 1] = 3;

                this.couleurs[x0][y0] = color;
                this.couleurs[x0][y0 + 1] = color;
                this.couleurs[x0][y0 + 2] = color;
                this.couleurs[x0 + 1][y0 + 1] = color;

                this.cases[x0][y0] = true;
                this.cases[x0][y0 + 1] = true;
                this.cases[x0][y0 + 2] = true;
                this.cases[x0 + 1][y0 + 1] = true;

                res = true;
            }
        }
        return res;
    }

    public void placeShapes() {
        // on met des 0 a la premiere ligne
        for (int i = 0; i< largeur; i++) {
            cases[0][i] = true;
            couleurs[0][i] = 0;
        }

        int all = 0;
        Random r = new Random();

        while (all < 10) {
            int choice = r.nextInt(6);

            if (choice == 0) {
                if (placeSquare()) {
                    all++;
                }
            } else if (choice == 1) {
                if (placeLetterL1()) {
                    all++;
                }
            } else if (choice == 2) {
                if (placeLetterL2()) {
                    all++;
                }
            } else if (choice == 3) {
                if (placeLetterIHorizontal()) {
                    all++;
                }
            } else if (choice == 4) {
                if (placeLetterIVertical()) {
                    all++;
                }
            } else if (choice == 5) {
                if (placeLetterTHorizontal()) {
                    all++;
                }
            }
        }

        while (existsEmptyCell()) {
            int color = r.nextInt(3) + 1;
            for (int i = 0; i < this.largeur; i++) {
                for (int j = 0; j < this.hauteur; j++) {
                    if (this.cases[i][j] == false) {
                        valeurs[i][j] = r.nextInt(4);
                        couleurs[i][j] = color;
                        cases[i][j] = true;
                    }
                }
            }
        }

//      on rajoute 4 animaux
        all = 0;
        while (all < 4) {
            int animal = r.nextInt(largeur-1);
            if (couleurs[0][animal]!=9) {
                couleurs[0][animal] = 9;
                all++;
        }
        }

    }

    public boolean existsEmptyCell() {
        boolean res = false;

        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                if (this.cases[i][j] == false) {
                    res = true;
                }
            }
        }
        return res;
    }

    public void fillRandom() {
        Random r = new Random();

        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                int z = r.nextInt(4);
                if (!cases[i][j]) {
                    etats[i][j] = z;
                    cases[i][j] = true;
                }
            }
        }
    }


    public void display() {
        for (int i = 0; i < hauteur-1; i++) {
            for (int j = 0; j < largeur-1; j++) {
                if (cases[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    public void displayColors() {
        for (int i = 0; i <hauteur; i++) {
            for (int j = 0; j <largeur; j++) {
                System.out.print(couleurs[i][j]);
            }
            System.out.println();
        }
    }

    public void afficherEtats() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                System.out.print(etats[i][j]);
            }
            System.out.println();
        }
    }

    public void displayValues() {
        for (int i = 0; i <hauteur; i++) {
            for (int j = 0; j <largeur; j++) {
                System.out.print(valeurs[i][j]);
            }
            System.out.println();
        }
    }
/*************************************************/
  //Normally it has to be colors
  	public boolean Voisine_Left(int i , int j) {
  		if(j==0)return false;
  		if(couleurs[i][j]==couleurs[i][j-1])return true;
  		return false;
  	}

  	public boolean Voisine_Right(int i , int j) {
  		if(j==largeur-1) {return false;}
  		if(couleurs[i][j]==couleurs[i][j+1])return true;
  		return false;
  	}
  	
  	
  	public boolean Voisine_Up(int i , int j) {
  		if(i==0)return false;
  		if(couleurs[i][j]==couleurs[i-1][j])return true;
  		return false;
  	}
  	
  	public boolean Voisine_Down(int i , int j) {
  		if(i==hauteur-1)return false;
  		if(couleurs[i][j]==couleurs[i+1][j])return true;
  		return false;
  	}
  	
  	
public void eliminer_Voisines(int i, int j) {
		
		 
		
		if(Voisine_Left(i,j)) {tab[i][j-1]=7;}
		if(Voisine_Right(i,j)) {tab[i][j+1]=7;}
		if(Voisine_Up(i,j)) {tab[i-1][j]=7;}
	    if(Voisine_Down(i,j)) {tab[i+1][j]=7;}
	    if (Voisine_Left(i,j)||Voisine_Right(i,j)||Voisine_Up(i,j)||Voisine_Down(i,j)) tab[i][j]=7;
	   
	 
	}
  	

public void use_tab() {
	
	for(int i=0;i<8;i++) {
		
		for(int j=0;j<8;j++) {
			if (tab[i][j]==7) {
				
			
				eliminer_Voisines(i,j);/*;tab[i][j]=2;*/
				//System.out.println("kkkkkkkkkkkkk");
			   //affichetab();}
		}}
	}
}
 public void affichetab() {
	 for(int i=0;i<8;i++) {
			
			for(int j=0;j<8;j++) {
        System.out.print(tab[i][j]);}

			
	 System.out.println();
	 }
		}
 




  	public void reorganisation()
	{ 
		for(int i=0;i<largeur;i++) {
			for(int j=0;j<hauteur;j++) {
			if(tab[i][j]==7 ) {couleurs[i][j]=0;}
		}
	}
	}
	
  	public boolean NoGaps(int col) {
		for(int i=1;i<hauteur;i++)
		{ if(couleurs[i-1][col]!= 0 && couleurs[i][col]==0)return false;}
		return true;
	}
  	
  	public void reorganiser_down(int col) {
		int i=0;
		if(colonne_estVide(col)) {System.out.println("La colonne est vide, réorganiser à gauche");return;}
		while(i<hauteur-1) {
		if(couleurs[i][col]==0 ) {i++;}
		else if(couleurs[i][col]!=0 && couleurs[i+1][col]==0) { reorganiser_bas_bis(i,col);i++;}
		else i++;
		}
		while (!NoGaps(col))reorganiser_down(col);}
		
  public void reorganiser_bas_bis(int ligne,int col) {
		
		if(ligne<hauteur && couleurs[ligne+1][col]==0) {
		
		couleurs[ligne+1][col]=couleurs[ligne][col];
		couleurs[ligne][col]=0;}
  }
  
  public boolean colonne_estVide(int col) {
		int i=0;
		while(i<hauteur-1 && couleurs[i][col]==0)i++;
		if( couleurs[i][col]!=0) return false;
		return true;
	}
		
		
		
  public void reorganiser_Àgauche(int col) {
		if(col>=1 && col<largeur-1 && colonne_estVide(col-1))
		{
		for(int i=0;i<hauteur;i++) {
		couleurs[i][col-1]=couleurs[i][col];
		couleurs[i][col]=0;
		reorganiser_Àgauche(col+1);
		}
		}}
		
/******Fonctions de jeu ****/
  /* Fonction qui regarde si il y'a des colonnes vide*/
   /*  (pousser à gauche) par conséquent*/
  
  public void pushToLeft() {
	  for(int j=0;j<largeur;j++) {
		  if(this.colonne_estVide(j)) 
		  {this.reorganiser_Àgauche(j);}
	  }
	  }
  /* descendre */
 public void goDown() {
	 for(int j=0;j<largeur;j++)
		 //Si cette colonne a des vides(mal rangée)(faut descendre)
	 { if(! this.NoGaps(j))this.reorganiser_down(j);}
 }
  
 /*****poser l'animal***/
 
 public void poser_animal(int i, int j) { couleurs[i][j]=9;}
 //(i,j) la case ou l'animal es posé
 /** deplacer l'animal suite à des supressions**/
 /*** 1 bas ***/
 public void deplacer_animal_bas(int i , int j) {
	 int parcours=i+1;
	while(parcours<hauteur-1 && couleurs[parcours][j]==0){
	parcours++;}
   if (couleurs[parcours][j]!=0) {poser_animal(parcours-1,j);}
   if(couleurs[hauteur-1][j]==0) {poser_animal(hauteur-1,j);}}
	/*** 2  gauche***/ 		
	public void deplacer_animal_gauche(int i, int j) {
		// parcours horizontal
		int parcours=j-1;
		while(parcours>0 && parcours<largeur && couleurs[i][parcours]==0) {
			parcours--;
		}
		if(couleurs[i][parcours]!=0) {poser_animal(i,parcours+1);}
		if(couleurs[i][0]==0) {poser_animal(i,0);}
	}
 /* l'animal a t il été sauvé ? */
public boolean animal_sauvé(int i, int j) {
	if (i==hauteur-1) {couleurs[i][j]=0;return true;}
	return false;
}
	/* à faire */
 public void jeuGagné() {

 }
  	
  	
	
/******************************************************/
    public static void main(String[] args) {
        Plateau p = new Plateau(8, 8);
        p.init();
        System.out.println("START");
        p.placeShapes();
        p.displayValues();
        System.out.println(" couleurs : ");
        p.displayColors();
//        p.placeShapes();
//        System.out.println(" ");
//        p.displayValues();

        p.eliminer_Voisines(1, 1);
        p.use_tab();
        p.reorganisation();
        System.out.println(" ");
        System.out.println("voila après la supression :");
        p.displayColors();

       System.out.println("Après réorganisation ");
        p.reorganiser_down(2);
        System.out.println(" ");
        p.displayColors();
    }
}
    




