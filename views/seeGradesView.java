package views;

import models.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class seeGradesView implements Observer {
    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    //Menu Frame Declaration
    public JFrame menuFrame = new JFrame();
    public RoundedPanel studentProfilePanel, seeGradePanel, setSchedulePanel, studentCalendarPanel, logoutPanel;
    public JLabel menuLabel, ___menu, studentProfileLabel, seeGradesLabel, setSchedLabel, studentCalLabel, logoutLabel, studentProfileLabel2, seeGradesLabel2, setSchedLabel2, studentCalLabel2;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    public JFrame MainFrame = new JFrame();

    public JScrollPane ScrollPane = new JScrollPane();

    JPanel background1, background2, scrollPanel = new JPanel();
    public RoundedPanel gradeTable, gwaPanel, grades, data;
    public JLabel scrollLabel, gradesLabel1, subjLabel, profLabel, gradesLabel2, lineLabel, gwaLabel, menuIcon, subjData, profData, gradeData, gwaData;

    List<JLabel> gradesDataArray = new ArrayList<>();
    List<JLabel> subjDataArray = new ArrayList<>();

    Student studentModel;
    Enrollment enrollmentModel;

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
    public seeGradesView(Student studentModel, Enrollment enrollmentModel) {
        this.studentModel = studentModel;
        this.enrollmentModel = enrollmentModel;
        seeGradesView();
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void seeGradesView() {
        MainFrame.setSize(1000, 600);
        MainFrame.setTitle("Student See Grades");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setLayout(new BorderLayout());
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setResizable(false);

        //Menu Icon------------------------------------------------------------------------------------------------------------------------------------------
        ImageIcon menu = new ImageIcon(getClass().getResource("icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15,10,50,50);
        //add Menu Icon
        MainFrame.add(menuIcon);
        //----------L A B E L S---------------------------------------------------------------------------------------------------------------
        //gwaLabel
        gwaLabel = new JLabel("GWA:  ");
        gwaLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gwaLabel.setForeground(Color.WHITE);
        gwaLabel.setBounds(20, 5, 200, 50);

        //gradeLabel
        gradesLabel1 = new JLabel("GRADES");
        gradesLabel1.setHorizontalAlignment(JLabel.CENTER);
        gradesLabel1.setVerticalAlignment(JLabel.CENTER);
        gradesLabel1.setForeground(Color.WHITE);
        gradesLabel1.setFont(new Font("Segoe UI", Font.BOLD, 20));

        //subjLabel
        subjLabel = new JLabel("SUBJECT");
        subjLabel.setBounds(25, 10, 150, 40);
        subjLabel.setForeground(Color.WHITE);
        subjLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        subjLabel.setBorder(BorderFactory.createEmptyBorder());

        //profLabel
        profLabel = new JLabel("PROFESSOR");
        profLabel.setBounds(210,  10, 150, 40);
        profLabel.setForeground(Color.WHITE);
        profLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        profLabel.setBorder(BorderFactory.createEmptyBorder());

        //gradesLabel2
        gradesLabel2 = new JLabel("GRADES");
        gradesLabel2.setBounds(760, 10, 90, 40);
        gradesLabel2.setForeground(Color.WHITE);
        gradesLabel2.setFont(new Font("Segoe UI", Font.BOLD, 22));
        gradesLabel2.setBorder(BorderFactory.createEmptyBorder());

        //lineLabel
        lineLabel = new JLabel("_________________________________________________________________________________________________________________________________");
        lineLabel.setForeground(Color.WHITE);
        lineLabel.setBounds(25, 25, 890, 30);

        String[] Subjects =  {"CS 002", "CS 001", "PE 001", "MATH 014", "GEC 004"};
        String[] ProfessorNames = {"Mr. Glenn Flores", "Mr. Xavier Cruz", "Mr. Ryan Ramirez", "Ms. Evangeline Diaz", "Mr. Tyler Lopez"};

        for(int x = 0; x < Subjects.length; x++) {

            scrollPanel.setBounds(0, 0, 800, 400);
            scrollPanel.setBackground(Color.decode("#3f3f3f"));
            scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
            scrollPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            ImageIcon container = new ImageIcon(getClass().getResource("icons\\WhitePanel.png"));
            scrollLabel = new JLabel(container);
            scrollLabel.setLayout(null);
            MainFrame.add(scrollPanel);
            scrollPanel.add(scrollLabel);

            subjData = new JLabel(Subjects[x]);
            subjData.setFont(new Font("Segoe UI", Font.BOLD, 22));
            subjData.setBounds(15, 15, 250, 20);
            scrollLabel.add(subjData);
            subjDataArray.add(subjData);

            profData = new JLabel(ProfessorNames[x]);
            profData.setFont(new Font("Segoe UI", Font.BOLD, 22));
            profData.setBounds(200, 10, 300, 30);
            scrollLabel.add(profData);

            gradeData = new JLabel("N/A");
            gradeData.setFont(new Font("Segoe UI", Font.BOLD, 22));
            gradeData.setBounds(750, 15, 100, 20);
            scrollLabel.add(gradeData);
            gradesDataArray.add(gradeData);

            scrollPanel.add(scrollLabel);

            //JScrollPane
            ScrollPane = new JScrollPane(scrollPanel);
            ScrollPane.getVerticalScrollBar().setUnitIncrement(18);
            ScrollPane.setBackground(Color.decode("#3f3f3f"));
            ScrollPane.setHorizontalScrollBarPolicy(ScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            ScrollPane.setBorder(null);
            ScrollPane.setOpaque(true);
            ScrollPane.setBounds(55, 125, 865, 280);

        }

        //---------P A N E L S------------------------------------------------------------------------------------------------------------

        //background Panels
        background1 = new JPanel();
        background1.setBackground(Color.decode("#cfcfcf"));
        background1.setPreferredSize(new Dimension(100, 535));
        background1.setLayout(null);

        background2 = new JPanel();
        background2.setBackground(Color.decode("#d98659"));
        background2.setPreferredSize(new Dimension(50, 30));

        //gradeTable
        gradeTable = new RoundedPanel();
        gradeTable.setBounds(45, 75, 890, 350);
        gradeTable.setBackground(Color.decode("#3f3f3f"));
        gradeTable.setLayout(null);

        gwaPanel = new RoundedPanel();
        gwaPanel.setBounds(705, 400, 230, 65);
        gwaPanel.setBackground(Color.decode("#ffbd37"));
        gwaPanel.setLayout(null);

        gwaData = new JLabel("N/A");
        gwaData.setForeground(Color.WHITE);
        gwaData.setFont(new Font("Segoe UI", Font.BOLD, 22));
        gwaData.setBounds(100, 20, 250, 20);
        gwaPanel.add(gwaData);

        grades = new RoundedPanel();
        grades.setBounds(450, 15, 100, 45);
        grades.setBackground(Color.decode("#d98659"));
        grades.setLayout(new BorderLayout());

        //data Panel(s)
        data = new RoundedPanel();
        data.setBounds(25, 60, 845, 50);
        data.setLayout(null);

        //add
        MainFrame.add(background1, BorderLayout.NORTH);
        MainFrame.add(background2, BorderLayout.SOUTH);

        grades.add(gradesLabel1, BorderLayout.CENTER);

        gradeTable.add(subjLabel);
        gradeTable.add(profLabel);
        gradeTable.add(gradesLabel2);
        gradeTable.add(lineLabel);

        gwaPanel.add(gwaLabel);

        background1.add(ScrollPane);
        background1.add(gradeTable);
        background1.add(gwaPanel);
        background1.add(grades);
        background1.add(menuIcon);

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
        seeGradesLabel.setForeground(Color.DARK_GRAY);
        seeGradesLabel2.setForeground(Color.DARK_GRAY);
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
        String subject;
        String section;
        if(subjDataArray.get(0).getText().equals("CS 002")){
            subject = "cs002";
            if(studentModel.getCurrentlyLoggedIn().get("cs002_section").equals("CS11S1") || studentModel.getCurrentlyLoggedIn().get("cs002_section").equals("CS11S2")) {
                section = studentModel.getCurrentlyLoggedIn().get("cs002_section");

                enrollmentModel.loadData(section + "_" + subject);

                for (int i = 0; i < enrollmentModel.getEnrollmentArray().size(); i++) {
                    if (enrollmentModel.getEnrollmentArray().get(i).get("student_username").equals(studentModel.getCurrentlyLoggedIn().get("username"))) {

                        float quiz_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_items"))) / 3) * 100) * .3);

                        float assignment_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_items"))) / 3) * 100) * .2);

                        float exam_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_items"))) / 2) * 100) * .5);

                        gradesDataArray.get(0).setText(String.format("%.2f", (quiz_grade + assignment_grade + exam_grade)));
                    }
                }
            }
        }

        if(subjDataArray.get(1).getText().equals("CS 001")){
            subject = "cs001";
            if(studentModel.getCurrentlyLoggedIn().get("cs001_section").equals("CS11S1") || studentModel.getCurrentlyLoggedIn().get("cs001_section").equals("CS11S2")){
                section = studentModel.getCurrentlyLoggedIn().get("cs001_section");

                enrollmentModel.loadData(section + "_" + subject);

                for(int i = 0; i < enrollmentModel.getEnrollmentArray().size(); i++){
                    if(enrollmentModel.getEnrollmentArray().get(i).get("student_username").equals(studentModel.getCurrentlyLoggedIn().get("username"))){

                        float quiz_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_items"))) / 3) * 100) * .3);

                        float assignment_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_items"))) / 3) * 100) * .2);

                        float exam_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_items"))) / 2) * 100) * .5);

                        gradesDataArray.get(1).setText(String.format("%.2f", (quiz_grade + assignment_grade + exam_grade)));
                    }
                }
            }
        }

        if(subjDataArray.get(2).getText().equals("PE 001")){
            subject = "pe001";
            if(studentModel.getCurrentlyLoggedIn().get("pe001_section").equals("CS11S1") || studentModel.getCurrentlyLoggedIn().get("pe001_section").equals("CS11S2")) {
                section = studentModel.getCurrentlyLoggedIn().get("pe001_section");

                enrollmentModel.loadData(section + "_" + subject);

                for (int i = 0; i < enrollmentModel.getEnrollmentArray().size(); i++) {
                    if (enrollmentModel.getEnrollmentArray().get(i).get("student_username").equals(studentModel.getCurrentlyLoggedIn().get("username"))) {

                        float quiz_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_items"))) / 3) * 100) * .3);

                        float assignment_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_items"))) / 3) * 100) * .2);

                        float exam_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_items"))) / 2) * 100) * .5);

                        gradesDataArray.get(2).setText(String.format("%.2f", (quiz_grade + assignment_grade + exam_grade)));
                    }
                }
            }
        }

        if(subjDataArray.get(3).getText().equals("MATH 014")){
            subject = "math014";
            if(studentModel.getCurrentlyLoggedIn().get("math014_section").equals("CS11S1") || studentModel.getCurrentlyLoggedIn().get("math014_section").equals("CS11S2")) {
                section = studentModel.getCurrentlyLoggedIn().get("math014_section");

                enrollmentModel.loadData(section + "_" + subject);

                for (int i = 0; i < enrollmentModel.getEnrollmentArray().size(); i++) {
                    if (enrollmentModel.getEnrollmentArray().get(i).get("student_username").equals(studentModel.getCurrentlyLoggedIn().get("username"))) {

                        float quiz_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_items"))) / 3) * 100) * .3);

                        float assignment_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_items"))) / 3) * 100) * .2);

                        float exam_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_items"))) / 2) * 100) * .5);

                        gradesDataArray.get(3).setText(String.format("%.2f", (quiz_grade + assignment_grade + exam_grade)));
                    }
                }
            }
        }

        if(subjDataArray.get(4).getText().equals("GEC 004")){
            subject = "gec004";
            if(studentModel.getCurrentlyLoggedIn().get("gec004_section").equals("CS11S1") || studentModel.getCurrentlyLoggedIn().get("gec004_section").equals("CS11S2")) {
                section = studentModel.getCurrentlyLoggedIn().get("gec004_section");

                enrollmentModel.loadData(section + "_" + subject);

                for (int i = 0; i < enrollmentModel.getEnrollmentArray().size(); i++) {
                    if (enrollmentModel.getEnrollmentArray().get(i).get("student_username").equals(studentModel.getCurrentlyLoggedIn().get("username"))) {

                        float quiz_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_items"))) / 3) * 100) * .3);

                        float assignment_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_items"))) / 3) * 100) * .2);

                        float exam_grade = (float) ((((((float) enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_items")) +
                                ((float) enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_score") / (float) enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_items"))) / 2) * 100) * .5);

                        gradesDataArray.get(4).setText(String.format("%.2f", (quiz_grade + assignment_grade + exam_grade)));
                    }
                }
            }
        }

        if(!gradesDataArray.get(0).getText().equals("N/A") && !gradesDataArray.get(1).getText().equals("N/A") && !gradesDataArray.get(2).getText().equals("N/A") && !gradesDataArray.get(3).getText().equals("N/A") && !gradesDataArray.get(4).getText().equals("N/A") &&
        !gradesDataArray.get(0).getText().equals("NaN") && !gradesDataArray.get(1).getText().equals("NaN") && !gradesDataArray.get(2).getText().equals("NaN") && !gradesDataArray.get(3).getText().equals("NaN") && !gradesDataArray.get(4).getText().equals("NaN")){
            gwaData.setText(String.format("%.2f", ((Float.parseFloat(gradesDataArray.get(0).getText()) + Float.parseFloat(gradesDataArray.get(1).getText()) + Float.parseFloat(gradesDataArray.get(2).getText()) + Float.parseFloat(gradesDataArray.get(3).getText()) +
                    Float.parseFloat(gradesDataArray.get(4).getText())) / 5)));
        }
    }
}

