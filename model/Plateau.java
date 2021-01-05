package model;

import java.io.Serializable;
import java.util.*;


public class Plateau extends Observable implements Serializable {
    private int hauteur;
    private int largeur;
    // cases = false : la case est vide; cases = true : la case est remplie
    private boolean[][] cases;
    // int [][] couleurs indique les etats
    private int[][] couleurs;
    // valeurs pour les shapes (carre - 1, L - 2, T - 3, I horizontal/vertical - 4)
    private int[][] valeurs;
    private int[][] tab;
    private Case[][] colors;
    private int stockFusee;
    private int saveScore;
    private int level;
    private int obstaclesNumber;
    private boolean isWinner;
    private boolean isLooser;
    private int animalsNumber;

    public Plateau(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.isWinner = false;
        this.isLooser = false;
        this.cases = new boolean[hauteur][largeur];
        this.couleurs = new int[hauteur][largeur];
        this.valeurs = new int[hauteur][largeur];
        this.colors = new Case[hauteur][largeur];
    }

    public Plateau(int hauteur, int largeur, int level, int stockFusee, int obstaclesNumber, int animalsNumber) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.stockFusee = stockFusee;
        this.level = level;
        this.animalsNumber = animalsNumber;
        this.obstaclesNumber = obstaclesNumber;
        this.cases = new boolean[hauteur][largeur];
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

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public Case[][] getColors() {
        return this.colors;
    }

    public boolean[][] getCases() {
        return this.cases;
    }

    public int getStockFusee() {
        return this.stockFusee;
    }

    public void setStockFusee(int s) {
        this.stockFusee = s;
    }

    public int getSaveScore() {
        return this.saveScore;
    }

