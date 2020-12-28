package view;

import javax.swing.*;
import java.awt.*;

public class CellView extends JPanel {
    int x;
    int y;
    Color color;

    public CellView (int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.setSize(10,10);
        this.setBackground(color);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);
    }


}
