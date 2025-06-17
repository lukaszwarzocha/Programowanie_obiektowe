import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JTextField textField1;
    private JTextField textField2;
    private JButton OKButton;
    private JPanel panel;
    private JLabel enterPasswordLabel;
    private JLabel confirmPasswordLabel;

    public GUI() {
        panel = new JPanel(new GridLayout(3,2,15,15));
        enterPasswordLabel = new JLabel("Enter Password");
        confirmPasswordLabel = new JLabel("Confirm Password");
        textField1 = new JPasswordField();
        textField2 = new JPasswordField();
        OKButton = new JButton("OK");

        panel.add(enterPasswordLabel);
        panel.add(textField1);
        panel.add(confirmPasswordLabel);
        panel.add(textField2);
        panel.add(OKButton);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password1 = textField1.getText();
                String password2 = textField2.getText();

                if (password1.isEmpty() || password2.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill all the fields!");
                    return;
                }

                if (!password1.equals(password2)) {
                    JOptionPane.showMessageDialog(panel, "Password are not mached!");
                    return;
                }

                if(!password1.equals("strongpassword")) {
                    JOptionPane.showMessageDialog(panel, "Wrong password!");
                    return;
                }

                JOptionPane.showMessageDialog(panel, "Congratulations! You entered the correct password.");
            }
        });
    }
    public JPanel getPanel() {
        return panel;
    }
}
