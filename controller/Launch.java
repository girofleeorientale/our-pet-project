package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Plateau;
import view.BoardView;
import view.CellView;

public class Launch extends JFrame {
	
	
	
	
	
	
	public static void main(String []args) {
       
		EventQueue.invokeLater(()-> {
		Plateau p= new Plateau(8,8);
            BoardView boardView = new BoardView(p, 1);
        CellView cellView = new CellView(9, 9 , new Color(0,6,0));
            Controller c= null;
            try {
                c = new Controller(p,boardView);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            c.ChangeColor(5, 5);
      
        
        });
    }

	
	}
	 
	 
	 
	


