package src;


import javax.swing.*;
import java.awt.*;


public class MyBoardComponent extends JComponent {
  public void paintComponent(Graphics g) {
    g.drawOval(50,50,100,100);
  }
  public Dimension getPreferredSize() {
    return new Dimension(200,200);
  }
  public static void main(String args[]) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          JFrame f = new JFrame("Test");
          f.getContentPane().add(new MyBoardComponent());
          f.pack();
          f.setVisible(true);
        }
      });                       
  }
}

