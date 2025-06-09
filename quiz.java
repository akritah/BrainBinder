import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;  




public class quiz extends JPanel {
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private List<String> feedback = new ArrayList<>();

    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup group;
    private JButton nextButton;

    public quiz(String subject) {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));

        questions = generateQuestions(subject);

        questionLabel = new JLabel("Question will appear here");
        questionLabel.setFont(new Font("Georgia", Font.BOLD, 22));
        questionLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
        optionPanel.setBackground(new Color(240, 248, 255));

        options = new JRadioButton[4];
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setBackground(new Color(240, 248, 255));
            options[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            group.add(options[i]);
            optionPanel.add(options[i]);
        }

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        nextButton.setBackground(new Color(173, 216, 230));
        nextButton.addActionListener(e -> nextQuestion());

        add(questionLabel, BorderLayout.NORTH);
        add(optionPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);

        loadQuestion();
    }

    private List<Question> generateQuestions(String subject) {
        List<Question> questionsList = new ArrayList<>();
        if (subject.equals("Java")) {
            questionsList.add(new Question("Which keyword is used to create a subclass?", new String[]{"extends", "super", "final", "this"}, 0));
        questionsList.add(new Question("Which method is the entry point in Java?", new String[]{"start()", "run()", "main()", "init()"}, 2));
        questionsList.add(new Question("Which data type is used for decimals?", new String[]{"int", "float", "char", "boolean"}, 1));
        questionsList.add(new Question("Which symbol is used for comments?", new String[]{"//", "##", "==", "**"}, 0));
        questionsList.add(new Question("What does JVM stand for?", new String[]{"Java Visual Machine", "Java Virtual Machine", "Java Variable Method", "Java Verified Model"}, 1));
        } else if (subject.equals("EVS")) {
            questionsList.add(new Question("Which of the following is a renewable source of energy?", new String[]{"Coal", "Natural Gas", "Solar Energy", "Petroleum"}, 2));
            questionsList.add(new Question("What is the major cause of global warming?", new String[]{"Deforestation", "Use of fertilizers", "Ozone layer depletion", "Increased carbon dioxide"}, 3));
            questionsList.add(new Question("Which gas is primarily responsible for the greenhouse effect?", new String[]{"Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"}, 2));
            questionsList.add(new Question("Which of the following is an endangered species?", new String[]{"House Sparrow", "White Tiger", "Cat", "Cow"}, 1));
            questionsList.add(new Question("What do you call the variety of life found on Earth?", new String[]{"Biosphere", "Biodiversity", "Ecosystem", "Habitat"}, 1));
        } else if (subject.equals("Mechanics")) {
            questionsList.add(new Question("Which quantity is a scalar?", new String[]{"Velocity", "Force", "Mass", "Displacement"}, 2));
            questionsList.add(new Question("What is the SI unit of force?", new String[]{"Joule", "Newton", "Pascal", "Watt"}, 1));
            questionsList.add(new Question("A body is said to be in uniform motion when it moves with?", new String[]{"Changing speed", "Constant speed", "Increasing speed", "Decreasing speed"}, 1));
            questionsList.add(new Question("The rate of change of velocity is called?", new String[]{"Speed", "Acceleration", "Momentum", "Force"}, 1));
            questionsList.add(new Question("What does Newton's first law of motion state?", new String[]{"F=ma", "Every action has an equal and opposite reaction", "A body remains at rest or in uniform motion unless acted upon by an external force", "Force equals change in momentum"}, 2));
        }
        return questionsList;
    }

    private void loadQuestion() {
        if (currentQuestionIndex >= questions.size()) {
            showResult();
            return;
        }

        Question q = questions.get(currentQuestionIndex);
        questionLabel.setText((currentQuestionIndex + 1) + ". " + q.getQuestion());
        String[] opts = q.getOptions();
        for (int i = 0; i < 4; i++) {
            options[i].setText(opts[i]);
            options[i].setSelected(false);
        }
    }

    private void nextQuestion() {
        Question q = questions.get(currentQuestionIndex);

        int selected = -1;
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                selected = i;
                break;
            }
        }

        if (selected == -1) {
            JOptionPane.showMessageDialog(this, "Please select an answer before continuing!", "No Answer", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (selected == q.getAnswerIndex()) {
            score++;
        } else {
            feedback.add("Q" + (currentQuestionIndex+1) + ": Correct answer is " + q.getOptions()[q.getAnswerIndex()]);
        }

        currentQuestionIndex++;
        loadQuestion();
    }

    private void showResult() {
        StringBuilder result = new StringBuilder();
        result.append("Your Score: ").append(score).append("/").append(questions.size()).append("\n\n");

        if (!feedback.isEmpty()) {
            result.append("Review your mistakes:\n");
            for (String fb : feedback) {
                result.append(fb).append("\n");
            }
        }

        JOptionPane.showMessageDialog(this, result.toString(), "Quiz Result", JOptionPane.INFORMATION_MESSAGE);
    }
}

class Question {
    private String question;
    private String[] options;
    private int answerIndex;

    public Question(String question, String[] options, int answerIndex) {
        this.question = question;
        this.options = options;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }
    public String[] getOptions() {
        return options;
    }
    public int getAnswerIndex() {
        return answerIndex;
    }
}
