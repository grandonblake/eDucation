package views;
import controllers.*;
import models.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class ChooseScheduleView implements Observer {
    public JFrame MainFrame = new JFrame();

    private Student studentModel;
    private Enrollment enrollmentModel;

    public JPanel graybackground1, bottombackground2, scrollPanel = new JPanel() , backPanel;
    public RoundedPanel infoTable, introPanel, selectPanel;
    JScrollPane ScrollPane = new JScrollPane();
    public JLabel backLabel, gradesLabel1, menuIcon, sectionLabel, professorLabel, dayLabel, timeLabel,
                    SetSectionLabel, ProfessorLabel, SetDayLabel, SetTimeLabel, slotLabel, SetSlotLabel,
                    setLabel, selectLabel, scrollLabel;

    private JLabel SetSubjectsLabel;

    List<JLabel> instructors = new ArrayList<>();
    List<JLabel> days = new ArrayList<>();
    List<JLabel> times = new ArrayList<>();
    String[] sections = {"CS11S1", "CS11S2"};

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    public JFrame menuFrame = new JFrame();

    public RoundedPanel studentProfilePanel, seeGradePanel, setSchedulePanel, studentCalendarPanel, logoutPanel;
    JPanel pinkPanel = new JPanel();
    public JLabel menuLabel, ___menu, ___sched, studentProfileLabel, seeGradesLabel, setSchedLabel, studentCalLabel, logoutLabel, studentProfileLabel2, seeGradesLabel2, setSchedLabel2, studentCalLabel2;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
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
    public ChooseScheduleView(JLabel SetSubjectsLabel, Student studentModel, Enrollment enrollmentModel)
    {
        this.SetSubjectsLabel = SetSubjectsLabel;
        this.studentModel = studentModel;
        this.enrollmentModel = enrollmentModel;
        ChooseScheduleView();
    }
    public void ChooseScheduleView() {
        MainFrame.setSize(1000, 600);
        MainFrame.setTitle("Student Choose Schedule");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setLayout(null);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setResizable(false);

        //gradeLabel
        gradesLabel1 = new JLabel("CHOOSE SCHEDULE");
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

        //Menu Icon
        ImageIcon menu = new ImageIcon(getClass().getResource("icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15,10,50,50);

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
        introPanel.setBackground(Color.BLACK);

//◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
        //Labels for Set Schedules
        sectionLabel = new JLabel("SECTION");
        sectionLabel.setForeground(Color.WHITE);
        sectionLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
        sectionLabel.setBounds(10,10,150,20);

        professorLabel = new JLabel("PROFESSOR");
        professorLabel.setForeground(Color.WHITE);
        professorLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
        professorLabel.setBounds(130,10,150,20);

        dayLabel = new JLabel("DAY");
        dayLabel.setForeground(Color.WHITE);
        dayLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
        dayLabel.setBounds(370,10,100,20);

        timeLabel = new JLabel("TIME");
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
        timeLabel.setBounds(520,10,100,20);

//        slotLabel = new JLabel("SLOTS");
//        slotLabel.setForeground(Color.WHITE);
//        slotLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
//        slotLabel.setBounds(700,10,100,20);

        ___sched = new JLabel("_________________________________________________________________________________________________________________________________________");
        ___sched.setForeground(Color.decode("#d98659"));
        ___sched.setBounds(10,30,910,20);

        backPanel = new RoundedPanel();
        backPanel.setLayout(null);
        backPanel.setBackground(Color.decode("#d98659"));
        backPanel.setBounds(75,20,80,40);
        graybackground1.add(backPanel);
        backPanel.addMouseListener(new ChooseScheduleController.backPanel(this));

        backLabel = new JLabel("BACK");
        backLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        backLabel.setForeground(Color.WHITE);
        backLabel.setBounds(5,3,100,18);
        backPanel.add(backLabel);

        //Labels inside the Sched Panel
        //schedulePanel.setBounds(0,5,880,50);
        // Looping Panel of Schedule

        for(int i = 0; i < 2; i++) {

            scrollPanel.setBounds(0, 0, 800, 400);
            scrollPanel.setBackground(Color.decode("#3f3f3f"));
            scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
            scrollPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            ImageIcon container = new ImageIcon(getClass().getResource("icons\\WhitePanel.png"));
            scrollLabel = new JLabel(container);
            scrollLabel.setLayout(null);
            MainFrame.add(scrollPanel);
            scrollPanel.add(scrollLabel);

            //Section
            SetSectionLabel = new JLabel(sections[i]);
            SetSectionLabel.setBounds(10,10,100,25);
            SetSectionLabel.setForeground(Color.BLACK);
            SetSectionLabel.setFont(new Font("Segoe UI", Font.BOLD,22));

            //Professor
            ProfessorLabel = new JLabel("");
            ProfessorLabel.setBounds(120,10,240,25);
            ProfessorLabel.setForeground(Color.BLACK);
            ProfessorLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
            instructors.add(ProfessorLabel);

            //DAYS
            SetDayLabel = new JLabel("");
            SetDayLabel.setBounds(360,10,130,25);
            SetDayLabel.setForeground(Color.BLACK);
            SetDayLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
            days.add(SetDayLabel);

            //TIME
            SetTimeLabel = new JLabel("");
            SetTimeLabel.setBounds(510,10,240,25);
            SetTimeLabel.setForeground(Color.BLACK);
            SetTimeLabel.setFont(new Font("Segoe UI", Font.BOLD,22));
            times.add(SetTimeLabel);

            //SLOTS
//            SetSlotLabel = new JLabel("5");
//            SetSlotLabel.setBounds(690,10,100,25);
//            SetSlotLabel.setForeground(Color.BLACK);
//            SetSlotLabel.setFont(new Font("Segoe UI", Font.BOLD,22));

            //Remove Button
            selectLabel = new JLabel("SELECT");
            selectLabel.setForeground(Color.WHITE);
            selectLabel.setFont(new Font("Segoe UI", Font.BOLD,16));
            selectLabel.setBounds(13,5,70,17);
            selectPanel = new RoundedPanel();
            selectPanel.setLayout(null);
            selectPanel.setBackground(Color.ORANGE);
            selectPanel.setBounds(765,8,90,40);
            selectPanel.addMouseListener(new ChooseScheduleController.selectPanel(this, SetSectionLabel, SetSubjectsLabel, studentModel, enrollmentModel));

            //add
            scrollLabel.add(SetSectionLabel);
            scrollLabel.add(ProfessorLabel);
            scrollLabel.add(SetDayLabel);
            scrollLabel.add(SetTimeLabel);
            scrollLabel.add(selectPanel);
//            scrollLabel.add(SetSlotLabel);
            selectPanel.add(selectLabel);

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

        //add Set Schedules
        infoTable.add(sectionLabel);
        infoTable.add(professorLabel);
        infoTable.add(dayLabel);
        infoTable.add(timeLabel);
//        infoTable.add(slotLabel);
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
        //CS 002
        if(SetSubjectsLabel.getText().equals("CS 002")){
            instructors.get(0).setText("Mr. Glenn Flores");
            instructors.get(1).setText("Mr. Glenn Flores");

            if("CS11S1".equals(sections[0])){
                days.get(0).setText("Monday");
                times.get(0).setText("08:00 AM - 10:30 AM");
            }
            if("CS11S2".equals(sections[1])){
                days.get(1).setText("Tuesday");
                times.get(1).setText("10:30 AM - 01:00 PM");
            }
        }

        //GEC 004
        if(SetSubjectsLabel.getText().equals("GEC 004")){
            instructors.get(0).setText("Mr. Tyler Lopez");
            instructors.get(1).setText("Mr. Tyler Lopez");

            if("CS11S1".equals(sections[0])){
                days.get(0).setText("Friday");
                times.get(0).setText("08:00 AM - 10:30 AM");
            }
            if("CS11S2".equals(sections[1])){
                days.get(1).setText("Saturday");
                times.get(1).setText("10:30 AM - 01:00 PM");
            }
        }

        //PE 001
        if(SetSubjectsLabel.getText().equals("PE 001")){
            instructors.get(0).setText("Mr. Ryan Ramirez");
            instructors.get(1).setText("Mr. Ryan Ramirez");

            if("CS11S1".equals(sections[0])){
                days.get(0).setText("Wednesday");
                times.get(0).setText("08:00 AM - 10:30 AM");
            }
            if("CS11S2".equals(sections[1])){
                days.get(1).setText("Thursday");
                times.get(1).setText("10:30 AM - 01:00 PM");
            }
        }

        //MATH 014
        if(SetSubjectsLabel.getText().equals("MATH 014")){
            instructors.get(0).setText("Ms. Evangeline Diaz");
            instructors.get(1).setText("Ms. Evangeline Diaz");

            if("CS11S1".equals(sections[0])){
                days.get(0).setText("Thursday");
                times.get(0).setText("08:00 AM - 10:30 AM");
            }
            if("CS11S2".equals(sections[1])){
                days.get(1).setText("Friday");
                times.get(1).setText("10:30 AM - 01:00 PM");
            }
        }

        //CS 001
        if(SetSubjectsLabel.getText().equals("CS 001")){
            instructors.get(0).setText("Mr. Xavier Cruz");
            instructors.get(1).setText("Mr. Xavier Cruz");

            if("CS11S1".equals(sections[0])){
                days.get(0).setText("Tuesday");
                times.get(0).setText("08:00 AM - 10:30 AM");
            }
            if("CS11S2".equals(sections[1])){
                days.get(1).setText("Wednesday");
                times.get(1).setText("10:30 AM - 01:00 PM");
            }
        }
    }
}
