package views;
import models.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class InstructorMainView implements Observer {
    public Instructor model;

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
            g2d.setColor(Color.black);
            g2d.draw(shape);
            g2d.dispose();
        }
    }

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘

    public JFrame menuFrame = new JFrame();
    public RoundedPanel studentProfilePanel, encodeGradesPanel, seeSchedulePanel, logoutPanel, iconBackground;
    JLabel menuLabel, ___menu;
    public JLabel studentProfileLabel, encodeGradesLabel, seeSchedLabel, logoutLabel, studentProfileLabel2, encodeGradesLabel2, seeSchedLabel2;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    public JFrame profInfoFrame = new JFrame(); //frame for the professor information

    JPanel background1, background2;
    JPanel box1, box2, box3, box4, box5, box6, box7, box8;
    public RoundedPanel profInfoPanel, greetingPanel, editPanel, savePanel = new RoundedPanel();
    public JTextField prefixTfield, firstNameTfield, middleInitialTfield, lastNameTfield, email, degree;
    public JLabel greetingLabel, profIcon, menuIcon, prefixLabel, firstNameLabel, middleNameLabel, lastNameLabel, emailLabel,
            degreeLabel, editLabel, saveLabel, editable, ageLabel, sexLabel, age, sex;

    public JComboBox prefixComboBox, ageComboBox, sexComboBox;

    public InstructorMainView(){
        model = new Instructor();
        InstructorMainView();
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------

    public void InstructorMainView() {
        //Frame
        profInfoFrame.setSize(1000, 600);
        profInfoFrame.setTitle("Instructor Main");
        profInfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profInfoFrame.setLayout(new BorderLayout());
        profInfoFrame.setLocationRelativeTo(null);
        profInfoFrame.setResizable(false);

        //-----------L A B E L S-----------------------------------------------------------------------------------------

        editable = new JLabel("EDITABLE");
        editable.setForeground(Color.YELLOW);
        editable.setBounds(830,-5,100,60);
        editable.setFont(new Font("Segoe UI", Font.BOLD,12));
        editable.setVisible(false);

        greetingLabel = new JLabel();
        greetingLabel.setForeground(Color.WHITE);
        greetingLabel.setBounds(30,0,250,30);
        greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        greetingLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));

        iconBackground = new RoundedPanel();
        iconBackground.setBackground(Color.decode("#202020"));
        iconBackground.setBounds(106,30,90,320);
        iconBackground.setLayout(null);

        ImageIcon profLogo = new ImageIcon(getClass().getResource("icons\\InstructorWithBigBilog.png"));
        profIcon = new JLabel();
        profIcon.setIcon(profLogo);
        profIcon.setBounds(25, 40, 280, 280);

        prefixLabel = new JLabel();
        prefixLabel.setText("PREFIX: ");
        prefixLabel.setBounds(330, 30, 140, 30);
        prefixLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        prefixLabel.setForeground(Color.WHITE);

        firstNameLabel = new JLabel();
        firstNameLabel.setText("FIRST NAME: ");
        firstNameLabel.setBounds(330, 70, 140, 30);
        firstNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        firstNameLabel.setForeground(Color.WHITE);

        middleNameLabel = new JLabel();
        middleNameLabel.setText("MIDDLE INITIAL: ");
        middleNameLabel.setBounds(330, 110, 150, 30);
        middleNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        middleNameLabel.setForeground(Color.WHITE);

        lastNameLabel = new JLabel();
        lastNameLabel.setText("LAST NAME: ");
        lastNameLabel.setBounds(330, 150, 100, 30);
        lastNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lastNameLabel.setForeground(Color.WHITE);

        ageLabel = new JLabel();
        ageLabel.setText("AGE: ");
        ageLabel.setBounds(330, 190, 150, 30);
        ageLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        ageLabel.setForeground(Color.WHITE);

        sexLabel = new JLabel();
        sexLabel.setText("SEX: ");
        sexLabel.setBounds(330, 230, 100, 30);
        sexLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        sexLabel.setForeground(Color.WHITE);

        emailLabel = new JLabel();
        emailLabel.setText("EMAIL: ");
        emailLabel.setBounds(330, 270, 100, 30);
        emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        emailLabel.setForeground(Color.WHITE);

        degreeLabel = new JLabel();
        degreeLabel.setText("DEGREE: ");
        degreeLabel.setBounds(330, 310, 100, 30);
        degreeLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        degreeLabel.setForeground(Color.WHITE);

        editLabel = new JLabel();
        editLabel.setText("EDIT");
        editLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        editLabel.setForeground(Color.WHITE);
        editLabel.setBounds(15, 0, 100, 20);

        saveLabel = new JLabel();
        saveLabel.setText("SAVE");
        saveLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        saveLabel.setForeground(Color.WHITE);
        saveLabel.setBounds(12, 0, 100, 20);

        //---------T E X T  F I E L D S------------------------------------------------------------------------------------------------

        String[] prefixes = {"Mr.", "Ms.", "Mrs."};
        prefixComboBox = new JComboBox(prefixes);
        prefixComboBox.setBackground(Color.decode("#3f3f3f"));
        prefixComboBox.setEnabled(false);
        prefixComboBox.setVisible(false);
        prefixComboBox.setBorder(BorderFactory.createEmptyBorder());
        prefixComboBox.setForeground(Color.WHITE);
        prefixComboBox.setFont(new Font("Segoe UI", Font.BOLD,16));
        prefixComboBox.setBounds(480,30,100,22);

        String prefixValue = prefixComboBox.getSelectedItem().toString();
        prefixTfield = new JTextField(prefixValue);
        prefixTfield.setEditable(false);
        prefixTfield.setBounds(480, 30, 300, 30);
        prefixTfield.setFont(new Font("Segoe UI", Font.BOLD, 16));
        prefixTfield.setBackground(Color.decode("#3f3f3f"));
        prefixTfield.setForeground(Color.WHITE);
        prefixTfield.setBorder(BorderFactory.createEmptyBorder());

        firstNameTfield = new JTextField();
        firstNameTfield.setEditable(false);
        firstNameTfield.setBounds(480, 70, 300, 30);
        firstNameTfield.setFont(new Font("Segoe UI", Font.BOLD, 16));
        firstNameTfield.setBackground(Color.decode("#3f3f3f"));
        firstNameTfield.setForeground(Color.WHITE);
        firstNameTfield.setBorder(BorderFactory.createEmptyBorder());

        middleInitialTfield = new JTextField();
        middleInitialTfield.setEditable(false);
        middleInitialTfield.setBounds(480, 110, 300, 30);
        middleInitialTfield.setFont(new Font("Segoe UI", Font.BOLD, 16));
        middleInitialTfield.setBackground(Color.decode("#3f3f3f"));
        middleInitialTfield.setForeground(Color.WHITE);
        middleInitialTfield.setBorder(BorderFactory.createEmptyBorder());

        lastNameTfield = new JTextField();
        lastNameTfield.setEditable(false);
        lastNameTfield.setBounds(480, 150, 300, 30);
        lastNameTfield.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lastNameTfield.setBackground(Color.decode("#3f3f3f"));
        lastNameTfield.setForeground(Color.WHITE);
        lastNameTfield.setBorder(BorderFactory.createEmptyBorder());

        String[] ages = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99"};
        ageComboBox = new JComboBox(ages);
        ageComboBox.setBackground(Color.decode("#3f3f3f"));
        ageComboBox.setEnabled(false);
        ageComboBox.setVisible(false);
        ageComboBox.setBorder(BorderFactory.createEmptyBorder());
        ageComboBox.setForeground(Color.WHITE);
        ageComboBox.setFont(new Font("Segoe UI", Font.BOLD,16));
        ageComboBox.setBounds(480,190,100,22);

        String ageValue = ageComboBox.getSelectedItem().toString();
        age = new JLabel(ageValue);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Segoe UI", Font.BOLD,16));
        age.setBounds(480,190,100,22);

        String[] sexes = {"Male","Female"};
        sexComboBox = new JComboBox(sexes);
        sexComboBox.setBackground(Color.decode("#3f3f3f"));
        sexComboBox.setEnabled(false);
        sexComboBox.setVisible(false);
        sexComboBox.setBorder(BorderFactory.createEmptyBorder());
        sexComboBox.setForeground(Color.WHITE);
        sexComboBox.setFont(new Font("Segoe UI", Font.BOLD,16));
        sexComboBox.setBounds(480,230,100,22);

        String sexValue = sexComboBox.getSelectedItem().toString();
        sex = new JLabel(sexValue);
        sex.setForeground(Color.WHITE);
        sex.setFont(new Font("Segoe UI", Font.BOLD,16));
        sex.setBounds(480,230,100,22);

