package views;
import controllers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class StudentSignInView extends JFrame{
    public JFrame MainFrame = new JFrame();
    TestPanel gradientPanel = new TestPanel();
    public RoundedPanel SignInButton, SignInLabel, loginPanel;
    public JLabel homeLabel, signInLabel, signUpLabel, greetingLabel2, studentSignUpLogo, ___username, ___password, signInlabelButton, signUpLabelBOLD;
    public JTextField usernameTextF;
    public JPasswordField passwordTextF;

    //Constructor
    public StudentSignInView() {
        StudentSignInView();
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

    public void StudentSignInView() {
        MainFrame.setSize(1000, 600);
        MainFrame.setTitle("Student Sign-In");
        MainFrame.setLayout(null);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setResizable(false);

        //LoginPanel
        loginPanel = new RoundedPanel();
        loginPanel.setBackground(Color.white);
        loginPanel.setFocusable(true);
        loginPanel.setLayout(null);
        loginPanel.setBounds(340, 90, 300, 350);

        //Gradient Panel
        gradientPanel.setBounds(0, 0, 1000, 600);
        gradientPanel.setLayout(null);

        //Labels
        homeLabel = new JLabel("HOME");
        homeLabel.setBounds(65,25,100,20);
        homeLabel.setForeground(Color.WHITE);
        homeLabel.setFont(new Font("Segoe UI", Font.PLAIN,21));

        signInLabel = new JLabel("SIGN-IN");
        signInLabel.setBounds(10,3,90,20);
        signInLabel.setForeground(Color.WHITE);
        signInLabel.setFont(new Font("Segoe UI", Font.PLAIN,21));

        signUpLabel = new JLabel("SIGN-UP");
        signUpLabel.setBounds(860,25,90,20);
        signUpLabel.setForeground(Color.WHITE);
        signUpLabel.setFont(new Font("Segoe UI", Font.PLAIN,21));

        SignInLabel = new RoundedPanel();
        SignInLabel.setBackground(Color.GRAY);
        SignInLabel.setLayout(null);
        SignInLabel.setBounds(745,23,110,40);

        signUpLabelBOLD = new JLabel("SIGN-IN");
        signUpLabelBOLD.setBounds(100,15,300,40);
        signUpLabelBOLD.setForeground(Color.BLACK);
        signUpLabelBOLD.setFont(new Font("Segoe UI", Font.BOLD,26));

        greetingLabel2 = new JLabel("STUDENT");
        greetingLabel2.setForeground(new Color(253,208,72,255));
        greetingLabel2.setBounds(125,80,150,40);
        greetingLabel2.setFont(new Font("Segoe UI", Font.BOLD,23));

        ImageIcon instructorIcon = new ImageIcon(getClass().getResource("icons\\studentBILOG.png"));
        studentSignUpLogo = new JLabel(instructorIcon);
        studentSignUpLogo.setBounds(15,65,150,70);

        usernameTextF = new JTextField("USERNAME");
        usernameTextF.setEditable(true);
        usernameTextF.setBorder(null);
        usernameTextF.setForeground(Color.LIGHT_GRAY);
        usernameTextF.setFont(new Font("Segoe UI", Font.BOLD,12));
        usernameTextF.setBounds(50,155,200,20);

        ___username = new JLabel("_____________________________");
        ___username.setForeground(new Color(253,208,72,255));
        ___username.setBounds(50,160,300,20);

        passwordTextF = new JPasswordField("PASSWORD");
        passwordTextF.setEditable(true);
        passwordTextF.setBorder(null);
        passwordTextF.setForeground(Color.LIGHT_GRAY);
        passwordTextF.setFont(new Font("Segoe UI", Font.BOLD,12));
        passwordTextF.setBounds(50,200,200,20);

        ___password = new JLabel("_____________________________");
        ___password.setForeground(new Color(253,208,72,255));
        ___password.setBounds(50,205,300,20);

        //Sign In button
        SignInButton = new RoundedPanel();
        SignInButton.setBackground(Color.WHITE);
        SignInButton.setLayout(null);
        SignInButton.setBounds(70,260,150,42);

        signInlabelButton = new JLabel("SIGN IN");
        signInlabelButton.setForeground(new Color(253,208,72,255));
        signInlabelButton.setFont(new Font("Segoe UI", Font.BOLD,12));
        signInlabelButton.setBounds(45,7,100,15);

        // .add
        MainFrame.add(gradientPanel);
        gradientPanel.add(loginPanel);
        gradientPanel.add(homeLabel);
        gradientPanel.add(signUpLabel);
        SignInLabel.add(signInLabel);
        gradientPanel.add(SignInLabel);
        loginPanel.add(signUpLabelBOLD);
        loginPanel.add(greetingLabel2);
        loginPanel.add(studentSignUpLogo);
        loginPanel.add(___username);
        loginPanel.add(___password);
        loginPanel.add(SignInButton);
        SignInButton.add(signInlabelButton);
        loginPanel.add(usernameTextF);
        loginPanel.add(passwordTextF);
        MainFrame.setVisible(true);
    }

    public String getUserNameTextField(){ return usernameTextF.getText(); }
    public String getPasswordTextField(){ return new String(passwordTextF.getPassword()); }
}
