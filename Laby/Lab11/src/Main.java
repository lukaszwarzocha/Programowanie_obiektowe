import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Zadanie 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GUI().getPanel());
        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}