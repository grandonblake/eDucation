package views;

import models.Student;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;


public class StudentCalendarView implements Observer {
    public JFrame MainFrame = new JFrame();

    public Student studentModel;

    JPanel graybackground1, bottombackground2, scrollPanel;
    RoundedPanel infoTable, introPanel;
    JScrollPane ScrollPane = new JScrollPane();
    public JLabel gradesLabel1, menuIcon, subjectLabel, sectionLabel, professorLabel, subject, section, professor, day, time, timeLabel, DayLabel;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    public JFrame menuFrame = new JFrame();

    public RoundedPanel studentProfilePanel, seeGradePanel, setSchedulePanel, studentCalendarPanel, logoutPanel;
    JPanel pinkPanel;
    public JLabel menuLabel, ___menu, ___sched, scrollLabel, studentProfileLabel, seeGradesLabel, setSchedLabel, studentCalLabel, logoutLabel, studentProfileLabel2, seeGradesLabel2, setSchedLabel2, studentCalLabel2;

    public int counter;

    List<JLabel> days = new ArrayList<>();
    List<JLabel> subjects = new ArrayList<>();
    List<JLabel> sections = new ArrayList<>();
    List<JLabel> professors = new ArrayList<>();
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
            g2d.setColor(new Color(253, 208, 72, 255));
            g2d.draw(shape);
            g2d.dispose();
        }
    }

    //constructor
    public StudentCalendarView(Student studentModel) {

        this.studentModel = studentModel;
        StudentCalendarView();
    }

    public void StudentCalendarView() {
        MainFrame.setSize(1000, 600);
        MainFrame.setTitle("Student Calendar");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setLayout(null);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setResizable(false);

        //gradeLabel
        gradesLabel1 = new JLabel("CALENDAR");
        gradesLabel1.setHorizontalAlignment(JLabel.CENTER);
        gradesLabel1.setPreferredSize(new Dimension(450, 50));
        gradesLabel1.setForeground(Color.WHITE);
        gradesLabel1.setFont(new Font("Segoe UI", Font.BOLD, 26));

        //background Panels
        graybackground1 = new JPanel();
        graybackground1.setBackground(Color.decode("#cfcfcf"));
        graybackground1.setBounds(0, 0, 1000, 545);
        graybackground1.setLayout(null);

        //Pink Panel
        pinkPanel = new JPanel();
        pinkPanel.setBackground(Color.decode("#d98659"));
        pinkPanel.setBounds(0, 545, 1000, 30);
        pinkPanel.setLayout(null);

        //Menu Icon
        ImageIcon menu = new ImageIcon(getClass().getResource("icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15, 10, 50, 50);

        bottombackground2 = new JPanel();
        bottombackground2.setBackground(Color.decode("#d98659"));
        bottombackground2.setPreferredSize(new Dimension(50, 50));

        //gradeTable
        infoTable = new RoundedPanel();
        infoTable.setBounds(45, 75, 910, 460);
        infoTable.setBackground(Color.decode("#3f3f3f"));
        infoTable.setLayout(null);

        introPanel = new RoundedPanel();
        introPanel.setBounds(330, 15, 350, 45);
        introPanel.setLayout(new BorderLayout());
        introPanel.setBackground(Color.decode("#d98659"));

        //Labels for Set Schedules
        subjectLabel = new JLabel("SUBJECT");
        subjectLabel.setForeground(Color.WHITE);
        subjectLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        subjectLabel.setBounds(10, 10, 150, 20);

        sectionLabel = new JLabel("SECTION");
        sectionLabel.setForeground(Color.WHITE);
        sectionLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        sectionLabel.setBounds(180, 10, 150, 20);

        professorLabel = new JLabel("PROFESSOR");
        professorLabel.setForeground(Color.WHITE);
        professorLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        professorLabel.setBounds(310, 10, 150, 20);

        timeLabel = new JLabel("TIME");
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        timeLabel.setBounds(560, 10, 240, 20);

        ___sched = new JLabel("_________________________________________________________________________________________________________________________________________");
        ___sched.setForeground(Color.decode("#d98659"));
        ___sched.setBounds(10, 30, 910, 20);

        scrollPanel = new JPanel();


        //Menu Frame
        menuFrame.setTitle("MENU");
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.setBackground(Color.decode("#cfcfcf"));
        menuFrame.setLayout(null);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);
        menuFrame.setBounds(320, 180, 151, 460);
        //Inside Menu Pane

        //Student Profile Panel
        studentProfilePanel = new RoundedPanel();
        studentProfilePanel.setBounds(5, 50, 150, 80);
        studentProfilePanel.setBackground(Color.decode("#d98659"));
        studentProfilePanel.setLayout(null);
        studentProfileLabel = new JLabel("STUDENT");
        studentProfileLabel.setForeground(Color.WHITE);
        studentProfileLabel.setBounds(30, 10, 100, 20);
        studentProfileLabel2 = new JLabel("PROFILE");
        studentProfileLabel2.setForeground(Color.WHITE);
        studentProfileLabel2.setBounds(33, 30, 100, 20);
        studentProfileLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        studentProfileLabel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        studentProfilePanel.add(studentProfileLabel);
        studentProfilePanel.add(studentProfileLabel2);

        //Schedule Panel
        setSchedulePanel = new RoundedPanel();
        setSchedulePanel.setBounds(5, 130, 150, 80);
        setSchedulePanel.setBackground(Color.decode("#d98659"));
        setSchedulePanel.setLayout(null);
        setSchedLabel = new JLabel("SET");
        setSchedLabel.setForeground(Color.white);
        setSchedLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        setSchedLabel.setBounds(51, 10, 50, 20);
        setSchedulePanel.add(setSchedLabel);
        setSchedLabel2 = new JLabel("SCHEDULE");
        setSchedLabel2.setForeground(Color.white);
        setSchedLabel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        setSchedLabel2.setBounds(23, 30, 100, 20);
        setSchedulePanel.add(setSchedLabel2);

        //Student Calendar Panel
        studentCalendarPanel = new RoundedPanel();
        studentCalendarPanel.setBounds(5, 210, 150, 80);
        studentCalendarPanel.setBackground(Color.decode("#d98659"));
        studentCalendarPanel.setLayout(null);
        studentCalLabel = new JLabel("STUDENT");
        studentCalLabel.setForeground(Color.DARK_GRAY);
        studentCalLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        studentCalLabel.setBounds(30, 10, 100, 20);
        studentCalendarPanel.add(studentCalLabel);
        studentCalLabel2 = new JLabel("CALENDAR");
        studentCalLabel2.setForeground(Color.DARK_GRAY);
        studentCalLabel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        studentCalLabel2.setBounds(23, 30, 100, 20);
        studentCalendarPanel.add(studentCalLabel2);

        //See Grade Panel
        seeGradePanel = new RoundedPanel();
        seeGradePanel.setBounds(5, 290, 150, 80);
        seeGradePanel.setBackground(Color.decode("#d98659"));
        seeGradePanel.setLayout(null);
        seeGradesLabel = new JLabel("SEE");
        seeGradesLabel.setBounds(52, 10, 50, 20);
        seeGradesLabel2 = new JLabel("GRADES");
        seeGradesLabel2.setBounds(33, 30, 100, 20);
        seeGradesLabel.setForeground(Color.white);
        seeGradesLabel2.setForeground(Color.white);
        seeGradesLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        seeGradesLabel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        seeGradePanel.add(seeGradesLabel);
        seeGradePanel.add(seeGradesLabel2);

        //Logout Panel
        logoutPanel = new RoundedPanel();
        logoutPanel.setBounds(5, 370, 150, 80);
        logoutPanel.setBackground(Color.decode("#d98659"));
        logoutPanel.setLayout(null);
        logoutLabel = new JLabel("LOGOUT");
        logoutLabel.setForeground(Color.white);
        logoutLabel.setFont(new Font("Segoe UI", Font.BOLD, 23));
        logoutLabel.setBounds(22, 18, 100, 30);
        logoutPanel.add(logoutLabel);

        menuLabel = new JLabel("MENU");
        menuLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuLabel.setForeground(Color.decode("#d98659"));
        menuLabel.setBounds(8, 15, 50, 15);

        ___menu = new JLabel("•••••••••••••••••••••••••");
        ___menu.setForeground(Color.decode("#d98659"));
        ___menu.setBounds(10, 29, 200, 10);

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

        if (!(studentModel.getCurrentlyLoggedIn().get("cs002_section").equals("null"))) {
            counter += 1;
        }
        if (!(studentModel.getCurrentlyLoggedIn().get("gec004_section").equals("null"))) {
            counter += 1;
        }
        if (!(studentModel.getCurrentlyLoggedIn().get("pe001_section").equals("null"))) {
            counter += 1;
        }
        if (!(studentModel.getCurrentlyLoggedIn().get("math014_section").equals("null"))) {
            counter += 1;
        }
        if (!(studentModel.getCurrentlyLoggedIn().get("cs001_section").equals("null"))) {
            counter += 1;
        }

        boolean cs002Loop = true;
        boolean gec004Loop = true;
        boolean pe001Loop = true;
        boolean math014Loop = true;
        boolean cs001Loop = true;

        for (int i = 0; i < counter; i++) {
            ImageIcon container = new ImageIcon(getClass().getResource("icons\\OrangeWhitePanel.png"));
            scrollLabel = new JLabel(container);
            scrollPanel.setBounds(0, 0, 800, 400);
            scrollPanel.setBackground(Color.decode("#3f3f3f"));
            scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
            scrollPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            scrollLabel.setLayout(null);
            MainFrame.add(scrollPanel);
            scrollPanel.add(scrollLabel);

            //Day Label
            DayLabel = new JLabel("");
            DayLabel.setForeground(Color.WHITE);
            DayLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
            DayLabel.setBounds(13, 7, 100, 30);
            days.add(DayLabel);

            //Calendar Variables
            subject = new JLabel("sub");
            subject.setForeground(Color.BLACK);
            subject.setFont(new Font("Segoe UI", Font.BOLD, 22));
            subject.setBounds(13, 50, 150, 30);
            subjects.add(subject);

            section = new JLabel("sec");
            section.setForeground(Color.BLACK);
            section.setFont(new Font("Segoe UI", Font.BOLD, 22));
            section.setBounds(170, 50, 100, 30);
            sections.add(section);

            professor = new JLabel("prof");
            professor.setForeground(Color.BLACK);
            professor.setFont(new Font("Segoe UI", Font.BOLD, 22));
            professor.setBounds(300, 50, 250, 30);
            professors.add(professor);

            time = new JLabel("time");
            time.setForeground(Color.BLACK);
            time.setFont(new Font("Segoe UI", Font.BOLD, 22));
            time.setBounds(550, 50, 250, 30);
            times.add(time);

            scrollLabel.add(subject);
            scrollLabel.add(section);
            scrollLabel.add(professor);
            scrollLabel.add(time);
            scrollLabel.add(DayLabel);

            ScrollPane = new JScrollPane(scrollPanel);
            ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            ScrollPane.setBorder(null);
            ScrollPane.getVerticalScrollBar().setUnitIncrement(18);
            ScrollPane.setBounds(55, 125, 880, 380);
            ScrollPane.setBackground(Color.decode("#3f3f3f"));

            //CS 002
            boolean mainLoop = true;
            while(mainLoop){
                boolean breakCondition = false;

                if(cs002Loop){
                    if (studentModel.getCurrentlyLoggedIn().get("cs002_section").equals("CS11S1")) {
                        subjects.get(subjects.size() - 1).setText("CS 002");
                        sections.get(sections.size() - 1).setText(studentModel.getCurrentlyLoggedIn().get("cs002_section"));
                        days.get(days.size() - 1).setText("Monday");
                        professors.get(professors.size() - 1).setText("Mr. Glenn Flores");
                        times.get(times.size() - 1).setText("08:00 AM - 10:30 AM");
                        cs002Loop = false;
                        breakCondition = true;
                    }
                    else if (studentModel.getCurrentlyLoggedIn().get("cs002_section").equals("CS11S2")) {
                        subjects.get(subjects.size() - 1).setText("CS 002");
                        sections.get(sections.size() - 1).setText(studentModel.getCurrentlyLoggedIn().get("cs002_section"));
                        days.get(days.size() - 1).setText("Tuesday");
                        professors.get(professors.size() - 1).setText("Mr. Glenn Flores");
                        times.get(times.size() - 1).setText("10:30 AM - 01:00 PM");
                        cs002Loop = false;
                        breakCondition = true;
                    }
                }

                if(breakCondition){
                    break;
                }

                //CS 001
                if(cs001Loop){
                    if (studentModel.getCurrentlyLoggedIn().get("cs001_section").equals("CS11S1")) {
                        subjects.get(i).setText("CS 001");
                        sections.get(i).setText(studentModel.getCurrentlyLoggedIn().get("cs001_section"));
                        days.get(i).setText("Tuesday");
                        professors.get(i).setText("Mr. Xavier Cruz");
                        times.get(i).setText("08:00 AM - 10:30 AM");
                        cs001Loop = false;
                        breakCondition = true;
                    } else if (studentModel.getCurrentlyLoggedIn().get("cs001_section").equals("CS11S2")) {
                        subjects.get(i).setText("CS 001");
                        sections.get(i).setText(studentModel.getCurrentlyLoggedIn().get("cs001_section"));
                        days.get(i).setText("Wednesday");
                        professors.get(i).setText("Mr. Xavier Cruz");
                        times.get(i).setText("10:30 AM - 01:00 PM");
                        cs001Loop = false;
                        breakCondition = true;
                    }
                }

                if(breakCondition){
                    break;
                }

                //PE 001
                if(pe001Loop){
                    if (studentModel.getCurrentlyLoggedIn().get("pe001_section").equals("CS11S1")) {
                        subjects.get(i).setText("PE 001");
                        sections.get(i).setText(studentModel.getCurrentlyLoggedIn().get("pe001_section"));
                        days.get(i).setText("Wednesday");
                        professors.get(i).setText("Mr. Ryan Ramirez");
                        times.get(i).setText("08:00 AM - 10:30 AM");
                        pe001Loop = false;
                        breakCondition = true;
                    } else if (studentModel.getCurrentlyLoggedIn().get("pe001_section").equals("CS11S2")) {
                        subjects.get(i).setText("PE 001");
                        sections.get(i).setText(studentModel.getCurrentlyLoggedIn().get("pe001_section"));
                        days.get(i).setText("Thursday");
                        professors.get(i).setText("Mr. Ryan Ramirez");
                        times.get(i).setText("10:30 AM - 01:00 PM");
                        pe001Loop = false;
                        breakCondition = true;
                    }
                }

                if(breakCondition){
                    break;
                }

                //MATH 014
                if(math014Loop){
                    if (studentModel.getCurrentlyLoggedIn().get("math014_section").equals("CS11S1")) {
                        subjects.get(i).setText("MATH 014");
                        sections.get(i).setText(studentModel.getCurrentlyLoggedIn().get("math014_section"));
                        days.get(i).setText("Thursday");
                        professors.get(i).setText("Ms. Evangeline Diaz");
                        times.get(i).setText("08:00 AM - 10:30 AM");
                        math014Loop = false;
                        breakCondition = true;
                    } else if (studentModel.getCurrentlyLoggedIn().get("math014_section").equals("CS11S2")) {
                        subjects.get(i).setText("MATH 014");
                        sections.get(i).setText(studentModel.getCurrentlyLoggedIn().get("math014_section"));
                        days.get(i).setText("Friday");
                        professors.get(i).setText("Ms. Evangeline Diaz");
                        times.get(i).setText("10:30 AM  - 01:00 PM");
                        math014Loop = false;
                        breakCondition = true;
                    }
                }

                if(breakCondition){
                    break;
                }

                //GEC 004
                if(gec004Loop){
                    if (studentModel.getCurrentlyLoggedIn().get("gec004_section").equals("CS11S1")) {
                        subjects.get(subjects.size() - 1).setText("GEC 004");
                        sections.get(sections.size() - 1).setText(studentModel.getCurrentlyLoggedIn().get("gec004_section"));
                        days.get(days.size() - 1).setText("Friday");
                        professors.get(professors.size() - 1).setText("Mr. Tyler Lopez");
                        times.get(times.size() - 1).setText("08:00 AM - 10:30 AM");
                        gec004Loop = false;
                        breakCondition = true;
                    }
                    else if (studentModel.getCurrentlyLoggedIn().get("gec004_section").equals("CS11S2")) {
                        subjects.get(subjects.size() - 1).setText("GEC 004");
                        sections.get(sections.size() - 1).setText(studentModel.getCurrentlyLoggedIn().get("gec004_section"));
                        days.get(days.size() - 1).setText("Saturday");
                        professors.get(professors.size() - 1).setText("Mr. Tyler Lopez");
                        times.get(times.size() - 1).setText("10:30 AM - 01:00 PM");
                        gec004Loop = false;
                        breakCondition = true;
                    }
                }

                if(breakCondition){
                    break;
                }

                mainLoop = false;
            }
        }

        //add
        MainFrame.add(ScrollPane);
        MainFrame.add(graybackground1, BorderLayout.CENTER);
        MainFrame.add(bottombackground2);
        MainFrame.add(pinkPanel);

        introPanel.add(gradesLabel1);

        graybackground1.add(infoTable);
        graybackground1.add(introPanel);
        graybackground1.add(menuIcon);

        //add Set Schedules
        infoTable.add(subjectLabel);
        infoTable.add(sectionLabel);
        infoTable.add(professorLabel);
        infoTable.add(timeLabel);
        infoTable.add(___sched);

        MainFrame.setVisible(true); //so that the frame is visible
    }
}