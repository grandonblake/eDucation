package views;

import controllers.StudentListController;
import models.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class StudentListView implements Observer {
    public JFrame studentListFrame = new JFrame();

    Instructor instructorModel;
    Student studentModel;
    Enrollment enrollmentModel;

    //JPanel declaration------------------------------------------------------------------------------------------------
    public JPanel background1 ,background2, scrollPanel, backPanel;
    public RoundedPanel stuListIcon, sectionIcon, dataPanel, stuListBackground, encodeIcon; //Panel that will contain the stuListLabel
    //JScroll Pane------------------------------------------------------------------------------------------------------
    JScrollPane scrollPane = new JScrollPane();
    //JLabel declaration------------------------------------------------------------------------------------------------
    public JLabel backLabel,stuListLbl,sectionLbl,menuIcon,studentLbl,statusLbl,lineLbl,studentData,statusData,encodeLabel,scrollLabel;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    public JFrame menuFrame = new JFrame();
    public RoundedPanel studentProfilePanel, encodeGradesPanel, seeSchedulePanel, logoutPanel;
    public JLabel menuLabel, ___menu, studentProfileLabel, encodeGradesLabel, seeSchedLabel, logoutLabel, studentProfileLabel2, encodeGradesLabel2, seeSchedLabel2;

    List<JLabel> studentDataArray = new ArrayList<>();
    List<JLabel> studentDataArray2 = new ArrayList<>();
    List<JLabel> statusDataArray = new ArrayList<>();
    List<String> studentNames = new ArrayList<>();
    List<String> studentNames2 = new ArrayList<>();
    List<String> studentStatus = new ArrayList<>();

    String section;
    String subjectTable;
    String studentDataString;

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
    public StudentListView(Student studentModel, Instructor instructorModel, Enrollment enrollmentModel, String section, String subjectTable) {
        this.studentModel = studentModel;
        this.instructorModel = instructorModel;
        this.enrollmentModel = enrollmentModel;
        this.section = section;
        this.subjectTable = subjectTable;
        StudentListView();
    }

    public void StudentListView() {
        studentListFrame.setSize(1000, 600);
        studentListFrame.setTitle("Instructor Student List");
        studentListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentListFrame.setLayout(new BorderLayout());
        studentListFrame.setLocationRelativeTo(null);
        studentListFrame.setResizable(false);
        //-------------------L A B E L S---------------------------------------------------------------------------------------------------------------------

        stuListLbl = new JLabel("STUDENT LIST");
        stuListLbl.setBounds(7,5,200,20);
        stuListLbl.setFont(new Font("Segoe UI", Font.BOLD, 24));
        stuListLbl.setForeground(Color.WHITE);

        sectionLbl = new JLabel(section);
        sectionLbl.setBounds(25,5,150,20);
        sectionLbl.setFont(new Font("Segoe UI", Font.BOLD, 24));
        sectionLbl.setForeground(Color.WHITE);

        //Menu Icon
        ImageIcon menu = new ImageIcon(getClass().getResource("icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15,10,50,50);
        studentListFrame.add(menuIcon);

        studentLbl = new JLabel("STUDENT");
        studentLbl.setFont(new Font("Segoe UI", Font.BOLD, 22));
        studentLbl.setForeground(Color.WHITE);
        studentLbl.setBounds(20, 10, 150, 30);

        statusLbl = new JLabel("STATUS");
        statusLbl.setFont(new Font("Segoe UI", Font.BOLD, 22));
        statusLbl.setForeground(Color.WHITE);
        statusLbl.setBounds(360, 10, 150, 30);

        backLabel = new JLabel("BACK");
        backLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        backLabel.setForeground(Color.WHITE);
        backLabel.setBounds(20,3,100,18);

        lineLbl = new JLabel("___________________________________________________________________________________________________________________________________");
        lineLbl.setForeground(Color.decode("#e1a938"));
        lineLbl.setBounds(20, 20, 850, 30);

        scrollPanel = new JPanel();
        // Looping JScrollPane
        for(int x = 0; x < instructorModel.numOfStudents(section + "_" + subjectTable); x++) {
            scrollPanel.setBounds(0, 0, 800, 400);
            scrollPanel.setBackground(Color.decode("#3f3f3f"));
            scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
            scrollPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            ImageIcon container = new ImageIcon(getClass().getResource("icons\\WhitePanel.png"));
            scrollLabel = new JLabel(container);
            scrollLabel.setLayout(null);
            studentListFrame.add(scrollPanel);

            //Labels-------------------------------------------------------------------------------------------------
            studentData = new JLabel();
            studentData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            studentData.setBounds(5, 10, 250, 25);
            studentDataArray.add(studentData);

            statusData = new JLabel();
            statusData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            statusData.setForeground(Color.decode("#b01c1c"));
            statusData.setBounds(340, 10, 200, 25);
            statusDataArray.add(statusData);

            encodeIcon = new RoundedPanel();
            encodeIcon.setBackground(Color.orange);
            encodeIcon.setLayout(null);
            encodeIcon.setBounds(740, 10, 100, 40);
            encodeLabel = new JLabel("ENCODE");
            encodeLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
            encodeLabel.setForeground(Color.WHITE);
            encodeLabel.setBounds(10, 3, 100, 20);
            encodeIcon.add(encodeLabel);

            //CS 002
            if(subjectTable.equals("cs002")) {
                //CS11S1
                if (section.equals("CS11S1")){
                    for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                        if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                            String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                            String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                            studentNames.add(firstName + " " + lastName);
                            studentNames2.add(studentModel.getStudentUsernameArray().get(i).get("username"));

                            enrollmentModel.loadData(section + "_" + subjectTable);

                            for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                                if(studentModel.getStudentUsernameArray().get(i).get("username").equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))){
                                    String status = enrollmentModel.getEnrollmentArray().get(j).get("status");
                                    studentStatus.add(status);
                                }
                            }
                        }
                    }
                }
                //CS11S2
                else if(section.equals("CS11S2")){
                    for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                        if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                            String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                            String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                            studentNames.add(firstName + " " + lastName);
                            studentNames2.add(studentModel.getStudentUsernameArray().get(i).get("username"));

                            enrollmentModel.loadData(section + "_" + subjectTable);

                            for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                                if(studentModel.getStudentUsernameArray().get(i).get("username").equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))){
                                    String status = enrollmentModel.getEnrollmentArray().get(j).get("status");
                                    studentStatus.add(status);
                                }
                            }
                        }
                    }
                }
            }

            //CS 001
            if(subjectTable.equals("cs001")) {
                //CS11S1
                if (section.equals("CS11S1")){
                    for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                        if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                            String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                            String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                            studentNames.add(firstName + " " + lastName);
                            studentNames2.add(studentModel.getStudentUsernameArray().get(i).get("username"));

                            enrollmentModel.loadData(section + "_" + subjectTable);

                            for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                                if(studentModel.getStudentUsernameArray().get(i).get("username").equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))){
                                    String status = enrollmentModel.getEnrollmentArray().get(j).get("status");
                                    studentStatus.add(status);
                                }
                            }
                        }
                    }
                }
                //CS11S2
                else if(section.equals("CS11S2")){
                    for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                        if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                            String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                            String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                            studentNames.add(firstName + " " + lastName);
                            studentNames2.add(studentModel.getStudentUsernameArray().get(i).get("username"));

                            enrollmentModel.loadData(section + "_" + subjectTable);

                            for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                                if(studentModel.getStudentUsernameArray().get(i).get("username").equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))){
                                    String status = enrollmentModel.getEnrollmentArray().get(j).get("status");
                                    studentStatus.add(status);
                                }
                            }
                        }
                    }
                }
            }

            //PE 001
            if(subjectTable.equals("pe001")) {
                //CS11S1
                if (section.equals("CS11S1")){
                    for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                        if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                            String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                            String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                            studentNames.add(firstName + " " + lastName);
                            studentNames2.add(studentModel.getStudentUsernameArray().get(i).get("username"));

                            enrollmentModel.loadData(section + "_" + subjectTable);

                            for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                                if(studentModel.getStudentUsernameArray().get(i).get("username").equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))){
                                    String status = enrollmentModel.getEnrollmentArray().get(j).get("status");
                                    studentStatus.add(status);
                                }
                            }
                        }
                    }
                }
                //CS11S2
                else if(section.equals("CS11S2")){
                    for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                        if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                            String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                            String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                            studentNames.add(firstName + " " + lastName);
                            studentNames2.add(studentModel.getStudentUsernameArray().get(i).get("username"));

                            enrollmentModel.loadData(section + "_" + subjectTable);

                            for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                                if(studentModel.getStudentUsernameArray().get(i).get("username").equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))){
                                    String status = enrollmentModel.getEnrollmentArray().get(j).get("status");
                                    studentStatus.add(status);
                                }
                            }
                        }
                    }
                }
            }

            //MATH 014
            if(subjectTable.equals("math014")) {
                //CS11S1
                if (section.equals("CS11S1")){
                    for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                        if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                            String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                            String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                            studentNames.add(firstName + " " + lastName);
                            studentNames2.add(studentModel.getStudentUsernameArray().get(i).get("username"));

                            enrollmentModel.loadData(section + "_" + subjectTable);

                            for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                                if(studentModel.getStudentUsernameArray().get(i).get("username").equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))){
                                    String status = enrollmentModel.getEnrollmentArray().get(j).get("status");
                                    studentStatus.add(status);
                                }
                            }
                        }
                    }
                }
                //CS11S2
                else if(section.equals("CS11S2")){
                    for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                        if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                            String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                            String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                            studentNames.add(firstName + " " + lastName);
                            studentNames2.add(studentModel.getStudentUsernameArray().get(i).get("username"));

                            enrollmentModel.loadData(section + "_" + subjectTable);

                            for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                                if(studentModel.getStudentUsernameArray().get(i).get("username").equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))){
                                    String status = enrollmentModel.getEnrollmentArray().get(j).get("status");
                                    studentStatus.add(status);
                                }
                            }
                        }
                    }
                }
            }

            //GEC 004
            if(subjectTable.equals("gec004")) {
                //CS11S1
                if (section.equals("CS11S1")){
                    for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                        if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                            String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                            String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                            studentNames.add(firstName + " " + lastName);
                            studentNames2.add(studentModel.getStudentUsernameArray().get(i).get("username"));

                            enrollmentModel.loadData(section + "_" + subjectTable);

                            for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                                if(studentModel.getStudentUsernameArray().get(i).get("username").equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))){
                                    String status = enrollmentModel.getEnrollmentArray().get(j).get("status");
                                    studentStatus.add(status);
                                }
                            }
                        }
                    }
                }
                //CS11S2
                else if(section.equals("CS11S2")){
                    for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                        if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                            String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                            String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                            studentNames.add(firstName + " " + lastName);
                            studentNames2.add(studentModel.getStudentUsernameArray().get(i).get("username"));

                            enrollmentModel.loadData(section + "_" + subjectTable);

                            for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                                if(studentModel.getStudentUsernameArray().get(i).get("username").equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))){
                                    String status = enrollmentModel.getEnrollmentArray().get(j).get("status");
                                    studentStatus.add(status);
                                }
                            }
                        }
                    }
                }
            }

            encodeIcon.addMouseListener(new StudentListController.encodeButton(this, section, studentNames2.get(x), subjectTable));
            scrollLabel.add(encodeIcon);

            //add
            scrollLabel.add(studentData);
            scrollLabel.add(statusData);
            scrollPanel.add(scrollLabel);

            //JScrollPane
            scrollPane = new JScrollPane(scrollPanel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(18);
            scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
            scrollPane.setBounds(57, 120, 885, 350);
        }
        //-------------------P A N E L S---------------------------------------------------------------------------------------------------------------------
        //background Panels
        background1 = new JPanel();
        background1.setBackground(Color.decode("#cfcfcf"));
        background1.setPreferredSize(new Dimension(150, 525));
        background1.setLayout(null);

        background2 = new JPanel();
        background2.setBackground(Color.decode("#d98659"));
        background2.setPreferredSize(new Dimension(50, 50));

        //Student List Background Panel
        stuListBackground = new RoundedPanel();
        stuListBackground.setBounds(45, 75, 910, 425);
        stuListBackground.setBackground(Color.decode("#3f3f3f"));
        stuListBackground.setLayout(null);

        stuListIcon = new RoundedPanel();
        stuListIcon.setBackground(Color.decode("#3f3f3f"));
        stuListIcon.setLayout(null);
        stuListIcon.setBounds(390, 20, 190, 45);

        sectionIcon = new RoundedPanel();
        sectionIcon.setBackground(Color.decode("#d98659"));
        sectionIcon.setLayout(new GridBagLayout());
        sectionIcon.setBounds(785, 20, 150, 45);

        dataPanel = new RoundedPanel();
        dataPanel.setBounds(20, 50, 846, 50);
        dataPanel.setLayout(null);

        backPanel = new RoundedPanel();
        backPanel.setLayout(null);
        backPanel.setBackground(Color.decode("#d98659"));
        backPanel.setBounds(75,20,100,40);
        background1.add(backPanel);

        backPanel.add(backLabel);

        //add
        studentListFrame.add(background1, BorderLayout.NORTH);
        studentListFrame.add(background2, BorderLayout.SOUTH);

        background1.add(scrollPane);
        background1.add(stuListBackground);
        background1.add(stuListIcon);
        background1.add(sectionIcon);

        background1.add(menuIcon);

        stuListBackground.add(studentLbl);
        stuListBackground.add(statusLbl);
        stuListBackground.add(lineLbl);

        stuListIcon.add(stuListLbl);

        sectionIcon.add(sectionLbl);

        studentListFrame.setVisible(true);

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
        studentProfileLabel.setForeground(Color.WHITE);
        studentProfileLabel.setBounds(20,10,150,20);
        studentProfileLabel2 = new JLabel("PROFILE");
        studentProfileLabel2.setForeground(Color.WHITE);
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
        if(studentDataArray.size() > 0 && statusDataArray.size() > 0){
            for (int i = 0; i < studentDataArray.size(); i++) {
                studentDataArray.get(i).setText(studentNames.get(i));
                statusDataArray.get(i).setText(studentStatus.get(i));
            }
        }
    }
}