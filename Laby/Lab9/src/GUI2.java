import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class GUI2 {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public GUI2() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel1, "Hello", "Komunikat", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel1, new Date(), "Aktualna data", JOptionPane.PLAIN_MESSAGE);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();
            }
        });
    }

        public JPanel getMainPanel2() {
            return panel1;
        }
    }

