package views;

import controllers.SetScheduleController;
import models.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class SetScheduleView implements Observer {

    public Enrollment enrollModel;
    public Student studentModel;

    public JFrame MainFrame = new JFrame();

    JPanel graybackground1, bottombackground2;
    JPanel scrollPanel = new JPanel();
    public RoundedPanel infoTable, introPanel, setPanel, removePanel;
    JScrollPane ScrollPane = new JScrollPane();
    public JLabel scrollLabel = new JLabel() , gradesLabel1, menuIcon, subjectsLabel, sectionLabel, dayLabel, timeLabel,
                                                SetSubjectsLabel, SetSectionLabel, SetDayLabel, SetTimeLabel;

    public JLabel setLabel = new JLabel();
    public JLabel removeLabel = new JLabel();

    List<JLabel> sectionLabels = new ArrayList<>();
    List<RoundedPanel> removePanels = new ArrayList<>();
    List<RoundedPanel> setPanels = new ArrayList<>();

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    //Menu Frame Declaration
    public JFrame menuFrame = new JFrame();
    public RoundedPanel studentProfilePanel, seeGradePanel, setSchedulePanel, studentCalendarPanel, logoutPanel;
    JPanel pinkPanel = new JPanel();
    public JLabel menuLabel, ___menu, ___sched, studentProfileLabel, seeGradesLabel, setSchedLabel, studentCalLabel, logoutLabel, studentProfileLabel2, seeGradesLabel2, setSchedLabel2, studentCalLabel2;

    List<JLabel> days = new ArrayList<>();
    List<JLabel> times = new ArrayList<>();

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
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

            g2d.setColor(new Color(253,208,72,255));
            g2d.draw(shape);
            g2d.dispose();
        }
    }

    //constructor
    public SetScheduleView(Student studentModel, Enrollment enrollModel) {
        this.studentModel = studentModel;
        this.enrollModel = enrollModel;
        SetScheduleView();
    }

    public void SetScheduleView() {
        MainFrame.setSize(1000, 600);
        MainFrame.setTitle("Student Set Schedule");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setLayout(null);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setResizable(false);

        //Menu Icon
        ImageIcon menu = new ImageIcon(getClass().getResource("Icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15,10,50,50);
        MainFrame.add(menuIcon);

        //gradeLabel
        gradesLabel1 = new JLabel("SET SCHEDULE");
        gradesLabel1.setHorizontalAlignment(JLabel.CENTER);
        gradesLabel1.setPreferredSize(new Dimension(450,50));
        gradesLabel1.setForeground(Color.WHITE);
        gradesLabel1.setFont(new Font("Segoe UI", Font.BOLD, 26));

        //background Panels
        graybackground1 = new JPanel();
        graybackground1.setBackground(Color.decode("#cfcfcf"));
        graybackground1.setBounds(0,0,1000,545);
        graybackground1.setLayout(null);

        //Pink Panel
        pinkPanel = new JPanel();
        pinkPanel.setBackground(Color.decode("#d98659"));
        pinkPanel.setBounds(0,545,1000,30);
        pinkPanel.setLayout(null);

        bottombackground2 = new JPanel();
        bottombackground2.setBackground(Color.decode("#d98659"));
        bottombackground2.setPreferredSize(new Dimension(50, 50));

        //gradeTable
        infoTable = new RoundedPanel();
        infoTable.setBounds(45, 75, 910, 460);
        infoTable.setBackground(Color.decode("#3f3f3f"));
        infoTable.setLayout(null);

        introPanel = new RoundedPanel();
        introPanel.setBounds(280, 15, 450, 55);
        introPanel.setLayout(new BorderLayout());
        introPanel.setBackground(Color.decode("#d98659"));

//◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘

        //Labels for Set Schedules
        subjectsLabel = new JLabel("SUBJECTS");
        subjectsLabel.setForeground(Color.WHITE);
        subjectsLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
        subjectsLabel.setBounds(10,10,150,20);

        sectionLabel = new JLabel("SECTION");
        sectionLabel.setForeground(Color.WHITE);
        sectionLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
        sectionLabel.setBounds(180,10,100,20);

        dayLabel = new JLabel("DAY");
        dayLabel.setForeground(Color.WHITE);
        dayLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
        dayLabel.setBounds(320,10,100,20);

        timeLabel = new JLabel("TIME");
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
        timeLabel.setBounds(480,10,100,20);

        ___sched = new JLabel("_________________________________________________________________________________________________________________________________________");
        ___sched.setForeground(Color.decode("#d98659"));
        ___sched.setBounds(10,30,910,20);

        //Labels inside the Sched Panel
        //schedulePanel.setBounds(0,5,880,50);
        // Looping Panel of Schedule

        String[] subjects = {"CS 002", "CS 001", "PE 001", "MATH 014", "GEC 004"};

        for(int x = 0; x < subjects.length; x++) {

            scrollPanel.setBounds(0, 0, 800, 400);
            scrollPanel.setBackground(Color.decode("#3f3f3f"));
            scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
            scrollPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            ImageIcon container = new ImageIcon(getClass().getResource("icons\\WhitePanel.png"));
            scrollLabel = new JLabel(container);
            scrollLabel.setLayout(null);
            MainFrame.add(scrollPanel);
            scrollPanel.add(scrollLabel);

            SetSubjectsLabel = new JLabel(subjects[x]);
            SetSubjectsLabel.setBounds(10,10,140,25);
            SetSubjectsLabel.setForeground(Color.BLACK);
            SetSubjectsLabel.setFont(new Font("Segoe UI", Font.BOLD,22));

            setLabel = new JLabel("SET");
            setLabel.setForeground(Color.WHITE);
            setLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
            setLabel.setBounds(25,5,70,17);
            setPanel = new RoundedPanel();
            setPanel.setLayout(null);
            setPanel.setBackground(Color.ORANGE);
            setPanel.setBounds(765,8,90,40);
            setPanel.addMouseListener(new SetScheduleController.setPanel(this, SetSubjectsLabel));
            setPanels.add(setPanel);

            //Remove Button
            removeLabel = new JLabel("REMOVE");
            removeLabel.setForeground(Color.WHITE);
            removeLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
            removeLabel.setBounds(5,5,70,17);
            removePanel = new RoundedPanel();
            removePanel.setLayout(null);
            removePanel.setBackground(Color.ORANGE);
            removePanel.setBounds(765,8,90,40);
            removePanel.addMouseListener(new SetScheduleController.removePanel(this, studentModel, SetSubjectsLabel, enrollModel));
            removePanel.setVisible(false);
            removePanels.add(removePanel);

            SetSectionLabel = new JLabel("N/A");
            SetSectionLabel.setBounds(170,10,100,25);
            SetSectionLabel.setForeground(Color.BLACK);
            SetSectionLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
            sectionLabels.add(SetSectionLabel);

            SetDayLabel = new JLabel("N/A");
            SetDayLabel.setBounds(310,10,150,25);
            SetDayLabel.setForeground(Color.BLACK);
            SetDayLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
            days.add(SetDayLabel);

            SetTimeLabel = new JLabel("N/A");
            SetTimeLabel.setBounds(470,10,230,25);
            SetTimeLabel.setForeground(Color.BLACK);
            SetTimeLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
            times.add(SetTimeLabel);

            //add
            scrollLabel.add(SetSubjectsLabel);
            scrollLabel.add(SetSectionLabel);
            scrollLabel.add(SetDayLabel);
            scrollLabel.add(SetTimeLabel);
            scrollLabel.add(setPanel);
            scrollLabel.add(removePanel);
            removePanel.add(removeLabel);
            setPanel.add(setLabel);

            scrollPanel.add(scrollLabel);

            //JScrollPane
            ScrollPane = new JScrollPane(scrollPanel);
            ScrollPane.getVerticalScrollBar().setUnitIncrement(18);
            ScrollPane.setBackground(Color.decode("#3f3f3f"));
            ScrollPane.setBorder(null);
            ScrollPane.setOpaque(true);
            ScrollPane.setBounds(55, 125, 880, 400);

        }

//◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘

        //add
        MainFrame.add(ScrollPane);
        MainFrame.add(graybackground1, BorderLayout.CENTER);
        MainFrame.add(bottombackground2);
        MainFrame.add(pinkPanel);

        introPanel.add(gradesLabel1);

        graybackground1.add(infoTable);
        graybackground1.add(introPanel);
        graybackground1.add(menuIcon);

        setPanel.add(setLabel);

        //add Set Schedules
        infoTable.add(subjectsLabel);
        infoTable.add(sectionLabel);
        infoTable.add(dayLabel);
        infoTable.add(timeLabel);
        infoTable.add(___sched);

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
        studentProfileLabel.setForeground(Color.WHITE);
        studentProfileLabel.setBounds(30,10,100,20);
        studentProfileLabel2 = new JLabel("PROFILE");
        studentProfileLabel2.setForeground(Color.WHITE);
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
        setSchedLabel.setForeground(Color.DARK_GRAY);
        setSchedLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        setSchedLabel.setBounds(51,10,50,20);
        setSchedulePanel.add(setSchedLabel);
        setSchedLabel2 = new JLabel("SCHEDULE");
        setSchedLabel2.setForeground(Color.DARK_GRAY);
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

        //SECTION LABELS

        //CS002
        if (studentModel.getCurrentlyLoggedIn().get("cs002_section").equals("null")) {
            sectionLabels.get(0).setText("N/A");
            days.get(0).setText("N/A");
            times.get(0).setText("N/A");
            removePanels.get(0).setVisible(false);
            setPanels.get(0).setVisible(true);
        } else {
            sectionLabels.get(0).setText(studentModel.getCurrentlyLoggedIn().get("cs002_section"));
            removePanels.get(0).setVisible(true);
            setPanels.get(0).setVisible(false);
        }

        //CS001
        if (studentModel.getCurrentlyLoggedIn().get("cs001_section").equals("null")) {
            sectionLabels.get(1).setText("N/A");
            days.get(1).setText("N/A");
            times.get(1).setText("N/A");
            removePanels.get(1).setVisible(false);
            setPanels.get(1).setVisible(true);
        } else {
            sectionLabels.get(1).setText(studentModel.getCurrentlyLoggedIn().get("cs001_section"));
            removePanels.get(1).setVisible(true);
            setPanels.get(1).setVisible(false);
        }

        //PE001
        if (studentModel.getCurrentlyLoggedIn().get("pe001_section").equals("null")) {
            sectionLabels.get(2).setText("N/A");
            days.get(2).setText("N/A");
            times.get(2).setText("N/A");
            removePanels.get(2).setVisible(false);
            setPanels.get(2).setVisible(true);
        } else {
            sectionLabels.get(2).setText(studentModel.getCurrentlyLoggedIn().get("pe001_section"));
            removePanels.get(2).setVisible(true);
            setPanels.get(2).setVisible(false);
        }

        //MATH014
        if (studentModel.getCurrentlyLoggedIn().get("math014_section").equals("null")) {
            sectionLabels.get(3).setText("N/A");
            days.get(3).setText("N/A");
            times.get(3).setText("N/A");
            removePanels.get(3).setVisible(false);
            setPanels.get(3).setVisible(true);
        } else {
            sectionLabels.get(3).setText(studentModel.getCurrentlyLoggedIn().get("math014_section"));
            removePanels.get(3).setVisible(true);
            setPanels.get(3).setVisible(false);
        }

        //GEC004
        if (studentModel.getCurrentlyLoggedIn().get("gec004_section").equals("null")) {
            sectionLabels.get(4).setText("N/A");
            days.get(4).setText("N/A");
            times.get(4).setText("N/A");
            removePanels.get(4).setVisible(false);
            setPanels.get(4).setVisible(true);
        } else {
            sectionLabels.get(4).setText(studentModel.getCurrentlyLoggedIn().get("gec004_section"));
            removePanels.get(4).setVisible(true);
            setPanels.get(4).setVisible(false);
        }


        //DAY AND TIME

        //CS 002
        if(studentModel.getCurrentlyLoggedIn().get("cs002_section").equals("CS11S1")){
            days.get(0).setText("Monday");
            times.get(0).setText("08:00 AM - 10:30 AM");
        }
        else if(studentModel.getCurrentlyLoggedIn().get("cs002_section").equals("CS11S2")){
            days.get(0).setText("Tuesday");
            times.get(0).setText("10:30 AM - 01:00 PM");
        }

        //CS 001
        if(studentModel.getCurrentlyLoggedIn().get("cs001_section").equals("CS11S1")){
            days.get(1).setText("Tuesday");
            times.get(1).setText("08:00 AM - 10:30 AM");
        }
        else if(studentModel.getCurrentlyLoggedIn().get("cs001_section").equals("CS11S2")){
            days.get(1).setText("Wednesday");
            times.get(1).setText("10:30 AM - 01:00 PM");
        }

        //PE 001
        if(studentModel.getCurrentlyLoggedIn().get("pe001_section").equals("CS11S1")){
            days.get(2).setText("Wednesday");
            times.get(2).setText("08:00 AM - 10:30 AM");
        }
        else if(studentModel.getCurrentlyLoggedIn().get("pe001_section").equals("CS11S2")){
            days.get(2).setText("Thursday");
            times.get(2).setText("10:30 AM - 01:00 PM");
        }

        //MATH 014
        if(studentModel.getCurrentlyLoggedIn().get("math014_section").equals("CS11S1")){
            days.get(3).setText("Thursday");
            times.get(3).setText("08:00 AM - 10:30 AM");
        }
        else if(studentModel.getCurrentlyLoggedIn().get("math014_section").equals("CS11S2")){
            days.get(3).setText("Friday");
            times.get(3).setText("10:30 AM - 01:00 PM");
        }

        //GEC 004
        if(studentModel.getCurrentlyLoggedIn().get("gec004_section").equals("CS11S1")){
            days.get(4).setText("Friday");
            times.get(4).setText("08:00 AM - 10:30 AM");
        }
        else if(studentModel.getCurrentlyLoggedIn().get("gec004_section").equals("CS11S2")){
            days.get(4).setText("Saturday");
            times.get(4).setText("10:30 AM - 01:00 PM");
        }
    }
}

