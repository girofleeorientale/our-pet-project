

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

        LetterL letterL = new LetterL(this, x0, y0);

        if (letterL.notOutOfBoundsLeft(x0, y0) && letterL.notOutOfBoundsRight(this, x0, y0)
                && letterL.notOutOfBoundsUp(x0, y0) && letterL.notOutOfBoundsDown(this, x0, y0)) {
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

        LetterL letterL = new LetterL(this, x0, y0);

        if (letterL.notOutOfBoundsLeft(x0, y0) && letterL.notOutOfBoundsRight(this, x0, y0)
                && letterL.notOutOfBoundsUp(x0, y0) && letterL.notOutOfBoundsDown(this, x0, y0)) {
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
        int all = 0;
        Random r = new Random();

        while (all < 12) {
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
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
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
			if(tab[i][j]==7 || tab[i][j]==2) {couleurs[i][j]=0;}
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
		while(i<hauteur && couleurs[i][col]==0)i++;
		if( couleurs[i][col]!=0) return false;
		return true;
	}
		
		
		
  public void reorganiser_Àgauche(int col) {
		if(col >0 && col<largeur && colonne_estVide(col-1))
		{
		for(int i=0;i<hauteur;i++) {
		couleurs[i][col-1]=couleurs[i][col];
		couleurs[i][col]=0;
		reorganiser_Àgauche(col+1);
		}
		}}
		
	
  	
  	
  	
  	
	
/******************************************************/
    public static void main(String[] args) {
        Plateau p = new Plateau(8, 8);
        p.init();
        System.out.println("START");
        p.placeShapes();
        p.displayValues();
        System.out.println(" ");
        p.displayColors();
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
    



