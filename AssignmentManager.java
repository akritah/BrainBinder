import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;


public class AssignmentManager extends JFrame {
    CardLayout cardLayout;
    JPanel mainPanel;

    public AssignmentManager() {
        setTitle("Assignment Manager");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(6, 1, 0, 10));
        navPanel.setBackground(new Color(30, 30, 60));
        navPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JButton homeBtn = createNavButton("🏠 Home");
        JButton assignmentsBtn = createNavButton("📝 Assignments");
        JButton addBtn = createNavButton("➕ Add Assignment");
        JButton quizBtn = createNavButton("❓Pending Quizes");

        navPanel.add(homeBtn);
        navPanel.add(assignmentsBtn);
        navPanel.add(addBtn);
        navPanel.add(quizBtn);

        add(navPanel, BorderLayout.WEST);

        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        AssignmentPanel assignmentPanel = new AssignmentPanel();
AddAssignmentPanel addAssignmentPanel = new AddAssignmentPanel(assignmentPanel);


        mainPanel.add(new HomePanel(), "Home");
        mainPanel.add(assignmentPanel, "Assignments");
        mainPanel.add(addAssignmentPanel, "Add");
        mainPanel.add(new QuizPanel(), "Quiz");
       


        add(mainPanel, BorderLayout.CENTER);

        
        homeBtn.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        assignmentsBtn.addActionListener(e -> cardLayout.show(mainPanel, "Assignments"));
        addBtn.addActionListener(e -> cardLayout.show(mainPanel, "Add"));
        quizBtn.addActionListener(e -> cardLayout.show(mainPanel, "Quiz"));

      //  startReminderTimer(assignmentPanel.getAssignments());  


        setVisible(true);
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(50, 50, 90));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }

    //List<Assignment> assignments = DatabaseHelper.getAllAssignments(); 
//ReminderService.startReminders(assignments);
private void startReminderTimer(List<Assignment> assignments) {
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            LocalDate today = LocalDate.now();
            for (Assignment assignment : assignments) {
                LocalDate due = assignment.getDueDate();
                if (due != null && (due.equals(today) || due.equals(today.plusDays(1)))) {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(null,
                            "Reminder: \"" + assignment.getName() + "\" is due on " + due,
                            "Upcoming Assignment",
                            JOptionPane.WARNING_MESSAGE);
                    });
                }
            }
        }
    }, 0, 60 * 1000);
}






    public static void main(String[] args) {
        SwingUtilities.invokeLater(AssignmentManager::new);
    }
}