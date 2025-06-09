


/*class AddAssignmentPanel extends JPanel {
    JTextField assignmentField;
    AssignmentPanel assignmentPanel;

    public AddAssignmentPanel(AssignmentPanel assignmentPanel) {
        this.assignmentPanel = assignmentPanel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(173, 216, 230));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel label = new JLabel("Enter Assignment Name:");
        label.setFont(new Font("Segoe UI",  Font.BOLD | Font.ITALIC, 24));
        assignmentField = new JTextField(20);
        assignmentField.setMaximumSize(new Dimension(400, 40));
        JButton addButton = new JButton("Add Assignment ➕");


        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        assignmentField.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(label);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(assignmentField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(addButton);
        add(Box.createVerticalGlue());

        addButton.addActionListener(e -> {
            String text = assignmentField.getText();
            if (!text.isEmpty()) {
                assignmentPanel.addAssignment(text);
                JOptionPane.showMessageDialog(this, "Assignment Added: " + text);
                assignmentField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter an assignment name.");
            }
        });
    }
}*/
/*class AddAssignmentPanel extends JPanel {
    JTextField assignmentField;
    JTextField dueDateField;
    AssignmentPanel assignmentPanel;

    public AddAssignmentPanel(AssignmentPanel assignmentPanel) {
        this.assignmentPanel = assignmentPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(173, 216, 230)); 
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel label = new JLabel("Enter Assignment Name:");
        label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        assignmentField = new JTextField(20);
        assignmentField.setMaximumSize(new Dimension(400, 40));
        assignmentField.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        JLabel dateLabel = new JLabel("Enter Due Date (YYYY-MM-DD):");
        dateLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22));
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        dueDateField = new JTextField(20);
        dueDateField.setMaximumSize(new Dimension(400, 40));
        dueDateField.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        JButton addButton = new JButton("Add Assignment ➕");
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(label);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(assignmentField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(dateLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(dueDateField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(addButton);
        add(Box.createVerticalGlue());

        addButton.addActionListener(e -> {
            String name = assignmentField.getText();
            String date = dueDateField.getText();
            if (!name.isEmpty() && !date.isEmpty()) {
                assignmentPanel.addAssignment(name, date);
                JOptionPane.showMessageDialog(this, "✅ Assignment Added: " + name + " (Due: " + date + ")");
                assignmentField.setText("");
                dueDateField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "❌ Please fill both fields.");
            }
        });
    }
}
*/



import javax.swing.*;
import java.awt.*;

class AddAssignmentPanel extends JPanel {
    public AddAssignmentPanel(AssignmentPanel assignmentPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(173, 216, 230)); 

       
        JLabel titleLabel = new JLabel("🌟 Add New Assignment 🌟");
        titleLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 32));
        titleLabel.setForeground(new Color(34, 85, 34));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 30, 10));

      
        JPanel formPanel = new JPanel();
        formPanel.setBackground(new Color(240, 255, 240)); 
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 179, 113), 3, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        formPanel.setLayout(new GridLayout(4, 2, 20, 20));
        formPanel.setMaximumSize(new Dimension(500, 300));
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        JLabel nameLabel = new JLabel("📖 Assignment Name:");
        nameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        JTextField nameField = createRoundedTextField();

        JLabel dueDateLabel = new JLabel("📅 Due Date (DD/MM/YYYY):");
        dueDateLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        JTextField dueDateField = createRoundedTextField();

        JLabel descriptionLabel = new JLabel("📝 Description:");
        descriptionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        JTextField descriptionField = createRoundedTextField();

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(dueDateLabel);
        formPanel.add(dueDateField);
        formPanel.add(descriptionLabel);
        formPanel.add(descriptionField);

       
        JButton addButton = new JButton("➕ Add Assignment");
        addButton.setBackground(new Color(102, 205, 170)); 
        addButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        addButton.setFocusPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setPreferredSize(new Dimension(200, 50));
        addButton.setMaximumSize(new Dimension(300, 50));
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String date = dueDateField.getText();
            if (!name.isEmpty() && !date.isEmpty()) {
                assignmentPanel.addAssignment(name, date);
                JOptionPane.showMessageDialog(this, "✅ Assignment Added: " + name + " (Due: " + date + ")");
                nameField.setText("");
                dueDateField.setText("");
                descriptionField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "❌ Please fill both fields.");
     } });
        /*addButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Assignment '" + nameField.getText() + "' added successfully! 🎉",
                "Success", JOptionPane.INFORMATION_MESSAGE);
            nameField.setText("");
            dueDateField.setText("");
            descriptionField.setText("");
        });*/

        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(formPanel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(addButton);
    }

    private JTextField createRoundedTextField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(152, 251, 152), 2, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return textField;
    }
}

