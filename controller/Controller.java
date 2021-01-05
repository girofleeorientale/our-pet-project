package controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//Controler le plateau;
import model.Plateau;
import view.BoardView;
import view.CellView;

public class Controller extends JFrame implements MouseListener {
	private Plateau plateau;
	private BoardView view;
	private JFrame frame = new JFrame("Pet Rescue Saga");
	private JPanel p = new JPanel();
	private int j;   // ??????
	private int x0;
	private int y0;

	public Controller(Plateau p) {
		this.plateau=p;
		this.init();
	}

	public void init() {
		view = new BoardView(plateau);
		this.p=view.getGridPanel();
		this.frame.getContentPane().add(p);
		frame.setSize(500, 500);

		for(int i=0;i<plateau.getHauteur();i++) {
			for(int j=0;j<plateau.getLargeur();j++) {
				this.view.getCellViews()[i][j].addMouseListener(this);
			}
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		Object source = e.getSource();
		Object source1 =(CellView) source;
		/* Pour obtenir les coordonnees */
		System.out.println(((CellView) source1).getCordX());
		( (CellView) source1).getCordY();
		/*****************/
		this.x0=((CellView) source1).getCordX();
		this.y0 =((CellView) source1).getCordY();
		if(e.getButton()== MouseEvent.BUTTON3) {this.plateau.play(true, x0, y0);}
		else this.plateau.play(false,x0, y0);
		if (this.plateau.getIsWinner()) {
			this.frame.getContentPane().removeAll();
			this.frame.getContentPane().revalidate();
			this.frame.getContentPane().repaint();

			frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

			ImageIcon icon = new ImageIcon("sea.png");
			JLabel label2 = new JLabel(icon);
			label2.setAlignmentX(Component.CENTER_ALIGNMENT);

			this.frame.getContentPane().add(label2);

			JButton button = new JButton("next level");
			button.setAlignmentX(Component.CENTER_ALIGNMENT);

			JPanel jPanel = new JPanel();
			frame.getContentPane().add(jPanel);
			jPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

			jPanel.add(button);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Launch.startNextLevel(plateau.getLevel());
					} catch (FileNotFoundException fileNotFoundException) {
						fileNotFoundException.printStackTrace();
					}
				}
			});
		}

		if (this.plateau.getIsLooser()) {
			this.frame.getContentPane().removeAll();
			this.frame.getContentPane().revalidate();
			this.frame.getContentPane().repaint();

			frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

			ImageIcon icon = new ImageIcon("tt.jpg");
			JLabel label2 = new JLabel(icon);
			label2.setAlignmentX(Component.CENTER_ALIGNMENT);

			this.frame.getContentPane().add(label2);

			JButton button = new JButton("restart the same level");
			button.setAlignmentX(Component.CENTER_ALIGNMENT);

			JPanel jPanel = new JPanel();
			frame.getContentPane().add(jPanel);
			jPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

			jPanel.add(button);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Launch.startNextLevel(plateau.getLevel()-1);
					} catch (FileNotFoundException fileNotFoundException) {
						fileNotFoundException.printStackTrace();
					}
				}
			});
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent u) {
		// TODO Auto-generated method stub


	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
