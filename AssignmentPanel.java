//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;


/*class AssignmentPanel extends JPanel {
    DefaultListModel<String> assignmentList= new DefaultListModel<>();

    public AssignmentPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        assignmentList = new DefaultListModel<>();
        JList<String> list = new JList<>(assignmentList);
        list.setFont(new Font("Segoe UI", Font.BOLD, 18));

        assignmentList.addElement("Math Homework");
        assignmentList.addElement("Science Project");

        JLabel title = new JLabel("Your Assignments:");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
    }
    public void addAssignment(String assignmentName) {
        assignmentList.addElement(assignmentName);
    }
}*/
/*class AssignmentPanel extends JPanel {
    DefaultListModel<Assignment> assignmentList;
    JList<Assignment> list;

    public AssignmentPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        assignmentList = new DefaultListModel<>();
        list = new JList<>(assignmentList);
        list.setCellRenderer(new CheckboxListRenderer());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int index = list.locationToIndex(e.getPoint());
                Assignment a = assignmentList.getElementAt(index);
                a.completed = !a.completed;
                list.repaint();
            }
        });

        assignmentList.addElement(new Assignment("evs certificate", "2025-04-30"));
        assignmentList.addElement(new Assignment("Digital design quiz", "2025-05-05"));

        JLabel title = new JLabel("📚 Your Assignments:");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
    }

    public void addAssignment(String name, String dueDate) {
        assignmentList.addElement(new Assignment(name, dueDate));
    }


    static class CheckboxListRenderer extends JCheckBox implements ListCellRenderer<Assignment> {
        @Override
        public Component getListCellRendererComponent(JList<? extends Assignment> list, Assignment value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());
            setSelected(value.completed);
            setBackground(new Color(173, 216, 230));
           
            setFont(new Font("Segoe UI", Font.PLAIN, 18));
            return this;
        }
    }
}*/

//import javax.swing.*;
//import java.awt.*;




/*import java.util.ArrayList;

class AssignmentPanel extends JPanel {
    private JPanel listPanel;
    private ArrayList<JCheckBox> assignments;

    public AssignmentPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(224, 255, 255)); // Pastel blue background

        JLabel titleLabel = new JLabel("📚 Your Assignments 📚");
        titleLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 30));
        titleLabel.setForeground(new Color(25, 25, 112)); // Dark blue text
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

       //  public void addAssignment(String name, String dueDate) {
           // assignmentList.addElement(new Assignment(name, dueDate));
      //  }

        // List container
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(240, 248, 255)); // Light lighter pastel blue
        listPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(135, 206, 250), 3, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.getViewport().setBackground(new Color(240, 248, 255)); // same pastel color inside

        // List to keep checkboxes
        assignments = new ArrayList<>();

        // Test sample assignments
        addAssignment("Finish Java Project", "30/04/2025");
        addAssignment("Prepare for Quiz", "01/05/2025");
        addAssignment("Submit Assignment 3", "03/05/2025");

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(scrollPane);
        add(Box.createVerticalGlue());
    }

    public void addAssignment(String name, String dueDate) {
        JCheckBox assignmentBox = new JCheckBox("✏️ " + name + "  | Due: " + dueDate);
        assignmentBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        assignmentBox.setBackground(new Color(240, 248, 255));
        assignmentBox.setFocusPainted(false);
        assignmentBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        listPanel.add(assignmentBox);
        listPanel.add(Box.createRigidArea(new Dimension(0, 10))); // space between checkboxes
        assignments.add(assignmentBox);

       

        revalidate();
        repaint();
    }
}*/


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;



class AssignmentPanel extends JPanel {
    private JPanel listPanel;
    private File submissionsFolder;

   // List<Assignment> assignments = new ArrayList<>();
   // Assignment a = new Assignment("Math Homework", LocalDate.of(2025, 4, 30));

    
    public AssignmentPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(224, 255, 255)); 
        
        JLabel titleLabel = new JLabel("📚 Your Assignments 📚");
        titleLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 30));
        titleLabel.setForeground(new Color(25, 25, 112)); 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        
        submissionsFolder = new File("Submissions");
        if (!submissionsFolder.exists()) {
            submissionsFolder.mkdir(); 
        }

       
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(240, 248, 255)); 
        listPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(135, 206, 250), 3, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.getViewport().setBackground(new Color(240, 248, 255));
        
       
        addAssignment("Finish Java Project", "30/04/2025");
        addAssignment("Prepare for Quiz", "01/05/2025");
        addAssignment("Submit Assignment 3", "03/05/2025");

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(scrollPane);
        add(Box.createVerticalGlue());
    }

    public void addAssignment(String name, String dueDate) {
        JPanel assignmentPanel = new JPanel();
        assignmentPanel.setLayout(new BoxLayout(assignmentPanel, BoxLayout.Y_AXIS));
        assignmentPanel.setBackground(new Color(240, 248, 255));

        JLabel assignmentLabel = new JLabel("✏️ " + name + "  | Due: " + dueDate);
        assignmentLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        assignmentLabel.setForeground(new Color(25, 25, 112));
        
        JButton submitButton = new JButton("📂 Submit Assignment");
        submitButton.setBackground(new Color(173, 216, 230));
        submitButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        submitButton.setFocusPainted(false);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.addActionListener(e -> submitAssignment(name));

        assignmentPanel.add(assignmentLabel);
        assignmentPanel.add(submitButton);
        assignmentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        listPanel.add(assignmentPanel);  
        listPanel.add(Box.createRigidArea(new Dimension(0, 10))); 

        revalidate();
        repaint();
    }

    //public List<Assignment> getAssignments() {
    //  return assignments;
    //}
    

    private void submitAssignment(String assignmentName) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Assignment File");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF & Word Documents", "pdf", "doc", "docx"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();

        
            String newFileName = assignmentName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + System.currentTimeMillis() + "_" + fileName;
            File destinationFile = new File(submissionsFolder, newFileName);

            try {
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(this,
                        "Assignment '" + assignmentName + "' submitted successfully! 🎉",
                        "Submission Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error while submitting assignment. Please try again later. 🚫",
                        "Submission Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}