    public void setObstaclesNumber(int x) {
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

    public int getLevel() {
        return this.level;
    }

    public boolean getIsLooser () {
        return this.isLooser;
    }

    public void displayColors1() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                System.out.print(couleurs[i][j]);
            }
            System.out.println();
        }
    }


    public void init() {
        tab = new int[this.hauteur][this.largeur];
    }

    public String chooseColor(int color) {
        String res = "";

        switch (color) {
            case 1:
                res = "red";
                break;
            case 2:
                res = "green";
                break;
            case 3:
                res = "blue";
                break;
            case 4:
                res = "yellow";
                break;
        }
        return res;
    }

    public void erase() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                this.colors[i][j].setColor("white");
                this.couleurs[i][j] = 0;
                this.tab[i][j] = 0;
                this.cases[i][j] = false;
            }
        }
    }

    /******* Les fonctions pour remplir le plateau *******/

    public boolean placeSquare() {
        boolean res = false;

        Random r = new Random();
        int x0 = r.nextInt(this.largeur - 1);
        int y0 = r.nextInt(this.hauteur - 1);
        int color = r.nextInt(4) + 1;
        String color2 = chooseColor(color);

        Carre carre = new Carre(x0, y0);

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

        LetterL letterL1 = new LetterL(x0, y0);

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

        LetterL letterL2 = new LetterL(x0, y0);

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

        LetterIHorizontal letterIH = new LetterIHorizontal(x0, y0);

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

        LetterIVertical letterIV = new LetterIVertical(x0, y0);

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

        LetterTHorizontal letterTHorizontal = new LetterTHorizontal(x0, y0);

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
        for (int i = 0; i < largeur; i++) {
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
                    if (!this.cases[i][j]) {
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

        all = 0;
        while (all < this.animalsNumber) {
            int animal = r.nextInt(largeur - 1);
            int rand = r.nextInt(2);
            if (!colors[0][animal].getColor().equals("azure") && !colors[0][animal].getColor().equals("orchid")) {
                if (rand == 0) {
                    colors[0][animal].setColor("azure");
                } else if (rand == 1) {
                    colors[0][animal].setColor("orchid");
                }
                colors[0][animal].setIsAnimal(true);
                all++;
            }
        }
    }

    public void placeShapesL2() {
        // on met des 0 a la premiere ligne
        for (int i = 0; i < largeur; i++) {
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
                    if (!this.cases[i][j]) {
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

        all = 0;
        while (all < this.animalsNumber) {
            int animal = r.nextInt(largeur - 1);
            int rand = r.nextInt(2);
            if (!colors[0][animal].getColor().equals("azure") && !colors[0][animal].getColor().equals("orchid")) {
                if (rand == 0) {
                    colors[0][animal].setColor("azure");
                } else if (rand == 1) {
                    colors[0][animal].setColor("orchid");
                }
                colors[0][animal].setIsAnimal(true);
                all++;
            }
        }
    }

    public void placeShapesL3() {
        // on met des 0 a la premiere ligne
        for (int i = 0; i < largeur; i++) {
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


        all = 0;
        while (all < this.animalsNumber) {
            int animal = r.nextInt(largeur - 1);
            int rand = r.nextInt(2);
            if (!colors[0][animal].getColor().equals("azure") && !colors[0][animal].getColor().equals("orchid")) {
                if (rand == 0) {
                    colors[0][animal].setColor("azure");
                } else if (rand == 1) {
                    colors[0][animal].setColor("orchid");
                }
                colors[0][animal].setIsAnimal(true);
                all++;
            }
        }
    }

    public void placeShapesL4() {
        // on met des 0 a la premiere ligne
        for (int i = 0; i < largeur; i++) {
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
                    if (!this.cases[i][j]) {
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

        all = 0;
        while (all < this.animalsNumber) {
            int animal = r.nextInt(largeur - 1);
            int rand = r.nextInt(2);
            if (!colors[0][animal].getColor().equals("azure") && !colors[0][animal].getColor().equals("orchid")) {
                if (rand == 0) {
                    colors[0][animal].setColor("azure");
                } else if (rand == 1) {
                    colors[0][animal].setColor("orchid");
                }
                colors[0][animal].setIsAnimal(true);
                all++;
            }
        }

        //On rajoute des obstacles
        this.fillObstacles(this.obstaclesNumber);
    }

    public void placeShapesL5() {
        // on met des 0 a la premiere ligne
        for (int i = 0; i < largeur; i++) {
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
                    if (!this.cases[i][j]) {
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

        all = 0;
        while (all < this.animalsNumber) {
            int animal = r.nextInt(largeur - 1);
            int rand = r.nextInt(2);
            if (!colors[0][animal].getColor().equals("azure") && !colors[0][animal].getColor().equals("orchid")) {
                if (rand == 0) {
                    colors[0][animal].setColor("azure");
                } if (rand == 1) {
                    colors[0][animal].setColor("orchid");
                }
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
                if (!this.cases[i][j]) {
                    res = true;
                }
            }
        }
        return res;
    }

    /****** Les fonctions d'affichage ******/

    public void displayColors() {
        System.out.println("      -0--1--2--3--4--5--6--7-");
        for (int i = 0; i < hauteur; i++) {
            System.out.println(" ");
            System.out.print("   -" + i + "-");
            for (int j = 0; j < largeur; j++) {
                System.out.print("|" + colors[i][j] + "|");
            }
            System.out.println("");
        }
    }

    public void displayValues() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                System.out.print(valeurs[i][j]);
            }
            System.out.println();
        }
    }

    /****** Fonctions de suppression et reorganisation ******/

    public boolean neighbourLeft(int i, int j) {
        if (j == 0) return false;

        if (colors[i][j].getColor().equals(colors[i][j - 1].getColor())) return true;
        return false;
    }

    public boolean neighbourRight(int i, int j) {
        if (j == largeur - 1) {
            return false;
        }
        if (colors[i][j].getColor().equals(colors[i][j + 1].getColor())) return true;
        return false;
    }


    public boolean neighbourUp(int i, int j) {
        if (i == 0) return false;

        if (colors[i][j].getColor().equals(colors[i - 1][j].getColor())) return true;
        return false;
    }

    public boolean neighbourDown(int i, int j) {
        if (i == hauteur - 1) return false;

        if (colors[i][j].getColor().equals(colors[i + 1][j].getColor())) return true;
        return false;
    }


    public void deleteNeighbours(int i, int j) {

        if (neighbourLeft(i, j) && !colors[i][j].getColor().equals("azure") && !colors[i][j].getColor().equals("marron") &&
        !colors[i][j].getColor().equals("orchid")) {
            tab[i][j - 1] = 7;
        }
        if (neighbourRight(i, j) && !colors[i][j].getColor().equals("azure") && !colors[i][j].getColor().equals("marron") &&
                !colors[i][j].getColor().equals("orchid")) {
            tab[i][j + 1] = 7;
        }
        if (neighbourUp(i, j) && !colors[i][j].getColor().equals("azure") && !colors[i][j].getColor().equals("marron") &&
                !colors[i][j].getColor().equals("orchid")) {
            tab[i - 1][j] = 7;
        }
        if (neighbourDown(i, j) && !colors[i][j].getColor().equals("azure") && !colors[i][j].getColor().equals("marron") &&
                !colors[i][j].getColor().equals("orchid")) {
            tab[i + 1][j] = 7;
        }
        if ((neighbourLeft(i, j) || neighbourRight(i, j) || neighbourUp(i, j) || neighbourDown(i, j)) && !colors[i][j].getColor().equals("azure")
                && !colors[i][j].getColor().equals("marron") && !colors[i][j].getColor().equals("orchid"))
            tab[i][j] = 7;

    }


    public boolean isOneCell(int x, int y) {
        return (!neighbourDown(x, y) && !neighbourUp(x, y) && !neighbourLeft(x, y) && !neighbourRight(x, y));
    }


    public void useTab() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (tab[i][j] == 7) {
                    deleteNeighbours(i, j);
                }
            }
        }
    }

    public void reinitTab() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                tab[i][j] = 0;
            }
        }
    }


    @SuppressWarnings("deprecation")
    public void reorganisation() {
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                if (tab[i][j] == 7) {
                    colors[i][j] = new Case();
                    colors[i][j].setColor("white");
                }
            }
        }
    }

    public boolean noGaps(int col) {
        for (int i = 1; i < hauteur; i++) {
            if (!colors[i - 1][col].getColor().equals("white") &&
                    colors[i][col].getColor().equals("white") && !colors[i - 1][col].getColor().equals("marron"))
                return false;
        }
        return true;
    }

    public void reorganizeDown(int col) {

        int i = 0;

        if (columnIsEmpty(col)) {
            System.out.println("La colonne est vide, réorganiser à gauche");
            return;
        }
        while (i < hauteur - 1) {
            if (colors[i][col].getColor().equals("white") || colors[i][col].getColor().equals("marron")) {
                i++;
            } else if (!colors[i][col].getColor().equals("white") && colors[i + 1][col].getColor().equals("white")
            ) {
                reorganizeDownBis(i, col);
                i++;
            } else i++;
        }
        while (!noGaps(col)) reorganizeDown(col);
    }

    public void reorganizeDownBis(int ligne, int col) {

        if (ligne < hauteur && colors[ligne + 1][col].getColor().equals("white")) {
            colors[ligne + 1][col].setColor(colors[ligne][col].getColor());
            colors[ligne][col].setColor("white");
        }
    }

    public boolean columnIsEmpty(int col) {
        int i = 0;
        while (i < hauteur - 1 && colors[i][col].getColor().equals("white") || colors[i][col].getColor().equals("marron"))
            i++;

        if (!colors[i][col].getColor().equals("white") && !colors[i][col].getColor().equals("marron")) return false;
        return true;
    }

    /******* Pour la partie ******/

    // tableau colors en chiffres :
    public void getTab() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.colors[i][j].getColor().equals("white")) this.couleurs[i][j] = 0;
                if (this.colors[i][j].getColor().equals("red")) this.couleurs[i][j] = 1;
                if (this.colors[i][j].getColor().equals("green")) this.couleurs[i][j] = 2;
                if (this.colors[i][j].getColor().equals("blue")) this.couleurs[i][j] = 3;
                if (this.colors[i][j].getColor().equals("yellow")) this.couleurs[i][j] = 4;
                if (this.colors[i][j].getColor().equals("azure")) this.couleurs[i][j] = 9;
                if (this.colors[i][j].getColor().equals("orchid")) this.couleurs[i][j] = 9;
                if (this.colors[i][j].getColor().equals("marron")) this.couleurs[i][j] = 8;
            }
        }
    }


    public void pushToLeftbis() {

        for (int j = 0; j < largeur - 2; j++) {
            if (this.columnIsEmpty1(j) && !this.columnIsEmpty1(j + 1)) {
                this.reorganizeToLeft(j);
            }
        }
        if (!this.noEmptyColumns()) this.pushToLeft();
    }

    public void pushToLeft() {
        int cpt = 0;
        for (int j = 0; j < largeur; j++) {
            for (int i = 0; i < 8; i++) {
                if (colors[i][j].getColor().equals("white")) {
                    cpt++;
                }
            }
            if (cpt == 8) {
                for (int i = 0; i < 8 && j != 7; i++) {
                    if (!this.colors[i][j + 1].getColor().equals("marron")) {
                        this.colors[i][j].setColor(this.colors[i][j + 1].getColor());
                        this.colors[i][j + 1].setColor("white");
                    }
                }

            }
            cpt = 0;
        }
    }


    @SuppressWarnings("deprecation")

    public void reorganizeToLeft(int col) {

        if (col <= largeur - 2 && col >= 0 && this.columnIsEmpty1(col)) {
            for (int i = 0; i < hauteur; i++) {
                if (!this.colors[i][col].getColor().equals("marron") && !this.colors[i][col + 1].getColor().equals("marron")) {
                    colors[i][col].setColor(colors[i][col + 1].getColor());
                    colors[i][col + 1].setColor("white");
                }
            }
            this.reorganizeToLeft(col + 1);
        }
    }

    public boolean noEmptyColumns() {
        for (int j = 0; j <= largeur - 2; j++) {
            if (this.columnIsEmpty1(j) && !this.columnIsEmpty1(j + 1)) return false;
        }
        return true;
    }

    public boolean columnIsEmpty1(int col) {
        int i = 0;
        while (i < hauteur && (this.colors[i][col].getColor().equals("white"))) i++;
        if (i < hauteur && !this.colors[i][col].getColor().equals("white")) return false;
        return true;
    }

    public void goDown() {
        for (int j = 0; j < largeur; j++)
        //Si cette colonne a des vides(mal rangée)(il faut descendre)
        {
            if (!this.noGaps(j)) {
                this.reorganizeDown(j);
            }
        }
    }

    @SuppressWarnings("deprecation")

    public void play(boolean apply, int i, int j) {
        this.init();
        this.reinitTab();
        this.displayColors();
//        if(apply== true && this.stockFusee<=0)System.out.println("Plus de fusees !");
        if (apply == true && this.stockFusee >= 1) {
//        	System.out.println("il ya des fusées"+this.stockFusee);
            this.applyRocket(i, j, apply);
            this.stockFusee--;
        }

        if (apply == false) {
            this.deleteNeighbours(i, j);
            for (int x = 0; x < hauteur * largeur; x++) {
                this.useTab();
            }
        }
        this.reorganisation();
//        System.out.println("Voilà votre score pour ce Coup" + this.CalculerScoreCoup());
        this.saveScore = this.saveScore + this.calculateScore();
//        System.out.println("Voilà votre Score Totale" + this.saveScore);
        this.goDown();

        this.shiftAnimal();
        this.removeAnimal();
        this.pushToLeftbis();

        if (this.jeuGagne(this.animalsNumber)) {
            isWinner = true;
        }

        else if (this.jeuPerdu(this.animalsNumber)) {
            isLooser = true;
        }

        this.setChanged();
        this.notifyObservers();
    }

    public boolean AllSaved(int nb) {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (this.colors[i][j].getColor().equals("azure") || this.colors[i][j].getColor().equals("orchid"))
                    return false;
            }
        }
        return true;
    }

    public boolean jeuGagne(int animals) {
        if (this.AllSaved(animals)) {
            return true;
        }
        return false;
    }

    public boolean impossibleToWin (Plateau p) {
        boolean res = false;

        for (int i =0; i< hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (!isOneCell(i, j)) {
                    res = true;
                }
            }
        }

        return res;
    }

    public boolean jeuPerdu (int animals) {
        if (!AllSaved(animals) && (stockFusee == 0) && impossibleToWin(this)) {
            return true;
        }
        return false;
    }

    /*****Fonction Fusee*****//* <>*/
    public boolean respectsBounds(int x, int y) {
        if (x < hauteur && x >= 0 && y >= 0 && y < largeur) return true;
        return false;
    }

    public int calculateScore() {
        int Score = 0;
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (tab[i][j] == 7) Score += 30;
            }
        }

        return Score;
    }

    public void applyRocket(int x, int y, boolean apply) {
        if (apply) {
            if (respectsBounds(x, y)) {
                this.colors[x][y].setColor("white");
                this.tab[x][y] = 7;
            }
            if (respectsBounds(x + 1, y)) {
                this.colors[x + 1][y].setColor("white");
                this.tab[x + 1][y] = 7;
            }
            if (respectsBounds(x - 1, y)) {
                this.colors[x - 1][y].setColor("white");
                this.tab[x - 1][y] = 7;
            }
            if (respectsBounds(x, y + 1)) {
                this.colors[x][y + 1].setColor("white");
                this.tab[x][y + 1] = 7;
            }
            if (respectsBounds(x, y - 1)) {
                this.colors[x][y - 1].setColor("white");
                this.tab[x][y - 1] = 7;
            }
            if (respectsBounds(x - 1, y - 1)) {
                this.colors[x - 1][y - 1].setColor("white");
                this.tab[x - 1][y - 1] = 7;
            }
            if (respectsBounds(x + 1, y + 1)) {
                this.colors[x + 1][y + 1].setColor("white");
                this.tab[x + 1][y + 1] = 7;
            }
            if (respectsBounds(x + 1, y - 1)) {
                this.colors[x + 1][y - 1].setColor("white");
                this.tab[x + 1][y - 1] = 7;
            }
            if (respectsBounds(x - 1, y + 1)) {
                this.colors[x - 1][y + 1].setColor("white");
                this.tab[x - 1][y + 1] = 7;
            }
        }
    }


    public void fillObstacles(int nombre) {

        int cpt = nombre;
        Random x = new Random();
        while (cpt != 0) {
            int k = x.nextInt(7) + 1;
            int z = x.nextInt(7) + 1;
            if (!this.colors[k][z].getColor().equals("azure") || !this.colors[k][z].getColor().equals("orchid") ) {
                this.colors[k][z].setColor("marron");
                cpt--;
            }
        }
    }

    public void pushAndGoDown(int i, int j) {
        String res = colors[i][j].getColor();
        colors[i][j].setColor("white");
        while (i < hauteur && colors[i][j - 1].getColor().equals("white")) i++;
        if (i < hauteur && !colors[i][j - 1].getColor().equals("white"))
            colors[i - 1][j - 1].setColor(res);
    }

    public void buildObstacles() {
        Random random = new Random();
        int i = 2 + random.nextInt(3);
        int j = 2 + random.nextInt(3);
        this.colors[i][j].setColor("marron");
        this.colors[i][j + 1].setColor("marron");
        this.colors[i][j + 2].setColor("marron");
        this.colors[i][j - 1].setColor("marron");
        this.colors[i + 1][j].setColor("marron");
        this.colors[i + 2][j].setColor("marron");
    }

    /***************** Fonctions pour les animaux *******/

    public void shiftAnimal() {

        for (int i = 1; i < hauteur; i++) {
            for (int j = 1; j < largeur; j++) {
                if (colors[i][j].getColor().equals("marron") && (colors[i - 1][j].getColor().equals("azure")
                        || colors[i - 1][j].getColor().equals("orchid") ) && colors[i][j - 1].getColor().equals("white"))
                    pushAndGoDown(i - 1, j);
            }
        }
    }

    public boolean animalCameDown(int x, int y) {
        return ((colors[x][y].getColor().equals("azure") || colors[x][y].getColor().equals("orchid")) && x == hauteur - 1);
    }

    public void removeAnimal() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (animalCameDown(i, j)) {
                    colors[i][j].setColor("white");
                }
            }
        }
    }

    /***** Pour ameliorer plus tard ********/
    public void AddAnimals(int nb) {
        for (int i = 0; i < nb; i++) {
            Random random = new Random();
            int x = 1 + random.nextInt(6);
            int y = 1 + random.nextInt(6);
            this.colors[x][y].setColor("azure");
        }
    }

    public int countAnimals() {
        int cpt = 0;
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (this.colors[i][j].getColor().equals("azure")) cpt++;
            }
        }
        return cpt;
    }
}