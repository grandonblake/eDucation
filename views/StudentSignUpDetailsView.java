package views;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.Objects;


public class StudentSignUpDetailsView extends JFrame {
    public JFrame MainFrame = new JFrame();
    TestPanel gradientPanel = new TestPanel();
    RoundedPane infoPanel = new RoundedPane();
    public JLabel titleLabel, StudentInfoLabel, ___;

    //Student Information Labels
    JLabel firstNameLabel, middleNameLabel, lastNameLabel, addressLabel, contactNumberLabel, ageLabel, sexLabel, programLabel, emailLabel;
    //Student Information Under Labels
    RoundJTextField firstNameText = new RoundJTextField(20);
    RoundJTextField middleNameText = new RoundJTextField(20);
    RoundJTextField lastNameText = new RoundJTextField(20);
    RoundJTextField addressText = new RoundJTextField(50);
    RoundJTextField contactNumberText = new RoundJTextField(11);
    RoundJTextField emailText = new RoundJTextField(11);

    public RoundedPanel submitPanel = new RoundedPanel();
    JLabel submitLabel = new JLabel();

    //JComboBox and its Arrays
    String[] ageArray = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99"};
    String[] sexArray = {"Male", "Female"};
    String[] programArray = {"Computer Science"};

    JComboBox ageBox = new JComboBox(ageArray);
    JComboBox sexBox = new JComboBox(sexArray);
    JComboBox programBox = new JComboBox(programArray);

    //Panels
    RoundedPanel titlePanel = new RoundedPanel();
    RoundedPanel SignUpPanel = new RoundedPanel();
    //---------------------------------------------------------------------------------------------------------------------
    //Constructor
    public StudentSignUpDetailsView() {
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
        public Insets getInsets() { return new Insets(0, 0, 10, 10);
        }
        @Override
        public Dimension getPreferredSize() { return new Dimension(200, 200);
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
        public Insets getInsets() {return new Insets(0, 0, 10, 10);
        }
        @Override
        public Dimension getPreferredSize() {return new Dimension(200, 200);
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
    //Rounded JTextField
    public class RoundJTextField extends JTextField {
        private Shape shape;
        public RoundJTextField(int size) {
            super(size);
            setOpaque(false); // As suggested by @AVD in comment.
        }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }
    //Rounder JComboBox
//---------------------------------------------------------------------------------------------------------------------

    public void mainLoginView() {
        MainFrame.setSize(1000, 600);
        MainFrame.setTitle("Login");
        MainFrame.setLayout(null);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setResizable(false);

        //LoginPanel
        infoPanel.setBackground(Color.white);
        infoPanel.setLayout(null);
        infoPanel.setBounds(100, 90, 800, 370);

        //Gradient Panel
        gradientPanel.setBounds(0, 0, 1000, 600);
        gradientPanel.setLayout(null);

        //Labels
        titleLabel = new JLabel("FILL UP STUDENT DETAILS");
        titleLabel.setBounds(160,5,500,40);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD,32));

        titlePanel.setBackground(Color.WHITE);
        titlePanel.setBackground(new Color(255,255,255,64));
        titlePanel.setLayout(null);
        titlePanel.setBounds(-10,23,600,65);

        StudentInfoLabel = new JLabel("STUDENT INFORMATION");
        StudentInfoLabel.setBounds(25,15,500,40);
        StudentInfoLabel.setForeground(Color.BLACK);
        StudentInfoLabel.setFont(new Font("Segoe UI", Font.BOLD,26));

        ___ = new JLabel("___________________________________________________________________________________________________________________");
        ___.setBounds(20,40,1100,20);
        ___.setForeground(Color.ORANGE);

        //Student Information
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setFont(new Font("Segoe UI", Font.PLAIN,15));
        firstNameLabel.setBounds(20,70,100,20);

        middleNameLabel = new JLabel("Middle Name");
        middleNameLabel.setFont(new Font("Segoe UI", Font.PLAIN,15));
        middleNameLabel.setBounds(340,70,100,20);

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(new Font("Segoe UI", Font.PLAIN,15));
        lastNameLabel.setBounds(560,70,100,20);

        addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Segoe UI", Font.PLAIN,15));
        addressLabel.setBounds(20,130,100,20);

        contactNumberLabel = new JLabel("Contact Number");
        contactNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN,15));
        contactNumberLabel.setBounds(560,130,200,20);

        ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Segoe UI", Font.PLAIN,15));
        ageLabel.setBounds(20,190,100,25);

