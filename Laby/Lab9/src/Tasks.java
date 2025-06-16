import javax.swing.*;
import GUI.GUI;

import java.awt.*;

public class Tasks {
    public void Task1() {
            JFrame frame = new JFrame("Zadanie1");
            GUI gui1 = new GUI();
            gui1.getMainPanel().setPreferredSize(new Dimension(800, 600));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(gui1.getMainPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        public void Task2() {
            JFrame frame = new JFrame("Zadanie2");
            GUI2 gui2 = new GUI2();
            gui2.getMainPanel2().setPreferredSize(new Dimension(800, 600));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(gui2.getMainPanel2());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }

