package views;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class SignInView extends JFrame {
    public JFrame MainFrame = new JFrame();
    TestPanel gradientPanel = new TestPanel();
    RoundedPane loginPanel = new RoundedPane();
    public JLabel studentLabel, instructorLabel, studentTextLabel, instructorTextLabel, signInLabelBOLD;

    //Constructor
    public SignInView() {
        mainLoginView();
    }
    //Gradient Panel
    public class TestPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int height = getHeight();
            int width = getWidth();
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            Color color1 = new Color(255, 200, 60, 255);
            Color color2 = new Color(255, 130, 4, 255);
            GradientPaint gp = new GradientPaint(0, 100, color1, 0, 500, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    //Rounded Panel and Drop Shadow
    public class RoundedPane extends JPanel {
        private int shadowSize = 5;

        public RoundedPane() {
            // This is very important, as part of the panel is going to be transparent
            setOpaque(false);
        }

        @Override
        public Insets getInsets() {
            return new Insets(0, 0, 10, 10);
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
        @Override
        protected void paintComponent(Graphics g) {
            int width = getWidth() - 1;
            int height = getHeight() - 1;

            Graphics2D g2d = (Graphics2D) g.create();
            TestDropShadowBorder.applyQualityProperties(g2d);
            Insets insets = getInsets();
            Rectangle bounds = getBounds();
            bounds.x = insets.left;
            bounds.y = insets.top;
            bounds.width = width - (insets.left + insets.right);
            bounds.height = height - (insets.top + insets.bottom);
            RoundRectangle2D shape = new RoundRectangle2D.Float(bounds.x, bounds.y, bounds.width, bounds.height, 20, 20);

            /**
             * * THIS SHOULD BE CAHCED AND ONLY UPDATED WHEN THE SIZE OF THE
             * COMPONENT CHANGES **
             */
            BufferedImage img = TestDropShadowBorder.createCompatibleImage(bounds.width, bounds.height);
            Graphics2D tg2d = img.createGraphics();
            TestDropShadowBorder.applyQualityProperties(g2d);
            tg2d.setColor(Color.BLACK);
            tg2d.translate(-bounds.x, -bounds.y);
            tg2d.fill(shape);
            tg2d.dispose();
            BufferedImage shadow = TestDropShadowBorder.generateShadow(img, shadowSize, Color.BLACK, 0.5f);
            g2d.drawImage(shadow, shadowSize, shadowSize, this);
            g2d.setColor(getBackground());
            g2d.fill(shape);
            /**
             * THIS ONE OF THE ONLY OCCASIONS THAT I WOULDN'T CALL
             * super.paintComponent *
             */
            getUI().paint(g2d, this);
            g2d.setColor(Color.GRAY);
            g2d.draw(shape);
            g2d.dispose();
        }
    }
    //Rounded Panel
    public static class RoundedPanel extends JPanel {
        private int shadowSize = 5;

        public RoundedPanel() {
            // This is very important, as part of the panel is going to be transparent
            setOpaque(false);
        }
        @Override
        public Insets getInsets() {
            return new Insets(0, 0, 10, 10);
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
        @Override
        protected void paintComponent(Graphics g) {
            int width = getWidth() - 1;
            int height = getHeight() - 1;

            Graphics2D g2d = (Graphics2D) g.create();
            TestDropShadowBorder.applyQualityProperties(g2d);
            Insets insets = getInsets();
            Rectangle bounds = getBounds();
            bounds.x = insets.left;
            bounds.y = insets.top;
            bounds.width = width - (insets.left + insets.right);
            bounds.height = height - (insets.top + insets.bottom);
            RoundRectangle2D shape = new RoundRectangle2D.Float(bounds.x, bounds.y, bounds.width, bounds.height, 20, 20);

            /**
             * * THIS SHOULD BE CAHCED AND ONLY UPDATED WHEN THE SIZE OF THE
             * COMPONENT CHANGES **
             */
            BufferedImage img = TestDropShadowBorder.createCompatibleImage(bounds.width, bounds.height);
            Graphics2D tg2d = img.createGraphics();
            TestDropShadowBorder.applyQualityProperties(g2d);
            tg2d.setColor(Color.BLACK);
            tg2d.translate(-bounds.x, -bounds.y);
            tg2d.fill(shape);
            tg2d.dispose();
            g2d.setColor(getBackground());
            g2d.fill(shape);
            /**
             * THIS ONE OF THE ONLY OCCASIONS THAT I WOULDN'T CALL
             * super.paintComponent *
             */
            getUI().paint(g2d, this);
            g2d.setColor(new Color(253,208,72,255));
            g2d.draw(shape);
            g2d.dispose();
        }
    }

    public void mainLoginView() {
        MainFrame.setSize(1000, 600);
        MainFrame.setTitle("Home");
        MainFrame.setLayout(null);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setResizable(false);

        //LoginPanel
        loginPanel.setBackground(Color.white);
        loginPanel.setLayout(null);
        loginPanel.setBounds(340, 150, 300, 250);

        //Gradient Panel
        gradientPanel.setBounds(0, 0, 1000, 600);
        gradientPanel.setLayout(null);

        //SIGN IN LABEL
        signInLabelBOLD = new JLabel("Login as:");
        signInLabelBOLD.setBounds(95,15,150,40);
        signInLabelBOLD.setForeground(Color.BLACK);
        signInLabelBOLD.setFont(new Font("Segoe UI", Font.BOLD,25));

        //STUDENT AND INSTRUCTOR BUTTON
        ImageIcon studentIcon = new ImageIcon(getClass().getResource("icons\\Student.png"));
        studentLabel = new JLabel(studentIcon);
        studentLabel.setBounds(20,80,250,70);
        studentTextLabel = new JLabel("STUDENT");
        studentTextLabel.setFont(new Font("Segoe UI", Font.PLAIN,21));
        studentTextLabel.setForeground(Color.white);
        studentTextLabel.setBounds(85,7,90,40);

        ImageIcon instructorIcon = new ImageIcon(getClass().getResource("icons\\Instructor.png"));
        instructorLabel = new JLabel(instructorIcon);
        instructorLabel.setBounds(20,140,250,70);
        instructorTextLabel = new JLabel("INSTRUCTOR");
        instructorTextLabel.setFont(new Font("Segoe UI", Font.PLAIN,21));
        instructorTextLabel.setForeground(Color.white);
        instructorTextLabel.setBounds(70,-2,150,70);

        // .add
        MainFrame.add(gradientPanel);
        gradientPanel.add(loginPanel);
        loginPanel.add(signInLabelBOLD);
        loginPanel.add(studentLabel);
        studentLabel.add(studentTextLabel);
        loginPanel.add(instructorLabel);
        instructorLabel.add(instructorTextLabel);

        MainFrame.setVisible(true);
    }
}
