package controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class BackgroundPanel extends JPanel
{
    Image image;
    public BackgroundPanel()
    {
        try
        {
            image = ImageIO.read(new File("cats.png"));;
        }
        catch (Exception e) { /*handled in paintComponent()*/ }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
    }
}
