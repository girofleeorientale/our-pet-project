package model;



import java.io.Serializable;
import java.util.*;

import view.BoardView;

import java.util.*;

public class Plateau extends Observable implements Serializable {
    private int hauteur;
    private int largeur;
    // cases = false : la case est vide; cases = true : la case est remplie
    private boolean[][] cases;
    // dans etats 0 = vide, 1 = couleur; 2 = animal
    private int[][] etats;
    // int [][] couleurs indique les etats
    private int[][] couleurs;
    // valeurs pour les shapes (carre - 1, L - 2, T - 3, I horizontal/vertical - 4)
    private int[][] valeurs;
    private int[][] tab ;
    private Case[][] colors;
    public int [][] clickedOn;   // ??????
    public int X;    // ??????
    private int stockFusee;
    private int saveScore;
    public int level=1;   // ??????
    public boolean LevelUp=false;  // ??????
    int nbcoups=0;  // ??????
    private int obstaclesNumber;
    private boolean isWinner;
    private int animalsNumber;

    public Plateau(int hauteur, int largeur) {
        //this.addObserver((Observer) view);
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.isWinner = false;
        this.cases = new boolean[hauteur][largeur];
        this.etats = new int[hauteur][largeur];
        this.couleurs = new int[hauteur][largeur];
        this.valeurs = new int[hauteur][largeur];
        this.colors = new Case[hauteur][largeur];
    }

