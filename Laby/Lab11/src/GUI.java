import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;

public class GUI {
    private JList<String> list1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton saveNowButton;
    private JButton saveExistingButton;
    private JPanel panel;
    private DefaultListModel<String> model1;

    public GUI() {
        model1 = new DefaultListModel<>();
        list1 = new JList<>(model1);

        textField1 = new JTextField(20); // Name
        textField2 = new JTextField(20); // Email
        textField3 = new JTextField(20); // Phone
        textField4 = new JTextField(20); // Address
        textField5 = new JTextField(20); // Birthdate

        saveNowButton = new JButton("Save New");
        saveExistingButton = new JButton("Save Existing");
        saveExistingButton.setEnabled(false);

        panel = new JPanel(new BorderLayout());
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(new JLabel("Person List:"), BorderLayout.NORTH);
        listPanel.add(new JScrollPane(list1), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(textField1);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(textField2);
        formPanel.add(new JLabel("Phone:"));
        formPanel.add(textField3);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(textField4);
        formPanel.add(new JLabel("Birth Date (YYYY-MM-DD):"));
        formPanel.add(textField5);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveNowButton);
        buttonPanel.add(saveExistingButton);
        panel.add(listPanel, BorderLayout.WEST);
        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedPerson = list1.getSelectedValue();
                    if (selectedPerson != null) {
                        String[] parts = selectedPerson.split(", ");
                        if (parts.length >= 5) {
                            textField1.setText(parts[0]);
                            textField2.setText(parts[1]);
                            textField3.setText(parts[2]);
                            textField4.setText(parts[3]);
                            textField5.setText(parts[4]);
                            saveExistingButton.setEnabled(true);
                        }
                    }
                }
            }
        });
        saveNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText().trim();
                String email = textField2.getText().trim();
                String phone = textField3.getText().trim();
                String address = textField4.getText().trim();
                String birthdate = textField5.getText().trim();

                if (isAnyFieldEmpty(name, email, phone, address, birthdate)) {
                    JOptionPane.showMessageDialog(panel, "Fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    LocalDate.parse(birthdate);
                    model1.addElement(name + ", " + email + ", " + phone + ", " + address + ", " + birthdate);
                    clearFields();
                } catch (DateTimeException ex) {
                    JOptionPane.showMessageDialog(panel, "Invalid date!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        saveExistingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list1.getSelectedIndex();
                if (selectedIndex != -1) {
                    String name = textField1.getText().trim();
                    String email = textField2.getText().trim();
                    String phone = textField3.getText().trim();
                    String address = textField4.getText().trim();
                    String birthdate = textField5.getText().trim();

                    if (isAnyFieldEmpty(name, email, phone, address, birthdate)) {
                        JOptionPane.showMessageDialog(panel, "Fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        LocalDate.parse(birthdate);
                        model1.set(selectedIndex, name + ", " + email + ", " + phone + ", " + address + ", " + birthdate);
                        list1.clearSelection();
                        clearFields();
                        saveExistingButton.setEnabled(false);
                    } catch (DateTimeException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid date!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private boolean isAnyFieldEmpty(String... fields) {
        for (String field : fields) {
            if (field.isEmpty()) return true;
        }
        return false;
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
    }

    public JPanel getPanel() {
        return panel;
    }
}
