package view;import java.awt.*; 
import javax.swing.*; 
import java.awt.geom.Line2D; 
  

import model.Plateau;

public class Test {

	
	
	
	
	public static void main(String [] args) {
		Plateau p=new Plateau(8,8);
		SimplePlateauView s = new SimplePlateauView(p);
		
		
		JFrame window = new JFrame(); 
		  
	    // setting closing operation 
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	    // setting size of the pop window 
	    window.setBounds(30, 30, 200, 200); 

	    // setting canvas for draw 
	    window.getContentPane().add(new SimplePlateauView(p)); 

	    // set visibility 
	    window.setVisible(true); 
		
		
	}
}
