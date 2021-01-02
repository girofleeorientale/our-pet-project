package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
	
	
	
	
	
	
	public static void main(String []args) {
       
		EventQueue.invokeLater(()-> {
		Plateau p= new Plateau(8,8);
            BoardView boardView = new BoardView(p, 2);
           // CellView cellView = new CellView(8, 8 , new Color(0,6,0));
            JFrame frame = new JFrame();
            JButton start = new JButton("start");
            JPanel FirstPage= new JPanel();
            FirstPage.add(start);
            frame.add(FirstPage);
            
            
            frame.setSize(500, 500);
    		frame.setVisible(true);
    		 start.addActionListener(new ActionListener()
    		    {
    		      public void actionPerformed(ActionEvent e)
    		      {
    		        
    		        
    		      
    		      Controller c= null;
    	            try {
    	            	
    	                c = new Controller(p,boardView);
    	               
    	                
    	            } catch (FileNotFoundException e1) {
    	                e1.printStackTrace();
    	            }
    		        
    		      }
    		    });
            
          /* Controller c= null;
            try {
                c = new Controller(p, boardView);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }*/

        });
    }

	
	}
	 
	 
	 
	


