
package model;



import java.util.*;

import view.BoardView;

import java.util.*;

public class Plateau extends Observable {
    public int hauteur;
    public  int largeur;
    // si cases false la case est vide; remplie sinon
    boolean[][] cases;
    // dans etats 0 = vide, 1 = couleur; 2 = animal
    int[][] etats;
    // int [][] couleurs indique les etats
    int[][] couleurs;
    // valeurs pour les shapes (carre - 1, L - 2, T - 3, I horizontal/vertical - 4)
    int[][] valeurs;
    public int[][] tab ;
    public Case[][] colors;
    public int [][] clickedOn;
    public int X;
    //BoardView view = new BoardView(this);

    public Plateau(int hauteur, int largeur) {
        //this.addObserver((Observer) view);
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.cases = new boolean[hauteur][largeur];
        this.etats = new int[hauteur][largeur];
        this.couleurs = new int[hauteur][largeur];
        this.valeurs = new int[hauteur][largeur];
        this.colors = new Case[hauteur][largeur];
    }

    public void init() { tab = new int [this.hauteur][this.largeur];}

    public String chooseColor (int color) {
        String res = "";

        switch (color) {
            case 1: res = "red";
                break;
            case 2: res = "green";
                break;
            case 3: res = "blue";
                break;
            case 4: res = "yellow";
                break;
        }
        return res;
    }

