package views;
import models.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class StudentMainView implements Observer {
    public Student model;


    public JFrame MainFrame = new JFrame();
    JPanel graybackground1, bottombackground2;
    RoundedPanel infoTable, introPanel, iconBackground;
    public RoundedPanel EditPanel, SavePanel;

    public JLabel gradesLabel1, bigStudentIcon, menuIcon, editLabel, saveLabel, firstNameLabel, middleNameLabel,
                    lastNameLabel, programLabel, ageJLabel, sexLabel, contactLabel, addressLabel, emailLabel, age, sex;
    JLabel box1, box2, box3, box4, box5, box6, box7, box8, box9;

    public JTextField firstName, middleName, lastName, program, contact, address, email;

    public JComboBox ageComboBox, sexComboBox;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    //Menu Frame Declaration
    public JFrame menuFrame = new JFrame();
    public RoundedPanel studentProfilePanel, seeGradePanel, setSchedulePanel, studentCalendarPanel, logoutPanel;
    JLabel menuLabel = new JLabel();
    JLabel ___menu = new JLabel();

    public JLabel studentProfileLabel, seeGradesLabel, setSchedLabel, studentCalLabel, logoutLabel;
    public JLabel studentProfileLabel2, seeGradesLabel2, setSchedLabel2, studentCalLabel2, editable;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    public static class RoundedPanel extends JPanel {
        private int shadowSize = 5;

        public RoundedPanel() {
            // This is very important, as part of the panel is going to be transparent
            setOpaque(false);
        }
        @Override
        public Insets getInsets() { return new Insets(0, 0, 10, 10); }
        @Override
        public Dimension getPreferredSize() { return new Dimension(200, 200); }
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
             * * THIS SHOULD BE CACHED AND ONLY UPDATED WHEN THE SIZE OF THE
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

    //constructor
    public StudentMainView() {
        model = new Student();
        StudentMainView();
    }

    public void StudentMainView() {
        MainFrame.setSize(1000, 600);
        MainFrame.setTitle("Student Main");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setLayout(null);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setResizable(false);

        //gradeLabel
        gradesLabel1 = new JLabel();
        gradesLabel1.setHorizontalAlignment(JLabel.CENTER);
        gradesLabel1.setPreferredSize(new Dimension(450,50));
        gradesLabel1.setForeground(Color.WHITE);
        gradesLabel1.setFont(new Font("Segoe UI", Font.BOLD, 26));

        //background Panels
        graybackground1 = new JPanel();
        graybackground1.setBackground(Color.decode("#cfcfcf"));
        graybackground1.setBounds(0,0,1000,600);
        graybackground1.setLayout(null);

        //Menu Icon
        ImageIcon menu = new ImageIcon(getClass().getResource("icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15,10,50,50);

        bottombackground2 = new JPanel();
        bottombackground2.setBackground(Color.decode("#d98659"));
        bottombackground2.setPreferredSize(new Dimension(50, 50));

        //gradeTable
        infoTable = new RoundedPanel();
        infoTable.setBounds(45, 75, 910, 420);
        infoTable.setBackground(Color.decode("#3f3f3f"));
        infoTable.setLayout(null);

        introPanel = new RoundedPanel();
        introPanel.setBounds(220, 15, 600, 55);
        introPanel.setLayout(new BorderLayout());
        introPanel.setBackground(Color.decode("#d98659"));

        iconBackground = new RoundedPanel();
        iconBackground.setBackground(Color.decode("#202020"));
        iconBackground.setBounds(100,30,95,360);
        iconBackground.setLayout(null);

        //Info Labels
        ImageIcon bigIcon = new ImageIcon(getClass().getResource("icons\\BigStudentIcon.png"));
        bigStudentIcon = new JLabel(bigIcon);
        bigStudentIcon.setBounds(15,60,250,250);

        firstNameLabel = new JLabel("FIRST NAME: ");
        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
        firstNameLabel.setBounds(320,40,140,20);

        middleNameLabel = new JLabel("MIDDLE NAME: ");
        middleNameLabel.setForeground(Color.WHITE);
        middleNameLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
        middleNameLabel.setBounds(320,80,140,20);

        lastNameLabel = new JLabel("LAST NAME: ");
        lastNameLabel.setForeground(Color.WHITE);
        lastNameLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
        lastNameLabel.setBounds(320,120,140,20);

        programLabel = new JLabel("PROGRAM: ");
        programLabel.setForeground(Color.WHITE);
        programLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
        programLabel.setBounds(320,160,100,20);

        ageJLabel = new JLabel("AGE: ");
        ageJLabel.setForeground(Color.WHITE);
        ageJLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
        ageJLabel.setBounds(320,200,100,20);

        sexLabel = new JLabel("SEX: ");
        sexLabel.setForeground(Color.WHITE);
        sexLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
        sexLabel.setBounds(320,240,100,20);

        contactLabel = new JLabel("CONTACT NUMBER: ");
        contactLabel.setForeground(Color.WHITE);
        contactLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
        contactLabel.setBounds(320,280,200,20);

        addressLabel = new JLabel("ADDRESS: ");
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
        addressLabel.setBounds(320,320,100,20);

        emailLabel = new JLabel("EMAIL: ");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
        emailLabel.setBounds(320,360,100,20);

        // .getInfo
        firstName = new JTextField("");
        firstName.setBackground(Color.decode("#3f3f3f"));
        firstName.setEditable(false);
        firstName.setBorder(null);
        firstName.setForeground(Color.WHITE);
        firstName.setFont(new Font("Segoe UI", Font.BOLD,16));
        firstName.setBounds(470,40,120,22);

        middleName = new JTextField("");
        middleName.setBackground(Color.decode("#3f3f3f"));
        middleName.setEditable(false);
        middleName.setBorder(null);
        middleName.setForeground(Color.WHITE);
        middleName.setFont(new Font("Segoe UI", Font.BOLD,16));
        middleName.setBounds(470,80,120,22);

        lastName = new JTextField("");
        lastName.setBackground(Color.decode("#3f3f3f"));
        lastName.setEditable(false);
        lastName.setBorder(null);
        lastName.setForeground(Color.WHITE);
        lastName.setFont(new Font("Segoe UI", Font.BOLD,16));
        lastName.setBounds(470,120,120,22);

        program = new JTextField("");
        program.setBackground(Color.decode("#3f3f3f"));
        program.setEditable(false);
        program.setBorder(null);
        program.setForeground(Color.WHITE);
        program.setFont(new Font("Segoe UI", Font.BOLD,16));
        program.setBounds(420,160,350,22);

        //COMBO BOX

        String[] ages = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99"};
        ageComboBox = new JComboBox(ages);
        ageComboBox.setBackground(Color.decode("#3f3f3f"));
        ageComboBox.setEnabled(false);
        ageComboBox.setVisible(false);
        ageComboBox.setBorder(BorderFactory.createEmptyBorder());
        ageComboBox.setForeground(Color.WHITE);
        ageComboBox.setFont(new Font("Segoe UI", Font.BOLD,16));
        ageComboBox.setBounds(370,200,100,22);

        String ageValue = ageComboBox.getSelectedItem().toString();
        age = new JLabel(ageValue);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Segoe UI", Font.BOLD,16));
        age.setBounds(370,200,100,22);

        String[] sexes = {"Male","Female"};
        sexComboBox = new JComboBox(sexes);
        sexComboBox.setBackground(Color.decode("#3f3f3f"));
        sexComboBox.setEnabled(false);
        sexComboBox.setVisible(false);
        sexComboBox.setBorder(BorderFactory.createEmptyBorder());
        sexComboBox.setForeground(Color.WHITE);
        sexComboBox.setFont(new Font("Segoe UI", Font.BOLD,16));
        sexComboBox.setBounds(370,240,100,22);

        String sexValue = sexComboBox.getSelectedItem().toString();
        sex = new JLabel(sexValue);
        sex.setForeground(Color.WHITE);
        sex.setFont(new Font("Segoe UI", Font.BOLD,16));
        sex.setBounds(370,240,100,22);

        contact = new JTextField("");
        contact.setBackground(Color.decode("#3f3f3f"));
        contact.setEditable(false);
        contact.setBorder(null);
        contact.setForeground(Color.WHITE);
        contact.setFont(new Font("Segoe UI", Font.BOLD,16));
        contact.setBounds(490,280,300,22);

        address = new JTextField("San ba bahay mo?");
        address.setBackground(Color.decode("#3f3f3f"));
        address.setEditable(false);
        address.setBorder(null);
        address.setForeground(Color.WHITE);
        address.setFont(new Font("Segoe UI", Font.BOLD,16));
        address.setBounds(410,320,300,22);

        email = new JTextField("");
        email.setBackground(Color.decode("#3f3f3f"));
        email.setEditable(false);
        email.setBorder(null);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Segoe UI", Font.BOLD,16));
        email.setBounds(410,360,200,22);

        //BOXES
        box1 = new JLabel("■");
        box1.setForeground(Color.decode("#ffbd37"));
        box1.setBounds(290,40,200,22);

        box2 = new JLabel("■");
        box2.setForeground(Color.decode("#ffbd37"));
        box2.setBounds(290,80,200,22);

        box3 = new JLabel("■");
        box3.setForeground(Color.decode("#ffbd37"));
        box3.setBounds(290,120,200,22);

        box4 = new JLabel("■");
        box4.setForeground(Color.decode("#ffbd37"));
        box4.setBounds(290,160,200,22);

        box5 = new JLabel("■");
        box5.setForeground(Color.decode("#ffbd37"));
        box5.setBounds(290,200,200,22);

        box6 = new JLabel("■");
        box6.setForeground(Color.decode("#ffbd37"));
        box6.setBounds(290,240,200,22);

        box7 = new JLabel("■");
        box7.setForeground(Color.decode("#ffbd37"));
        box7.setBounds(290,280,200,22);

        box8 = new JLabel("■");
        box8.setForeground(Color.decode("#ffbd37"));
        box8.setBounds(290,320,200,22);

        box9 = new JLabel("■");
        box9.setForeground(Color.decode("#ffbd37"));
        box9.setBounds(290,360,200,22);

        editable = new JLabel("EDITABLE");
        editable.setForeground(Color.YELLOW);
        editable.setBounds(800,-5,100,60);
        editable.setFont(new Font("Segoe UI", Font.BOLD,12));
        editable.setVisible(false);

        //add
        MainFrame.add(bottombackground2);
        MainFrame.add(graybackground1, BorderLayout.CENTER);
        introPanel.add(gradesLabel1);
        graybackground1.add(infoTable);
        graybackground1.add(introPanel);
        graybackground1.add(menuIcon);
        //adding infos
        infoTable.add(firstNameLabel);
        infoTable.add(middleNameLabel);
        infoTable.add(lastNameLabel);
        infoTable.add(programLabel);
        infoTable.add(ageJLabel);
        infoTable.add(sexLabel);
        infoTable.add(contactLabel);
        infoTable.add(addressLabel);
        infoTable.add(emailLabel);
        infoTable.add(bigStudentIcon);
        infoTable.add(iconBackground);
        infoTable.add(firstName);
        infoTable.add(middleName);
        infoTable.add(lastName);
        infoTable.add(program);
        infoTable.add(ageComboBox);
        infoTable.add(sexComboBox);
        infoTable.add(age);
        infoTable.add(sex);
        infoTable.add(contact);
        infoTable.add(address);
        infoTable.add(email);
        infoTable.add(box1);
        infoTable.add(box2);
        infoTable.add(box3);
        infoTable.add(box4);
        infoTable.add(box5);
        infoTable.add(box6);
        infoTable.add(box7);
        infoTable.add(box8);
        infoTable.add(box9);
        infoTable.add(editable);

        //Edit Panel and Label
        EditPanel = new RoundedPanel();
        EditPanel.setLayout(new BorderLayout());
        EditPanel.setBounds(810,370,80,35);
        EditPanel.setBackground(Color.decode("#3f3f3f"));
        infoTable.add(EditPanel);

        SavePanel = new RoundedPanel();
        SavePanel.setLayout(new BorderLayout());
        SavePanel.setBounds(810,370,80,35);
        SavePanel.setBackground(Color.decode("#3f3f3f"));
        infoTable.add(SavePanel);

        saveLabel = new JLabel("SAVE");
        saveLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        saveLabel.setForeground(Color.WHITE);
        saveLabel.setBounds(15, 0, 100, 20);
        saveLabel.setHorizontalAlignment(JLabel.CENTER);
        SavePanel.add(saveLabel, BorderLayout.CENTER);

        editLabel = new JLabel("EDIT");
        editLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        editLabel.setForeground(Color.WHITE);
        editLabel.setBounds(15, 0, 100, 20);
        editLabel.setHorizontalAlignment(JLabel.CENTER);
        EditPanel.add(editLabel, BorderLayout.CENTER);

        MainFrame.setVisible(true); //so that the frame is visible

//◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘

        //Menu Frame
        menuFrame.setTitle("MENU");
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.setBackground(Color.decode("#cfcfcf"));
        menuFrame.setLayout(null);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);
        menuFrame.setBounds(320,180,151,460);
        //Inside Menu Pane

        //Student Profile Panel
        studentProfilePanel = new RoundedPanel();
        studentProfilePanel.setBounds(5,50,150,80);
        studentProfilePanel.setBackground(Color.decode("#d98659"));
        studentProfilePanel.setLayout(null);
        studentProfileLabel = new JLabel("STUDENT");
        studentProfileLabel.setForeground(Color.DARK_GRAY);
        studentProfileLabel.setBounds(30,10,100,20);
        studentProfileLabel2 = new JLabel("PROFILE");
        studentProfileLabel2.setForeground(Color.DARK_GRAY);
        studentProfileLabel2.setBounds(33,30,100,20);
        studentProfileLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        studentProfileLabel2.setFont(new Font("Segoe UI", Font.BOLD,18));
        studentProfilePanel.add(studentProfileLabel);
        studentProfilePanel.add(studentProfileLabel2);

        //Schedule Panel
        setSchedulePanel = new RoundedPanel();
        setSchedulePanel.setBounds(5,130,150,80);
        setSchedulePanel.setBackground(Color.decode("#d98659"));
        setSchedulePanel.setLayout(null);
        setSchedLabel = new JLabel("SET");
        setSchedLabel.setForeground(Color.white);
        setSchedLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        setSchedLabel.setBounds(51,10,50,20);
        setSchedulePanel.add(setSchedLabel);
        setSchedLabel2 = new JLabel("SCHEDULE");
        setSchedLabel2.setForeground(Color.white);
        setSchedLabel2.setFont(new Font("Segoe UI", Font.BOLD,18));
        setSchedLabel2.setBounds(23,30,100,20);
        setSchedulePanel.add(setSchedLabel2);

        //Student Calendar Panel
        studentCalendarPanel = new RoundedPanel();
        studentCalendarPanel.setBounds(5,210,150,80);
        studentCalendarPanel.setBackground(Color.decode("#d98659"));
        studentCalendarPanel.setLayout(null);
        studentCalLabel = new JLabel("STUDENT");
        studentCalLabel.setForeground(Color.white);
        studentCalLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        studentCalLabel.setBounds(30,10,100,20);
        studentCalendarPanel.add(studentCalLabel);
        studentCalLabel2 = new JLabel("CALENDAR");
        studentCalLabel2.setForeground(Color.white);
        studentCalLabel2.setFont(new Font("Segoe UI", Font.BOLD,18));
        studentCalLabel2.setBounds(23,30,100,20);
        studentCalendarPanel.add(studentCalLabel2);

        //See Grade Panel
        seeGradePanel = new RoundedPanel();
        seeGradePanel.setBounds(5,290,150,80);
        seeGradePanel.setBackground(Color.decode("#d98659"));
        seeGradePanel.setLayout(null);
        seeGradesLabel = new JLabel("SEE");
        seeGradesLabel.setBounds(52,10,50,20);
        seeGradesLabel2 = new JLabel("GRADES");
        seeGradesLabel2.setBounds(33,30,100,20);
        seeGradesLabel.setForeground(Color.white);
        seeGradesLabel2.setForeground(Color.white);
        seeGradesLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        seeGradesLabel2.setFont(new Font("Segoe UI", Font.BOLD,18));
        seeGradePanel.add(seeGradesLabel);
        seeGradePanel.add(seeGradesLabel2);

        //Logout Panel
        logoutPanel = new RoundedPanel();
        logoutPanel.setBounds(5,370,150,80);
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
        menuFrame.add(seeGradePanel);
        menuFrame.add(setSchedulePanel);
        menuFrame.add(studentCalendarPanel);
        menuFrame.add(logoutPanel);
        menuFrame.setUndecorated(true);
        menuFrame.setVisible(false);
    }

    @Override
    public void update(Observable o, Object arg) {

        gradesLabel1.setText("Hello, Student " + model.getCurrentlyLoggedIn().get("lastName") + "!");
        firstName.setText(model.getCurrentlyLoggedIn().get("firstName"));
        middleName.setText(model.getCurrentlyLoggedIn().get("middleName"));
        lastName.setText(model.getCurrentlyLoggedIn().get("lastName"));
        program.setText(model.getCurrentlyLoggedIn().get("program"));
        age.setText(model.getCurrentlyLoggedIn().get("age"));
        sex.setText(model.getCurrentlyLoggedIn().get("sex"));
        contact.setText(model.getCurrentlyLoggedIn().get("contactNumber"));
        address.setText(model.getCurrentlyLoggedIn().get("address"));
        email.setText(model.getCurrentlyLoggedIn().get("email"));
    }
}

