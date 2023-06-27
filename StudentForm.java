import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;

public class StudentForm extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
	private JLabel numberLabel, nameLabel;
    private JTextField numberField, nameField;
    private JButton submitButton;

    public StudentForm() {
        setTitle("Student Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        nameLabel = new JLabel("Name:");
        numberLabel = new JLabel("Registration Number:");

        nameField = new JTextField(20);
        numberField = new JTextField(20);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Set background color for the submission button
        submitButton.setBackground(Color.ORANGE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(numberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(numberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(submitButton, gbc);

        add(panel);

        pack(); // Adjusts the window size 
        setPreferredSize(new Dimension(500, 250)); // Set the preferred size of the window
        setResizable(false); // Prevent the window resizing
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String number = numberField.getText();
            String name = nameField.getText();

            // Check for empty fields
            if (name.isEmpty() || number.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Both fields must be filled.");
                return;
            }

            // name length
            if (name.length() > 15) {
                JOptionPane.showMessageDialog(this, "Name should be up to 15 characters.");
                return; 
            }

            // number length
            if (number.length() > 15) {
                JOptionPane.showMessageDialog(this, "Number should be up to 15 characters.");
                return; 
            }

            // Display a prompt for successful submission
            JOptionPane.showMessageDialog(this, "Submission successful!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StudentForm form = new StudentForm();
                form.setVisible(true);
            }
        });
    }
}