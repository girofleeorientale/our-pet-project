package controller;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

import model.Plateau;
import util.SerializationUtil;
import view.BoardView;
import java.io.File;
import java.util.List;
import java.util.Scanner;


public class Launch extends JFrame {


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

    public static void startNextLevel (int level) throws FileNotFoundException {
        for (List<Integer> l :findLevel()) {
            if (l.get(0) == level + 1) {
                Plateau pTmp = new Plateau(8, 8, l.get(0), l.get(1), l.get(2), l.get(3));
                BoardView boardView = new BoardView(pTmp /*, l.get(0)*/);
                Controller controller = new Controller(pTmp /*boardView, l.get(0)*/);
            }
        }
    }

    public static void main(String []args) {

        EventQueue.invokeLater(()-> {

            Plateau p= new Plateau(8,8);
            JFrame frame = new JFrame("Pet Rescue");
            JButton restore = new JButton("restore");
            BackgroundPanel FirstPage= new BackgroundPanel();

            FirstPage.add(restore);

            try {
                for (List<Integer> l :findLevel()){
                    Plateau pTmp= new Plateau(8,8,l.get(0), l.get(1), l.get(2), l.get(3));
                    JButton levelTmp = new JButton("level " + l.get(0));
                    levelTmp.addActionListener(new MyActionListener(pTmp /*, boardView,l.get(0))*/));
                    FirstPage.add(levelTmp);
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            frame.add(FirstPage);

            frame.setSize(500, 500);
            frame.setVisible(true);
            restore.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Plateau newPlateau = SerializationUtil.deserialize();
                        new Controller(newPlateau);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
            });

        });
    }

    static class MyActionListener implements ActionListener {
        int level;
        Plateau plateau;
        BoardView boardView;
        public  MyActionListener (Plateau plateau) {
            this.level=level;
//            this.boardView = boardView;
            this.plateau = plateau;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller c= null;
            c = new Controller(plateau);
        }
    }
}




