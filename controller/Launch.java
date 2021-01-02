package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Plateau;
import view.BoardView;
import view.CellView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Launch extends JFrame {




    public static ArrayList<List<Integer>> findLevel () throws FileNotFoundException {
        File devFile = new File("levels.txt");
        Scanner devScanner = new Scanner(devFile);
        ArrayList<List<Integer>> res = new ArrayList<>();
        while (devScanner.hasNext()) {
            String nextLine = devScanner.nextLine();
            String[] devData = nextLine.split(",");
            res.add(Arrays.asList(Integer.parseInt(devData[0]), Integer.parseInt(devData[2])));
        }
        return res;
    }

    public static void main(String []args) {

        EventQueue.invokeLater(()-> {

            Plateau p= new Plateau(8,8);
//            Plateau p1= new Plateau(8,8, 2);
            BoardView boardView = new BoardView(p, 3);
            // CellView cellView = new CellView(8, 8 , new Color(0,6,0));
            JFrame frame = new JFrame();
            JButton start = new JButton("start");
//            JButton level1 = new JButton("first level");
            JPanel FirstPage= new JPanel();
            FirstPage.setBackground(new Color(0, 89, 87));
            FirstPage.add(start);

            try {
                for (List<Integer> l :findLevel()){
                    Plateau pTmp= new Plateau(8,8, l.get(1));
                    JButton levelTmp = new JButton(l.get(0) + " level");
                    levelTmp.addActionListener(new MyActionListener(pTmp, boardView,l.get(0)));
                    FirstPage.add(levelTmp);
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            frame.add(FirstPage);

            frame.setSize(500, 500);
            frame.setVisible(true);
            start.addActionListener(new MyActionListener(p, boardView, 1));

//            level1.addActionListener(new MyActionListener(p1, boardView, 1));

          /* Controller c= null;
            try {
                c = new Controller(p, boardView);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }*/

        });
    }

    static class MyActionListener implements ActionListener {
        int level;
        Plateau plateau;
        BoardView boardView;
        public  MyActionListener (Plateau plateau, BoardView boardView, int level) {
            this.level=level;
            this.boardView = boardView;
            this.plateau = plateau;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller c= null;
            try {
                c = new Controller(plateau,boardView, level);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }


}




