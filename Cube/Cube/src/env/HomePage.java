package env;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomePage extends JFrame {
    JFrame home;

    public HomePage(int width, int height) {
        home = new JFrame("Home");
        home.setSize(width, height);
        home.setVisible(true);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Start");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    startDrawing();
                } catch (Exception t) {
                }
            }
        });



        home.add(button);
    }

    public void startDrawing() throws InterruptedException {
        Enviorment envi = new Enviorment();
        JFrame application = new JFrame("Wall");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(envi);
        application.setSize(400, 400);
        application.setVisible(true);
        home.add(application);
        while (true) {
            envi.repaint();
        }
    }
}