    public boolean placeSquare() {
        boolean res = false;

        Random r = new Random();
        int x0 = r.nextInt(this.largeur - 1);
        int y0 = r.nextInt(this.hauteur - 1);
        int color = r.nextInt(4) + 1;
        String color2 = chooseColor(color);

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

                this.colors[x0][y0] = new Case();
                this.colors[x0][y0].setColor(color2);
                this.colors[x0][y0 + 1] = new Case();
                this.colors[x0][y0 + 1].setColor(color2);
                this.colors[x0 + 1][y0] = new Case();
                this.colors[x0 + 1][y0].setColor(color2);
                this.colors[x0 + 1][y0 + 1] = new Case();
                this.colors[x0 + 1][y0 + 1].setColor(color2);

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
        int color = r.nextInt(4) + 1;
        String color2 = chooseColor(color);

        LetterL letterL1 = new LetterL(this, x0, y0);
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

                this.colors[x0][y0] = new Case();
                this.colors[x0][y0].setColor(color2);
                this.colors[x0 + 1][y0] = new Case();
                this.colors[x0 + 1][y0].setColor(color2);
                this.colors[x0 + 1][y0 + 1] = new Case();
                this.colors[x0 + 1][y0 + 1].setColor(color2);

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
        int color = r.nextInt(4) + 1;
        String color2 = chooseColor(color);

        LetterL letterL2 = new LetterL(this, x0, y0);
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

                this.colors[x0][y0] = new Case();
                this.colors[x0][y0].setColor(color2);
                this.colors[x0][y0 + 1] = new Case();
                this.colors[x0][y0 + 1].setColor(color2);
                this.colors[x0 + 1][y0] = new Case();
                this.colors[x0 + 1][y0].setColor(color2);

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
        int color = r.nextInt(4) + 1;
        String color2 = chooseColor(color);

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

                this.colors[x0][y0] = new Case();
                this.colors[x0][y0].setColor(color2);
                this.colors[x0][y0 + 1] = new Case();
                this.colors[x0][y0 + 1].setColor(color2);
                this.colors[x0][y0 + 2] = new Case();
                this.colors[x0][y0 + 2].setColor(color2);
                this.colors[x0][y0 + 3] = new Case();
                this.colors[x0][y0 + 3].setColor(color2);

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
        int color = r.nextInt(4) + 1;
        String color2 = chooseColor(color);

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

                this.colors[x0][y0] = new Case();
                this.colors[x0][y0].setColor(color2);
                this.colors[x0 + 1][y0] = new Case();
                this.colors[x0 + 1][y0].setColor(color2);
                this.colors[x0 + 2][y0] = new Case();
                this.colors[x0 + 2][y0].setColor(color2);
                this.colors[x0 + 3][y0] = new Case();
                this.colors[x0 + 3][y0].setColor(color2);

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
        int color = r.nextInt(4) + 1;
        String color2 = chooseColor(color);

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

                this.colors[x0][y0] = new Case();
                this.colors[x0][y0].setColor(color2);
                this.colors[x0][y0 + 1] = new Case();
                this.colors[x0][y0 + 1].setColor(color2);
                this.colors[x0][y0 + 2] = new Case();
                this.colors[x0][y0 + 2].setColor(color2);
                this.colors[x0 + 1][y0 + 1] = new Case();
                this.colors[x0 + 1][y0 + 1].setColor(color2);

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
            colors[0][i] = new Case();
            colors[0][i].setColor("white");
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


            for (int i = 0; i < this.largeur; i++) {
                for (int j = 0; j < this.hauteur; j++) {
                    if (this.cases[i][j] == false) {
                        int color = r.nextInt(3) + 1;
                        String color2 = chooseColor(color);

                        valeurs[i][j] = r.nextInt(4);
                        colors[i][j] = new Case();
                        colors[i][j].setColor(color2);
                        cases[i][j] = true;
                    }
                }
            }
        }

//      on rajoute 4 animaux
      /*  all = 0;
        while (all < 4) {
            int animal = r.nextInt(largeur-1);
            if (couleurs[0][animal]!=9) {
                couleurs[0][animal] = 9;
                all++;
        }
        }*/
        all=0;
        while(all<4) {
            int animal = r.nextInt(largeur-1);
            if(!colors[0][animal].getColor().equals("black")) {
                colors[0][animal].setColor("black");
                colors[0][animal].isAnimal = true;
                all++;
            }
        }

    }

    public void placeShapesL2() {
        // on met des 0 a la premiere ligne
        for (int i = 0; i< largeur; i++) {
            cases[0][i] = true;
            colors[0][i] = new Case();
            colors[0][i].setColor("white");
        }

        int all = 0;
        Random r = new Random();

        while (all < 5) {
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


            for (int i = 0; i < this.largeur; i++) {
                for (int j = 0; j < this.hauteur; j++) {
                    if (this.cases[i][j] == false) {
                        int color = r.nextInt(4) + 1;
                        String color2 = chooseColor(color);
                        valeurs[i][j] = r.nextInt(4);
                        colors[i][j] = new Case();
                        colors[i][j].setColor(color2);
                        cases[i][j] = true;
                    }
                }
            }
        }

//      on rajoute 4 animaux
      /*  all = 0;
        while (all < 4) {
            int animal = r.nextInt(largeur-1);
            if (couleurs[0][animal]!=9) {
                couleurs[0][animal] = 9;
                all++;
        }
        }*/
        all=0;
        while(all<4) {
            int animal = r.nextInt(largeur-1);
            if(!colors[0][animal].getColor().equals("black")) {
                colors[0][animal].setColor("black");
                colors[0][animal].isAnimal = true;
                all++;
            }
        }

    }

    public void placeShapesL3() {
        // on met des 0 a la premiere ligne
        for (int i = 0; i< largeur; i++) {
            cases[0][i] = true;
            colors[0][i] = new Case();
            colors[0][i].setColor("white");
        }

        int all = 0;
        Random r = new Random();

        while (existsEmptyCell()) {


            for (int i = 0; i < this.largeur; i++) {
                for (int j = 0; j < this.hauteur; j++) {
                    if (this.cases[i][j] == false) {
                        int color = r.nextInt(4) + 1;
                        String color2 = chooseColor(color);
                        valeurs[i][j] = r.nextInt(4);
                        colors[i][j] = new Case();
                        colors[i][j].setColor(color2);
                        cases[i][j] = true;
                    }
                }
            }
        }

//      on rajoute 4 animaux
      /*  all = 0;
        while (all < 4) {
            int animal = r.nextInt(largeur-1);
            if (couleurs[0][animal]!=9) {
                couleurs[0][animal] = 9;
                all++;
        }
        }*/
        all=0;
        while(all<4) {
            int animal = r.nextInt(largeur-1);
            if(!colors[0][animal].getColor().equals("black")) {
                colors[0][animal].setColor("black");
                colors[0][animal].isAnimal = true;
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
                System.out.print(colors[i][j]);
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

    public boolean Voisine_Left(int i , int j) {
        if(j==0)return false;
//  		if(couleurs[i][j]==couleurs[i][j-1])return true;
        if(colors[i][j].getColor().equals(colors[i][j-1].getColor()))return true;
        return false;
    }

    public boolean Voisine_Right(int i , int j) {
        if(j==largeur-1) {return false;}
//  		if(couleurs[i][j]==couleurs[i][j+1])return true;
        if(colors[i][j].getColor().equals(colors[i][j+1].getColor()))return true;
        return false;
    }


    public boolean Voisine_Up(int i , int j) {
        if(i==0)return false;
//  		if(couleurs[i][j]==couleurs[i-1][j])return true;
        if(colors[i][j].getColor().equals(colors[i-1][j].getColor()))return true;
        return false;
    }

    public boolean Voisine_Down(int i , int j) {
        if(i==hauteur-1)return false;
//  		if(couleurs[i][j]==couleurs[i+1][j])return true;
        if(colors[i][j].getColor().equals(colors[i+1][j].getColor()))return true;
        return false;
    }


    public void eliminer_Voisines(int i, int j) {



        if(Voisine_Left(i,j)&&!colors[i][j].getColor().equals("black")) {tab[i][j-1]=7;}
        if(Voisine_Right(i,j)&&!colors[i][j].getColor().equals("black")) {tab[i][j+1]=7;}
        if(Voisine_Up(i,j)&&!colors[i][j].getColor().equals("black")) {tab[i-1][j]=7;}
        if(Voisine_Down(i,j)&&!colors[i][j].getColor().equals("black")) {tab[i+1][j]=7;}
        if ((Voisine_Left(i,j)||Voisine_Right(i,j)||Voisine_Up(i,j)||Voisine_Down(i,j))&&!colors[i][j].getColor().equals("black") )tab[i][j]=7;


    }

    public boolean isOneCell (int x, int y) {
        return (!Voisine_Down(x, y) && !Voisine_Up(x, y) && !Voisine_Left(x, y) && !Voisine_Right(x, y));
    }

    public void from() {

        System.out.println("You came here");

    }


    public void use_tab() {

        for(int i=0;i<8;i++) {

            for(int j=0;j<8;j++) {
                if (tab[i][j]==7) {


                    eliminer_Voisines(i,j);
                }}
        }
    }

    public void reinit_tab()
    {
        for(int i=0;i<hauteur;i++) {
            for(int j=0;j<largeur;j++) {
                tab[i][j]=0;
            }
        }


    }





    public void affichetab() {
        for(int i=0;i<8;i++) {

            for(int j=0;j<8;j++) {
                System.out.print(tab[i][j]);}


            System.out.println();
        }
    }





    @SuppressWarnings("deprecation")
    public void reorganisation()

    {

//        this.setChanged();
//        this.notifyObservers();
        for(int i=0;i<largeur;i++) {
            for(int j=0;j<hauteur;j++) {
                if(tab[i][j]==7 ) {
//			    couleurs[i][j]=0;
                    colors[i][j] = new Case();
                    colors[i][j].setColor("white");
                }
            }
        }
    }

    public boolean NoGaps(int col) {
        for(int i=1;i<hauteur;i++)
        { if(
//		        couleurs[i-1][col]!= 0 && couleurs[i][col]==0
                !colors[i-1][col].getColor().equals("white") && colors[i][col].getColor().equals("white")
        )
            return false;}
        return true;
    }

    public void reorganiser_down(int col) {
//        this.setChanged();
//        this.notifyObservers();
        int i=0;
//		colors[i][col] = new Case();
        if(colonne_estVide(col)) {System.out.println("La colonne est vide, réorganiser à gauche");return;}
        while(i<hauteur-1) {
            if(/*couleurs[i][col]==0*/ colors[i][col].getColor().equals("white") ) {i++;}
            else if(/*couleurs[i][col]!=0 && couleurs[i+1][col]==0*/
                    !colors[i][col].getColor().equals("white") && colors[i+1][col].getColor().equals("white")
            ) { reorganiser_bas_bis(i,col);i++;}
            else i++;
        }
        while (!NoGaps(col))reorganiser_down(col);}

    public void reorganiser_bas_bis(int ligne,int col) {

        if(ligne<hauteur && /*couleurs[ligne+1][col]==0*/ colors[ligne+1][col].getColor().equals("white")) {

//		couleurs[ligne+1][col]=couleurs[ligne][col];
            colors[ligne+1][col].setColor(colors[ligne][col].getColor());
//		couleurs[ligne][col]=0;
            colors[ligne][col].setColor("white");
        }
    }

    public boolean colonne_estVide(int col) {
        int i=0;
        while(/*i<hauteur-1 && couleurs[i][col]==0*/i<hauteur-1 && colors[i][col].getColor().equals("white"))i++;
        if( /*couleurs[i][col]!=0*/
                !colors[i][col].getColor().equals("white")) return false;
        return true;
    }



    public void reorganiser_Àgauche(int col) {
        if(col>=1 && col<largeur-1 && colonne_estVide(col-1))
        {
            for(int i=0;i<hauteur;i++) {
		/*couleurs[i][col-1]=couleurs[i][col];
		couleurs[i][col]=0;*/
                colors[i][col-1].setColor(colors[i][col].getColor());
                colors[i][col].setColor("white");
                reorganiser_Àgauche(col+1);
            }
        }}
    /****For the controller ****/
    public int[][] getTab() {

        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if (this.colors[i][j].getColor().equals("white")) this.couleurs[i][j]=0;
                if(this.colors[i][j].getColor().equals("red")) this.couleurs[i][j]=1;
                if(this.colors[i][j].getColor().equals("green")) this.couleurs[i][j]=2;
                if(this.colors[i][j].getColor().equals("purple")) this.couleurs[i][j]=3;
            }
        }
        return couleurs;
    }
    /******Fonctions de jeu ****/
    /* Fonction qui regarde si il y'a des colonnes vide*/
    /*  (pousser à gauche) par conséquent*/
//    public void pushToLeft() {
//        this.setChanged();
//        this.notifyObservers();
////        for(int j=0;j<largeur-1;j++) {
//            for(int j=0;j<largeur-2;j++) {
//                if(this.colonne_estVideV1(j) && )
//            {this.reorganiser_Àgauche(j+1);}
//        }}

    public void pushToLeft() {
        int cpt = 0;

        for(int j=0;j<largeur;j++) {
//            if(this.colonne_estVideV1(j) && !this.colonne_estVideV1(j+1))

            for (int i = 0; i < 8; i++) {
                if (colors[i][j].getColor().equals("white")) {
                    cpt++;
                }}
                if (cpt == 8) {
                    System.out.println("colonne vide : " + j);
//                    this.reorganiserAgauche(j);
                    for (int i =0; i< 8 && j != 7; i++) {
                        this.colors[i][j].setColor(this.colors[i][j+1].getColor());
                        this.colors[i][j+1].setColor("white");
                    }
//                    return;
                }
                cpt = 0;



        }
    }
    /* > */
    @SuppressWarnings("deprecation")

    public void reorganiserAgauche(int col){


        if(col <=largeur-2 &&  col>=0 &&  this.colonne_estVideV1(col)){

            for(int i=0;i<hauteur;i++){
//this.couleurs[i][col]=couleurs[i][col+1];
//this.couleurs[i][col+1]=0;
                colors[i][col].setColor(colors[i][col+1].getColor());
                colors[i][col+1].setColor("white");
            }
//            this.reorganiserAgauche(col+1);
        }

    }

    public boolean NoColonnesVides() {
        for(int j=0;j<=largeur-2;j++) {

            if(this.colonne_estVideV1(j) && !this.colonne_estVideV1(j+1))return false;

        }
        return true;
    }
    public boolean colonne_estVideV1(int col) {
        boolean res = true;

        int i=0;
        //while(i<hauteur && (couleurs[i][col]==0 ))i++;
        while(i<hauteur && (this.colors[i][col].equals("white")))i++;
        //if (i<hauteur && couleurs[i][col]!=0 ) return false;
        if(i<hauteur && !this.colors[i][col].equals("white")) {
//            System.out.println("zzzpppz");
            res = false;
        }
//        System.out.println("wwwwwwwwwwwwww");
        return res;
    }

    /* descendre */
    public void goDown() {
//        this.setChanged();
//        this.notifyObservers();
        for(int j=0;j<largeur;j++)
        //Si cette colonne a des vides(mal rangée)(faut descendre)
        { if(! this.NoGaps(j)) {
            System.out.println("BONJOUR");
            this.reorganiser_down(j);
        }
        }
    }


    public void tryit(int i,int j) {
        //this.pushToLeft();

        this.init();
        this.reinit_tab();
        this.eliminer_Voisines(i, j);
        for(int x=0;x<64;x++) {
            this.use_tab();}
        this.reorganisation();
        this.goDown();
        //Case [][] a =this.colors;

        System.out.println("* * PREMIER AFFICHAGE * * * ");
        this.displayColors();

        this.pushToLeft();
        System.out.println("* * * * * * * ");
        this.displayColors();
        this.setChanged();
        this.notifyObservers();

    }

    /* nb c le nombre des animaux posés */
    public  boolean IfAllSaved(int nb) {
        int cpt=0;
        for(int j=0;j<largeur;j++) {
            if(this.justAnimal(j)) {
                cpt=cpt+count_animals(j);}
        }
        if(nb==cpt)	return true;
        return false;
    }
    /* Compte le nombre d'animaux dans la colonne col*/
    public int count_animals(int col) {
        int cpt=0;
        for(int i=0;i<hauteur;i++) {
            if(/*couleurs[i][col]==9*/
                    colors[i][col].getColor().equals("black"))cpt++;}
        return cpt;
    }
    /* dis si il y a juste des animaux et des vides dans col*/
    public boolean justAnimal(int col) {

        for(int i=0;i<hauteur;i++) {
            if(//couleurs[i][col]!=0 && couleurs[i][col]!=9
                    !colors[i][col].getColor().equals("white")&&!colors[i][col].getColor().equals("black"))return false;
        }
        return true;
    }



    /* à faire */
    public boolean jeuGagne(int nb) {
        if (this.IfAllSaved(nb)) {
            System.out.println("You winned !");
            return true;
        }
        System.out.println("Sorry, try again !");
        return false;

    }
    /********For the Controller ******/
    public void initForCHange() {
        clickedOn=new int[1][2];
    }
    public void fillForChange(int i, int j) {
        // clickedOn=new int[1][2];

        clickedOn[0][1]=i;
        clickedOn[0][1]=j;

    }
    /***** 	Let's just try for the controller*****/
    public void move() {
        setChanged();
        this.notifyObservers();
        Random r = new Random();
        int v= r.nextInt(8);
        X=v;
        //X=65;
    }
    /*****************************************/



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
        System.out.println("*** *** *** *** *** *** ");
        System.out.println("COLORS : " + p.colors[1][0]);
        System.out.println("here" + p.colors[0][1].getColor());
//        Joueur j = new Joueur();
//        Partie partie = new Partie(j, p);
//        partie.Jouer();*/

    }
}




