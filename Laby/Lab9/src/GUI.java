package GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class GUI {
    private JPanel mainPanel;
    private JTextField celsiusField;
    private JTextField fahrenheitField;
    private JButton convertButton;

    public GUI() {
        convertButton.addActionListener(this::convertTemperature);
    }

    private void convertTemperature(ActionEvent e) {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = (celsius * 9/5) + 32;
            fahrenheitField.setText(String.format("%.2f", fahrenheit));

        } catch (NumberFormatException e2) {
            JOptionPane.showMessageDialog(mainPanel, "Niepoprawna wartosc temperatury!", "Bład", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}