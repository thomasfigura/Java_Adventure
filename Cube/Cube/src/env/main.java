package env;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {
    public static void main(String[] args) throws InterruptedException{
        Enviorment envi = new Enviorment();
        JFrame application = new JFrame("Wall");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(envi);
        application.setSize(400,400);
        application.setVisible(true);
        while(true){
            Thread.sleep(100);
            envi.repaint();
        }
    }  
}