//        lastNameTfield = new JTextField();
//        lastNameTfield.setEditable(false);
//        lastNameTfield.setBounds(480, 150, 300, 30);
//        lastNameTfield.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        lastNameTfield.setBackground(Color.decode("#3f3f3f"));
//        lastNameTfield.setForeground(Color.WHITE);
//        lastNameTfield.setBorder(BorderFactory.createEmptyBorder());

        email = new JTextField();
        email.setEditable(false);
        email.setBounds(415, 270, 350, 30);
        email.setFont(new Font("Segoe UI", Font.BOLD, 16));
        email.setBackground(Color.decode("#3f3f3f"));
        email.setForeground(Color.WHITE);
        email.setBorder(BorderFactory.createEmptyBorder());

        degree = new JTextField();
        degree.setEditable(false);
        degree.setBounds(415, 310, 350, 30);
        degree.setFont(new Font("Segoe UI", Font.BOLD, 16));
        degree.setBackground(Color.decode("#3f3f3f"));
        degree.setForeground(Color.WHITE);
        degree.setBorder(BorderFactory.createEmptyBorder());

        //---------------P A N E L S-------------------------------------------------------------

        greetingPanel = new RoundedPanel();
        greetingPanel.setBounds(315, 13, 340, 45);
        greetingPanel.setBackground(Color.decode("#d98659"));
        greetingPanel.setLayout(null);

        profInfoPanel = new RoundedPanel();
        profInfoPanel.setBounds(30, 85, 923, 380);
        profInfoPanel.setBackground(Color.decode("#3f3f3f"));
        profInfoPanel.setLayout(null);

        editPanel = new RoundedPanel();
        editPanel.setBounds(820, 315, 80, 35);
        editPanel.setLayout(null);
        editPanel.setBackground(Color.decode("#3f3f3f"));

        savePanel = new RoundedPanel();
        savePanel.setBounds(820, 315, 80, 35);
        savePanel.setLayout(null);
        savePanel.setBackground(Color.decode("#3f3f3f"));
        savePanel.setVisible(false);

        box1 = new JPanel();
        box1.setBounds(300, 40, 10, 10);
        box1.setBackground(Color.decode("#ffbd37"));

        box2 = new JPanel();
        box2.setBounds(300, 80, 10, 10);
        box2.setBackground(Color.decode("#ffbd37"));

        box3 = new JPanel();
        box3.setBounds(300, 120, 10, 10);
        box3.setBackground(Color.decode("#ffbd37"));

        box4 = new JPanel();
        box4.setBounds(300, 160, 10, 10);
        box4.setBackground(Color.decode("#ffbd37"));

        box5 = new JPanel();
        box5.setBounds(300, 200, 10, 10);
        box5.setBackground(Color.decode("#ffbd37"));

        box6 = new JPanel();
        box6.setBounds(300, 240, 10, 10);
        box6.setBackground(Color.decode("#ffbd37"));

        box7 = new JPanel();
        box7.setBounds(300, 280, 10, 10);
        box7.setBackground(Color.decode("#ffbd37"));

        box8 = new JPanel();
        box8.setBounds(300, 320, 10, 10);
        box8.setBackground(Color.decode("#ffbd37"));

        //background Panels
        background1 = new JPanel();
        background1.setBackground(Color.decode("#cfcfcf"));
        background1.setPreferredSize(new Dimension(100, 525));
        background1.setLayout(null);

        background2 = new JPanel();
        background2.setBackground(Color.decode("#d98659"));
        background2.setPreferredSize(new Dimension(50, 50));

        //Menu Icon
        ImageIcon menu = new ImageIcon(getClass().getResource("icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15,10,50,50);

        //adding
        profInfoFrame.add(background1, BorderLayout.NORTH);
        profInfoFrame.add(background2, BorderLayout.SOUTH);

        background1.add(profInfoPanel);
        background1.add(greetingPanel);
        background1.add(menuIcon);

        //components inside the profInfoPanel (black panel)
        profInfoPanel.add(editable);
        profInfoPanel.add(savePanel);
        profInfoPanel.add(editPanel);
        profInfoPanel.add(profIcon);
        profInfoPanel.add(iconBackground);
        profInfoPanel.add(box1);
        profInfoPanel.add(box2);
        profInfoPanel.add(box3);
        profInfoPanel.add(box4);
        profInfoPanel.add(box5);
        profInfoPanel.add(box6);
        profInfoPanel.add(box7);
        profInfoPanel.add(box8);

        //labels
        profInfoPanel.add(prefixLabel);
        profInfoPanel.add(firstNameLabel);
        profInfoPanel.add(middleNameLabel);
        profInfoPanel.add(lastNameLabel);
        profInfoPanel.add(ageLabel);
        profInfoPanel.add(sexLabel);
        profInfoPanel.add(emailLabel);
        profInfoPanel.add(degreeLabel);

        //text fields

        profInfoPanel.add(prefixComboBox);
        profInfoPanel.add(prefixTfield);
        profInfoPanel.add(firstNameTfield);
        profInfoPanel.add(middleInitialTfield);
        profInfoPanel.add(lastNameTfield);
        profInfoPanel.add(ageComboBox);
        profInfoPanel.add(sexComboBox);
        profInfoPanel.add(age);
        profInfoPanel.add(sex);
        profInfoPanel.add(email);
        profInfoPanel.add(degree);

        editPanel.add(editLabel);
        savePanel.add(saveLabel);
        greetingPanel.add(greetingLabel);

        profInfoFrame.setVisible(true);


        //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
        //Menu Frame
        menuFrame.setTitle("MENU");
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.setBackground(Color.decode("#cfcfcf"));
        menuFrame.setLayout(null);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);
        menuFrame.setBounds(320,180,151,380);
        //Inside Menu Pane

        //Student Profile Panel
        studentProfilePanel = new RoundedPanel();
        studentProfilePanel.setBounds(5,50,150,80);
        studentProfilePanel.setBackground(Color.decode("#d98659"));
        studentProfilePanel.setLayout(null);
        studentProfileLabel = new JLabel("PROFESSOR");
        studentProfileLabel.setForeground(Color.DARK_GRAY);
        studentProfileLabel.setBounds(20,10,150,20);
        studentProfileLabel2 = new JLabel("PROFILE");
        studentProfileLabel2.setForeground(Color.DARK_GRAY);
        studentProfileLabel2.setBounds(33,30,100,20);
        studentProfileLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        studentProfileLabel2.setFont(new Font("Segoe UI", Font.BOLD,18));
        studentProfilePanel.add(studentProfileLabel);
        studentProfilePanel.add(studentProfileLabel2);

        //Schedule Panel
        seeSchedulePanel = new RoundedPanel();
        seeSchedulePanel.setBounds(5,130,150,80);
        seeSchedulePanel.setBackground(Color.decode("#d98659"));
        seeSchedulePanel.setLayout(null);
        seeSchedLabel = new JLabel("SEE");
        seeSchedLabel.setForeground(Color.white);
        seeSchedLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        seeSchedLabel.setBounds(51,10,50,20);
        seeSchedulePanel.add(seeSchedLabel);
        seeSchedLabel2 = new JLabel("SCHEDULE");
        seeSchedLabel2.setForeground(Color.white);
        seeSchedLabel2.setFont(new Font("Segoe UI", Font.BOLD,18));
        seeSchedLabel2.setBounds(23,30,100,20);
        seeSchedulePanel.add(seeSchedLabel2);

        //See Grade Panel
        encodeGradesPanel = new RoundedPanel();
        encodeGradesPanel.setBounds(5,210,150,80);
        encodeGradesPanel.setBackground(Color.decode("#d98659"));
        encodeGradesPanel.setLayout(null);
        encodeGradesLabel = new JLabel("ENCODE");
        encodeGradesLabel.setBounds(33,10,100,20);
        encodeGradesLabel2 = new JLabel("GRADES");
        encodeGradesLabel2.setBounds(33,30,100,20);
        encodeGradesLabel.setForeground(Color.white);
        encodeGradesLabel2.setForeground(Color.white);
        encodeGradesLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        encodeGradesLabel2.setFont(new Font("Segoe UI", Font.BOLD,18));
        encodeGradesPanel.add(encodeGradesLabel);
        encodeGradesPanel.add(encodeGradesLabel2);

        //Logout Panel
        logoutPanel = new RoundedPanel();
        logoutPanel.setBounds(5,290,150,80);
        logoutPanel.setBackground(Color.decode("#d98659"));
        logoutPanel.setLayout(null);
        logoutLabel = new JLabel("LOGOUT");
        logoutLabel.setForeground(Color.white);
        logoutLabel.setFont(new Font("Segoe UI", Font.BOLD,23));
        logoutLabel.setBounds(22,18,100,30);
        logoutPanel.add(logoutLabel);

        menuLabel = new JLabel("MENU");
        menuLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
        menuLabel.setForeground(Color.decode("#d98659"));
        menuLabel.setBounds(8,15,50,15);

        ___menu = new JLabel("•••••••••••••••••••••••••");
        ___menu.setForeground(Color.decode("#d98659"));
        ___menu.setBounds(10,29,200,10);

        //add Menus
        menuFrame.add(menuLabel);
        menuFrame.add(___menu);
        menuFrame.add(studentProfilePanel);
        menuFrame.add(encodeGradesPanel);
        menuFrame.add(seeSchedulePanel);
        menuFrame.add(logoutPanel);

        menuFrame.setUndecorated(true);
        menuFrame.setVisible(false);
    }

    @Override
    public void update(Observable o, Object arg) {
        greetingLabel.setText("Hello, " + model.getCurrentlyLoggedIn().get("prefix") + " " + model.getCurrentlyLoggedIn().get("lastName") + "!");
        prefixTfield.setText(model.getCurrentlyLoggedIn().get("prefix"));
        firstNameTfield.setText(model.getCurrentlyLoggedIn().get("firstName"));
        middleInitialTfield.setText(model.getCurrentlyLoggedIn().get("middleInitial"));
        lastNameTfield.setText(model.getCurrentlyLoggedIn().get("lastName"));
        age.setText(model.getCurrentlyLoggedIn().get("age"));
        sex.setText(model.getCurrentlyLoggedIn().get("sex"));
        degree.setText(model.getCurrentlyLoggedIn().get("degree"));
        email.setText(model.getCurrentlyLoggedIn().get("email"));
    }
}