        sexLabel = new JLabel("Sex");
        sexLabel.setFont(new Font("Segoe UI", Font.PLAIN,15));
        sexLabel.setBounds(266,190,100,25);

        programLabel = new JLabel("Program");
        programLabel.setFont(new Font("Segoe UI", Font.PLAIN,15));
        programLabel.setBounds(512,190,100,25);

        emailLabel = new JLabel("Email Address");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN,15));
        emailLabel.setBounds(20,250,200,25);

        firstNameText = new RoundJTextField(20);
        firstNameText.setBounds(20,93,300,20);

        middleNameText = new RoundJTextField(20);
        middleNameText.setBounds(340,93,200,20);

        lastNameText = new RoundJTextField(20);
        lastNameText.setBounds(560,93,200,20);

        addressText = new RoundJTextField(50);
        addressText.setBounds(20,153,520,20);

        contactNumberText = new RoundJTextField(11);
        contactNumberText.setBounds(560,153,200,20);

        emailText = new RoundJTextField(11);
        emailText.setBounds(20,273,300,20);

        ageBox = new JComboBox(ageArray);
        ageBox.setBackground(Color.white);
        ageBox.setBounds(20,213,230,20);

        sexBox = new JComboBox(sexArray);
        sexBox.setBackground(Color.white);
        sexBox.setBounds(266,213,230,20);

        programBox = new JComboBox(programArray);
        programBox.setBackground(Color.white);
        programBox.setBounds(512,213,250,20);

        submitPanel = new RoundedPanel();
        submitPanel.setLayout(null);
        submitPanel.setBackground(Color.WHITE);
        submitPanel.setBounds(680,300,90,35);

        submitLabel = new JLabel("SUBMIT");
        submitLabel.setForeground(new Color(253,208,72,255));
        submitLabel.setFont(new Font("Segoe UI", Font.BOLD,15));
        submitLabel.setBounds(11,0,100,20);

        // .add
        MainFrame.add(gradientPanel);
        gradientPanel.add(infoPanel);
        gradientPanel.add(titleLabel);
        gradientPanel.add(titlePanel);
        titlePanel.add(titleLabel);
        submitPanel.add(submitLabel, BorderLayout.CENTER);

        infoPanel.add(StudentInfoLabel);
        infoPanel.add(___);
        infoPanel.add(firstNameLabel);
        infoPanel.add(middleNameLabel);
        infoPanel.add(lastNameLabel);
        infoPanel.add(addressLabel);
        infoPanel.add(contactNumberLabel);
        infoPanel.add(ageLabel);
        infoPanel.add(sexLabel);
        infoPanel.add(programLabel);
        infoPanel.add(emailLabel);
        infoPanel.add(firstNameText);
        infoPanel.add(middleNameText);
        infoPanel.add(lastNameText);
        infoPanel.add(addressText);
        infoPanel.add(contactNumberText);
        infoPanel.add(emailText);
        infoPanel.add(ageBox);
        infoPanel.add(sexBox);
        infoPanel.add(programBox);
        infoPanel.add(submitPanel);

        MainFrame.setVisible(true);
    }
    
    public String getFirstName(){
        return firstNameText.getText();
    }
    
    public String getMiddleName(){
        return middleNameText.getText();
    }
    
    public String getLastName(){
        return lastNameText.getText();
    }

    public String getAddress(){
        return addressText.getText();
    }

    public String getContactNumber(){
        return contactNumberText.getText();
    }

    public String getAge(){
        return Objects.requireNonNull(ageBox.getSelectedItem()).toString();
    }

    public String getSex(){
        return Objects.requireNonNull(sexBox.getSelectedItem()).toString();
    }

    public String getProgram(){
        return Objects.requireNonNull(programBox.getSelectedItem()).toString();
    }

    public String getEmail(){ return emailText.getText(); }
}
