package env;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {
    public static void main(String[] args) throws InterruptedException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomePage h = new HomePage(400, 400);
            }
        });
    }
}