    public Plateau(int hauteur, int largeur, int level, int stockFusee, int obstaclesNumber, int animalsNumber) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.stockFusee = stockFusee;
        this.level = level;
        this.animalsNumber= animalsNumber;
        this.obstaclesNumber = obstaclesNumber;
        this.cases = new boolean[hauteur][largeur];
        this.etats = new int[hauteur][largeur];
        this.couleurs = new int[hauteur][largeur];
        this.valeurs = new int[hauteur][largeur];
        this.colors = new Case[hauteur][largeur];
    }

    public int getHauteur() {
        return this.hauteur;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public void setHauteur (int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur (int largeur) {
        this.largeur = largeur;
    }

    public boolean [][] getCases () {
        return this.cases;
    }


    public Case [][] getColors () {
        return this.colors;
    }

    public int getStockFusee () {
        return this.stockFusee;
    }

    public void setStockFusee(int s) {
        this.stockFusee = s;
    }

    public int getSaveScore() {
        return this.saveScore;
    }

    public void setObstaclesNumber (int x) {
        this.obstaclesNumber = x;
    }

    public boolean getIsWinner() {
        return this.isWinner;
    }

    public int getAnimalsNumber() {
        return this.animalsNumber;
    }

    public void setAnimalsNumber(int animalsNumber) {
        this.animalsNumber = animalsNumber;
    }

    public void displayColors1() {
        for (int i = 0; i <hauteur; i++) {
            for (int j = 0; j <largeur; j++) {
                System.out.print(couleurs[i][j]);
            }
            System.out.println();
        }
    }

    
    public void init() {
        tab = new int [this.hauteur][this.largeur];
    }

    public String chooseColor (int color) {
        String res = "";

        switch (color) {
            case 1: res = "red";
                break;
            case 2: res = "green";
                break;
            case 3: res = "blue";
               //res="purple";
                break;
            case 4: res = "yellow";
                break;
        }
        return res;
    }

    public void Erase() {
    	for(int i=0;i<hauteur;i++) {
    		for(int j=0;j<largeur;j++) {
    			this.colors[i][j].setColor("white");
    			this.couleurs[i][j]=0;
    			this.tab[i][j]=0;
    			this.cases[i][j]=false;
    	}
    	
    }}
    
    public void removeAnimal1 () {
        for (int i = 0; i< hauteur; i++) {
            for (int j =0; j< largeur; j++) {
                if (animalCameDown(i,j)) {
                    
                    colors[i][j].setColor("white");
                    
                }
            }
        }
       
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

//     
        all=0;
        while(all<this.animalsNumber) {
            int animal = r.nextInt(largeur-1);
            int rand = r.nextInt(2);
            if(!colors[0][animal].getColor().equals("black") && !colors[0][animal].getColor().equals("rose")) {
                if (rand == 0) {
                    colors[0][animal].setColor("black");
                }
                else if (rand == 1) {
                    colors[0][animal].setColor("rose");
                }
                colors[0][animal].setIsAnimal(true);
                all++;
            }
        }
        
        //On rajoute des obstacles
     //  this.filleObstacles(5);
//        this.buildObstacles();
       // this.buildObstacles();
        /*******************/
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
            int choice = r.nextInt(7);

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

//     
        all=0;
        while(all<this.animalsNumber) {
            int animal = r.nextInt(largeur-1);
            if(!colors[0][animal].getColor().equals("black")) {
                colors[0][animal].setColor("black");
                colors[0][animal].setIsAnimal(true);
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
        while(all<this.animalsNumber) {
            int animal = r.nextInt(largeur-1);
            if(!colors[0][animal].getColor().equals("black")) {
                colors[0][animal].setColor("black");
                colors[0][animal].setIsAnimal(true);
                all++;
            }
        }

    }

    public void placeShapesL4() {
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

//
        all=0;
        while(all<this.animalsNumber) {
            int animal = r.nextInt(largeur-1);
            if(!colors[0][animal].getColor().equals("black")) {
                colors[0][animal].setColor("black");
                colors[0][animal].setIsAnimal(true);
                all++;
            }
        }

        //On rajoute des obstacles
        this.filleObstacles(this.obstaclesNumber);
//        this.buildObstacles();
        // this.buildObstacles();
        /*******************/
    }

    public void placeShapesL5() {
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

//
        all=0;
        while(all<this.animalsNumber) {
            int animal = r.nextInt(largeur-1);
            if(!colors[0][animal].getColor().equals("black")) {
                colors[0][animal].setColor("black");
                colors[0][animal].setIsAnimal(true);
                all++;
            }
        }

        this.buildObstacles();

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
    	System.out.println("      -0--1--2--3--4--5--6--7-");
        for (int i = 0; i <hauteur; i++) {
        	System.out.println(" ");
        	System.out.print("   -"+i+"-");
            for (int j = 0; j <largeur; j++) {
                System.out.print("|"+colors[i][j]+"|");
            }
            System.out.println("");
        }
    }

    public void afficherEtats() {
        for (int i = 0; i < hauteur; i++) {
        
            for (int j = 0; j < largeur; j++) {
                System.out.print(etats[i][j]);
            }
            
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
   

    public boolean Voisine_Left(int i , int j) {
        if(j==0)return false;

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

        if(colors[i][j].getColor().equals(colors[i-1][j].getColor()))return true;
        return false;
    }

    public boolean Voisine_Down(int i , int j) {
        if(i==hauteur-1)return false;

        if(colors[i][j].getColor().equals(colors[i+1][j].getColor()))return true;
        return false;
    }


    public void eliminer_Voisines(int i, int j) {



 if(Voisine_Left(i,j)&&!colors[i][j].getColor().equals("black")&&!colors[i][j].getColor().equals("marron") ) {tab[i][j-1]=7;}
 if(Voisine_Right(i,j)&&!colors[i][j].getColor().equals("black")&&!colors[i][j].getColor().equals("marron")) {tab[i][j+1]=7;}
 if(Voisine_Up(i,j)&&!colors[i][j].getColor().equals("black")&&!colors[i][j].getColor().equals("marron")) {tab[i-1][j]=7;}
 if(Voisine_Down(i,j)&&!colors[i][j].getColor().equals("black")&&!colors[i][j].getColor().equals("marron")) {tab[i+1][j]=7;}
if ((Voisine_Left(i,j)||Voisine_Right(i,j)||Voisine_Up(i,j)||Voisine_Down(i,j))&&!colors[i][j].getColor().equals("black") &&!colors[i][j].getColor().equals("marron"))tab[i][j]=7;


    }

    public boolean animalCameDown (int x, int y) {
        return (colors[x][y].getColor().equals("black") && x == hauteur-1);
    }

    public void showDescendu (int x, int y) {
        if (animalCameDown(x,y)) {
           
        }}

    int tabl[][]= new int[8][8];
    public void removeAnimal () {
        for (int i = 0; i< hauteur; i++) {
            for (int j =0; j< largeur; j++) {
                if (animalCameDown(i,j)) {
                    
                    colors[i][j].setColor("orange");
                    tabl[i][j]=6;
                }
            }
        }
        pushToLeft();
    }

    public boolean isOneCell (int x, int y) {
        return (!Voisine_Down(x, y) && !Voisine_Up(x, y) && !Voisine_Left(x, y) && !Voisine_Right(x, y));
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

        for(int i=0;i<largeur;i++) {
            for(int j=0;j<hauteur;j++) {
                if(tab[i][j]==7 ) {

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
                !colors[i-1][col].getColor().equals("white") && colors[i][col].getColor().equals("white")&& !colors[i-1][col].getColor().equals("marron")
        )
            return false;}
        return true;
    }

    public void reorganiser_down(int col) {

        int i=0;

        if(colonne_estVide(col)) {System.out.println("La colonne est vide, réorganiser à gauche");return;}
        while(i<hauteur-1) {
            if( colors[i][col].getColor().equals("white")|| colors[i][col].getColor().equals("marron")) {i++;}
            else if(!colors[i][col].getColor().equals("white") && colors[i+1][col].getColor().equals("white")
            ) { reorganiser_bas_bis(i,col);i++;}
            else i++;
        }
        while (!NoGaps(col))reorganiser_down(col);}

    public void reorganiser_bas_bis(int ligne,int col) {

        if(ligne<hauteur && colors[ligne+1][col].getColor().equals("white")) {


            colors[ligne+1][col].setColor(colors[ligne][col].getColor());

            colors[ligne][col].setColor("white");
        }
    }

    public boolean colonne_estVide(int col) {
        int i=0;
while(i<hauteur-1 && colors[i][col].getColor().equals("white")||colors[i][col].getColor().equals("marron"))i++;
       
  if (!colors[i][col].getColor().equals("white") && !colors[i][col].getColor().equals("marron")) return false;
        return true;
    }



    
		
    /****For the controller ****/
    public void getTab() {

        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if (this.colors[i][j].getColor().equals("white")) this.couleurs[i][j]=0;
                if(this.colors[i][j].getColor().equals("red")) this.couleurs[i][j]=1;
                if(this.colors[i][j].getColor().equals("green")) this.couleurs[i][j]=2;
                if(this.colors[i][j].getColor().equals("blue")) this.couleurs[i][j]=3;
                if(this.colors[i][j].getColor().equals("yellow")) this.couleurs[i][j]=4;
                if(this.colors[i][j].getColor().equals("black"))this.couleurs[i][j]=9;
                if(this.colors[i][j].getColor().equals("rose"))this.couleurs[i][j]=9;
                if(this.colors[i][j].getColor().equals("marron"))this.couleurs[i][j]=8;
            }}}
       
        
    
    


    public void pushToLeftbis() {

        for(int j=0;j<largeur-2;j++) {
            if(this.colonne_estVideV1(j) && !this.colonne_estVideV1(j+1))
            {   System.out.println("la colonne est " +j);
                this.reorganiserAgauche(j);}
        }
        if(!this.NoColonnesVides())this.pushToLeft();


    }

    public void pushToLeft() {
        int cpt = 0;

        for(int j=0;j<largeur;j++) {
            

            for (int i = 0; i < 8; i++) {
                if (colors[i][j].getColor().equals("white")) {
                    cpt++;
                }}
            if (cpt == 8) {
                System.out.println("colonne vide : " + j);

                for (int i =0; i< 8 && j != 7; i++) {
                    this.colors[i][j].setColor(this.colors[i][j+1].getColor());
                    this.colors[i][j+1].setColor("white");
                }

            }
            cpt = 0;



        }
    }
    /* > */
    @SuppressWarnings("deprecation")

    public void reorganiserAgauche(int col){


        if(col <=largeur-2 &&  col>=0 &&  this.colonne_estVideV1(col)){

            for(int i=0;i<hauteur;i++){

            	if(!this.colors[i][col].getColor().equals("marron") &&!this.colors[i][col+1].getColor().equals("marron"))
                { 
            		colors[i][col].setColor(colors[i][col+1].getColor());
                colors[i][col+1].setColor("white");}
            }
            this.reorganiserAgauche(col+1);
        }

    }

    public boolean NoColonnesVides() {
        for(int j=0;j<=largeur-2;j++) {

            if(this.colonne_estVideV1(j) && !this.colonne_estVideV1(j+1))return false;

        }
        return true;
    }
   
    public boolean colonne_estVideV1(int col) {
        int i=0;
        
        while(i<hauteur && (this.colors[i][col].getColor().equals("white") ||colors[i][col].getColor().equals("marron")))i++;
       
        if(i<hauteur &&(!this.colors[i][col].getColor().equals("white")&&!this.colors[i][col].getColor().equals("marron")))return false;
        return true;

    }



    
    public void goDown() {

        for(int j=0;j<largeur;j++)
        //Si cette colonne a des vides(mal rangée)(faut descendre)
        { if(! this.NoGaps(j)) {
            
            this.reorganiser_down(j);
        }
        }
    }


    @SuppressWarnings("deprecation")

    public void tryit(boolean apply,int i,int j) {
        this.removeAnimal();
        //this.pushToLeft();
        this.nbcoups++;
        this.init();
        this.reinit_tab();
        this.displayColors();
        if(apply== true && this.stockFusee<=0)System.out.println("Plus de fusees !");
        if(apply==true && this.stockFusee>=1) {
        	System.out.println("il ya des fusées"+this.stockFusee);
        	this.AppliquerFusee(i, j, apply);
        	this.stockFusee--;}
        
        
        
        
      if(apply==false) {  this.eliminer_Voisines(i, j);
        for(int x=0;x<64;x++) {
            this.use_tab();}}
        this.reorganisation();
        System.out.println("Voilà votre score pour ce Coup" + this.CalculerScoreCoup());
        this.saveScore=this.saveScore+this.CalculerScoreCoup();
        System.out.println("Voilà votre Score Totale" + this.saveScore);
        this.goDown();
      // this.Shift_animal();
        //this.removeAnimal();
        this.pushToLeftbis();
        //this.Shift_animal();
        //if(this.nbcoups==2)this.AddAnimals(3);
       // this.removeAnimal();
         
        
        if(this.jeuGagne(this.animalsNumber)) {
//            this.LevelUp=true;
            isWinner = true;
        }

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

    public int compter() {
        int cpt=0;
        for(int i=0;i<largeur;i++) {
            for(int j=0;j<largeur;j++) {
                if (this.colors[i][j].getColor().equals("black"))cpt++;
            }
        }
        return cpt;
    }
    public boolean AllSaved(int nb) {
        for(int i=0;i<hauteur;i++) {
            for(int j=0;j<largeur;j++) {
                if(this.colors[i][j].getColor().equals("black"))return false;
            }}
        return true;
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
        if (this.AllSaved(nb)) {
           // System.out.println("You won !");
            return true;
        }
        
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
    /*****Fonction Fusee*****//* <>*/
    public boolean RespectsBounds(int x, int y) {
        if(x<hauteur && x>=0 && y>=0 && y<largeur) return true;
        return false;
    }
    public int  CalculerScoreCoup() {
        int Score=0;
        for(int i=0;i<hauteur;i++) {
            for(int j=0;j<largeur;j++) {
                if (tab[i][j]==7) Score+=30;}}

        return Score;
    }




    public void AppliquerFusee(int x, int y,boolean apply) {
        if(apply==true)
        {
            if (RespectsBounds(x,y)) {this.colors[x][y].setColor("white");this.tab[x][y]=7;}
            if (RespectsBounds(x+1,y)) {this.colors[x+1][y].setColor("white");this.tab[x+1][y]=7;}
            if (RespectsBounds(x-1,y)) {this.colors[x-1][y].setColor("white");this.tab[x-1][y]=7;}
            if (RespectsBounds(x,y+1)) {this.colors[x][y+1].setColor("white");this.tab[x][y+1]=7;}
            if (RespectsBounds(x,y-1)) {this.colors[x][y-1].setColor("white");this.tab[x][y-1]=7;}
            if (RespectsBounds(x-1,y-1)) {this.colors[x-1][y-1].setColor("white");this.tab[x-1][y-1]=7;}
            if (RespectsBounds(x+1,y+1)) {this.colors[x+1][y+1].setColor("white");this.tab[x+1][y+1]=7;}
            if (RespectsBounds(x+1,y-1)) {this.colors[x+1][y-1].setColor("white");this.tab[x+1][y-1]=7;}
            if (RespectsBounds(x-1,y+1)) {this.colors[x-1][y+1].setColor("white");this.tab[x-1][y+1]=7;}
        }

    }
    
    
    public void filleObstacles(int nombre) {
    	
//      	 for(int i=0;i<nombre;i++)
//      	 {
      	     int cpt = nombre;
           Random x = new Random();
           while (cpt != 0) {
               int k = x.nextInt(7)+1;
               int z = x.nextInt(7)+1;
               if (!this.colors[k][z].getColor().equals("black")) {
                   this.colors[k][z].setColor("marron");
                   cpt--;
               }
           }

      	 }
    
    
    
    
    /******************Shift Animal *******/
    
    public void Shift_animal() {
	
	 for(int i=1;i<hauteur;i++) {
		  for(int j=1;j<largeur;j++) {
 
if(colors[i][j].getColor().equals("marron") &&colors[i-1][j].getColor().equals("black")&& colors[i][j-1].getColor().equals("white"))
	{int c=j-1;
	int l=i+1;
	
while(colors[l-1][c].getColor().equals("white")&&colors[l][c].getColor().equals("marron")&&c>=1&&l<hauteur-1) {
colors[l-1][c+1].setColor("white"); 
 colors[l-1][c].setColor("black");
l++;
c--;
}
	 if(colors[l-1][c].getColor().equals("black")) this.pushAndGoDown(l-1, c);
		
	 }}}}
	 

	

public void pushAndGoDown(int i, int j) {
	// couleurs[i][j]=0;
	colors[i][j].setColor("white");
	//while(i<hauteur &&couleurs[i][j-1]==0 )i++;
	while(i<hauteur && colors[i][j-1].getColor().equals("white"))i++;
    //if(i<hauteur && couleurs[i][j-1]!=0)couleurs[i-1][j-1]=9;
	if(i<hauteur && !colors[i][j-1].getColor().equals("white"))
		colors[i-1][j-1].setColor("black");
}

public void buildObstacles() {
	
	Random random = new Random();
	int i=2+random.nextInt(3);
	int j=2+random.nextInt(3);
	this.colors[i][j].setColor("marron");
	this.colors[i][j+1].setColor("marron");
	this.colors[i][j+2].setColor("marron");
	this.colors[i][j-1].setColor("marron");
	this.colors[i+1][j].setColor("marron");
	this.colors[i+2][j].setColor("marron");
	
}
 public void AddAnimals(int nb) {
	 for(int i=0;i<nb;i++) {
		 Random random= new Random();
		int x=1+random.nextInt(6);
		int y=1+random.nextInt(6);
		 this.colors[x][y].setColor("black");
 }
 }





    
    
    
    
    /***********************************************/

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





