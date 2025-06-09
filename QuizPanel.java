/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;


class QuizPanel extends JPanel {
    String[] questions = {
        "1. What is JVM in Java?",
        "2. Which keyword is used to inherit a class in Java?",
        "3. Which of these is NOT a Java feature?",
        "4. What is the size of int in Java?",
        "5. Which method is the entry point for a Java program?"
    };

    String[][] options = {
        {"Java Virtual Machine", "Java Variable Method", "Java Visual Manager", "None"},
        {"implements", "extends", "inherits", "super"},
        {"Object-oriented", "Use of pointers", "Platform independent", "Robust"},
        {"2 bytes", "4 bytes", "8 bytes", "Depends on system"},
        {"main()", "start()", "run()", "init()"}
    };

    int[] answers = {0, 1, 1, 1, 0}; 

    JRadioButton[][] choices = new JRadioButton[5][4];
    ButtonGroup[] groups = new ButtonGroup[5];

    JButton submitButton;
    JLabel title;

    public QuizPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(173, 216, 230)); 

        title = new JLabel("🧠 Java Quiz");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);
        add(Box.createRigidArea(new Dimension(0, 20)));

        for (int i = 0; i < 5; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(new Color(173, 216, 230));

            JLabel qLabel = new JLabel(questions[i]);
            qLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            panel.add(qLabel);

            groups[i] = new ButtonGroup();
            for (int j = 0; j < 4; j++) {
                choices[i][j] = new JRadioButton(options[i][j]);
                choices[i][j].setBackground(new Color(173, 216, 230));
                groups[i].add(choices[i][j]);
                panel.add(choices[i][j]);
            }
            add(panel);
            add(Box.createRigidArea(new Dimension(0, 20)));
        }

        submitButton = new JButton("Submit Quiz 📝");
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int score = 0;

                StringBuilder feedback = new StringBuilder();


                for (int i = 0; i < 5; i++) {
                    int selected = getSelectedIndex(groups[i]);
                    if (selected == answers[i]) {
                        score++;
                    }else {
                        feedback.append("\n❌ Wrong: ").append(questions[i]);
                        feedback.append("\n✔ Correct Answer: ").append(options[i][answers[i]]);
                        feedback.append("\n");
                    }
                }
                String message = "🎯 Your Score: " + score + " out of 5\n";
                if (score == 5) {
                    message += "\n🏆 Perfect! You got all answers correct!";
                } else {
                    message += feedback.toString();
                }
        
                JOptionPane.showMessageDialog(QuizPanel.this, message, "Quiz Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(submitButton);
        add(Box.createVerticalGlue());
    }

    private int getSelectedIndex(ButtonGroup group) {
        Enumeration<AbstractButton> buttons = group.getElements();
        int index = 0;
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return index;
            }
            index++;
        }
        return -1; 
    }
}*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class QuizPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel quizContainer;
    private quiz currentQuiz;

    public QuizPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(224, 255, 255));

       
        JPanel subjectPanel = new JPanel();
        subjectPanel.setBackground(new Color(224, 255, 255));
        subjectPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Select Subject:");
        label.setFont(new Font("Georgia", Font.BOLD, 24));

        JButton javaQuizBtn = new JButton("Java Quiz");
        JButton mathQuizBtn = new JButton("EVS Quiz");
        JButton englishQuizBtn = new JButton("Mechanics Quiz");

        styleButton(javaQuizBtn);
        styleButton(mathQuizBtn);
        styleButton(englishQuizBtn);

        subjectPanel.add(label);
        subjectPanel.add(javaQuizBtn);
        subjectPanel.add(mathQuizBtn);
        subjectPanel.add(englishQuizBtn);

        add(subjectPanel, BorderLayout.NORTH);

       
        cardLayout = new CardLayout();
        quizContainer = new JPanel(cardLayout);
        add(quizContainer, BorderLayout.CENTER);

        javaQuizBtn.addActionListener(e -> startQuiz("Java"));
        mathQuizBtn.addActionListener(e -> startQuiz("EVS"));
        englishQuizBtn.addActionListener(e -> startQuiz("Mechanics"));
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        button.setBackground(new Color(173, 216, 230));
        button.setFocusPainted(false);
    }

    private void startQuiz(String subject) {
        currentQuiz = new quiz(subject);
        quizContainer.removeAll();
        quizContainer.add(currentQuiz);
        cardLayout.show(quizContainer, subject);
        revalidate();
        repaint();
    }
}
