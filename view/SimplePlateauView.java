package view;
import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JComponent;

import model.Plateau;
public class SimplePlateauView extends JComponent implements Vue {
private Plateau grille;

public SimplePlateauView(Plateau grille) {
	this.grille=grille;
}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		 // render the grid
		
		  int cellSize = 32; // hard coded
		  g.setColor(new Color(0, 0.5f, 0, 0.75f));
		  for (int i = 0; i <= grille.getLargeur(); i++) {
		   g.drawLine(i * cellSize, 0, i * cellSize, grille.getHauteur() * cellSize);
			 
		   if (i <= grille.getLargeur())
		   g.drawLine(0, i * cellSize, grille.getLargeur() * cellSize, i * cellSize);
		  }
		  g.setColor(new Color(0, 0, 1f));
		  for (int i=0;i<grille.getHauteur();i++) {
			  for(int j=0;j<grille.getLargeur();j++) {
		   int x = (int) (i * cellSize) + 2;
		   int y = (int) (j* cellSize) + 2;
		   g.fillOval(x, y, cellSize - 4, cellSize - 4);}}
		  }
		  
		  
		  
		  
		  }
	

