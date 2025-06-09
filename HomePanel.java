

/*class HomePanel extends JPanel {
    public HomePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(173, 216, 230)); // Pastel blue background
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Padding

        JLabel titleLabel = new JLabel("Welcome to Assignment Manager");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        titleLabel.setForeground(new Color(50, 50, 100));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        JPanel boxPanel = new JPanel();
        boxPanel.setBackground(new Color(224, 255, 255)); 
        boxPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 3, true)); // Blue border, rounded
        boxPanel.setLayout(new GridBagLayout()); 
        boxPanel.add(titleLabel);

        add(Box.createVerticalGlue());
        add(boxPanel);
        add(Box.createVerticalGlue());
    }
}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HomePanel extends JPanel {
    private JLabel titleLabel;

    public HomePanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(230, 240, 255));

       
        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(173, 216, 230);
                Color color2 = new Color(224, 255, 255);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        gradientPanel.setLayout(new BoxLayout(gradientPanel, BoxLayout.Y_AXIS));
        gradientPanel.setOpaque(false);
        gradientPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

       
        titleLabel = new JLabel("📚 Manage your Assignments like a Pro! 📝");
        titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 34));
        titleLabel.setForeground(new Color(40, 40, 90));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setOpaque(false);

       
        JPanel boxPanel = new JPanel();
        boxPanel.setBackground(new Color(255, 255, 255, 150)); 
        boxPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 4, true));
        boxPanel.setLayout(new GridBagLayout());
        boxPanel.add(titleLabel);
        boxPanel.setMaximumSize(new Dimension(600, 200));
        boxPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        gradientPanel.add(Box.createVerticalGlue());
        gradientPanel.add(boxPanel);
        gradientPanel.add(Box.createVerticalGlue());

        add(gradientPanel);

       
        animateTitle();
    }

    private void animateTitle() {
        Timer timer = new Timer(50, null);
        timer.addActionListener(new ActionListener() {
            float alpha = 0.0f;

            public void actionPerformed(ActionEvent e) {
                alpha += 0.05f;
                if (alpha > 1f) {
                    alpha = 1f;
                    ((Timer) e.getSource()).stop();
                }
                titleLabel.setForeground(new Color(40, 40, 90, (int)(alpha * 255)));
                repaint();
            }
        });
        timer.start();
    }
}


