package views;

import models.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class InstructorArrowSeeScheduleView implements Observer {

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
    //JFrame declaration
    public JFrame arrowProfstudentListFrame = new JFrame();
    JPanel background1, background2, scrollPanel = new JPanel();
    public RoundedPanel stuListBackground, stuListIcon, sectionIcon, dataPanel, backPanel;
    JScrollPane scrollPane = new JScrollPane();
    public JLabel stuListLbl, sectionLbl, menuIcon, studentLbl, programLbl, emailLbl, lineLbl, studentData, emailData, programData, scrollLabel, backLabel;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    //Menu Frame
    public JFrame menuFrame = new JFrame();
    public RoundedPanel studentProfilePanel, encodeGradesPanel, seeSchedulePanel, logoutPanel;
    public JLabel menuLabel, ___menu, studentProfileLabel, encodeGradesLabel, seeSchedLabel, logoutLabel, studentProfileLabel2, encodeGradesLabel2, seeSchedLabel2;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘

    List<JLabel> studentDataArray = new ArrayList<>();
    List<JLabel> programDataArray = new ArrayList<>();
    List<JLabel> emailDataArray = new ArrayList<>();

    JLabel sectionData;
    JLabel subjData;

    private Student studentModel;

    public InstructorArrowSeeScheduleView(Student studentModel, JLabel sectionData, JLabel subjData) {
        this.studentModel = studentModel;
        this.sectionData = sectionData;
        this.subjData = subjData;
        InstructorArrowSeeScheduleView();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------

    public void InstructorArrowSeeScheduleView() {

        arrowProfstudentListFrame.setSize(1000, 600);
        arrowProfstudentListFrame.setTitle("Instructor Student List");
        arrowProfstudentListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        arrowProfstudentListFrame.setLayout(new BorderLayout());
        arrowProfstudentListFrame.setLocationRelativeTo(null);
        arrowProfstudentListFrame.setResizable(false);

        //-------------------L A B E L S---------------------------------------------------------------------------------------------------------------------

        stuListLbl = new JLabel();
        stuListLbl.setText("STUDENT LIST");
        stuListLbl.setBounds(7,5,200,20);
        stuListLbl.setFont(new Font("Segoe UI", Font.BOLD, 24));
        stuListLbl.setForeground(Color.WHITE);

        sectionLbl = new JLabel();
        sectionLbl.setText(sectionData.getText());
        sectionLbl.setFont(new Font("Segoe UI", Font.BOLD, 24));
        sectionLbl.setForeground(Color.WHITE);

        //Menu Icon
        ImageIcon menu = new ImageIcon(getClass().getResource("icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15,10,50,50);
        arrowProfstudentListFrame.add(menuIcon);

        studentLbl = new JLabel();
        studentLbl.setText("STUDENT");
        studentLbl.setFont(new Font("Segoe UI", Font.BOLD, 22));
        studentLbl.setForeground(Color.WHITE);
        studentLbl.setBounds(30, 10, 150, 30);

        programLbl = new JLabel();
        programLbl.setText("PROGRAM");
        programLbl.setFont(new Font("Segoe UI", Font.BOLD, 22));
        programLbl.setForeground(Color.WHITE);
        programLbl.setBounds(348, 10, 150, 30);

        emailLbl = new JLabel();
        emailLbl.setText("EMAIL");
        emailLbl.setFont(new Font("Segoe UI", Font.BOLD, 22));
        emailLbl.setForeground(Color.WHITE);
        emailLbl.setBounds(560, 10, 150, 30);

        backLabel = new JLabel("BACK");
        backLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        backLabel.setForeground(Color.WHITE);
        backLabel.setBounds(5,3,100,18);

        lineLbl = new JLabel();
        lineLbl.setText("___________________________________________________________________________________________________________________________________");
        lineLbl.setForeground(Color.decode("#e1a938"));
        lineLbl.setBounds(20, 20, 850, 30);

        int counter = 0;

        //CS 002
        if(subjData.getText().equals("CS 002")) {
            //CS11S1
            if (sectionData.getText().equals("CS11S1")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                        counter += 1;
                    }
                }
            }
            //CS11S2
            else if(sectionData.getText().equals("CS11S2")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S2")) {
                        counter += 1;
                    }
                }
            }
        }

        //CS 001
        if(subjData.getText().equals("CS 001")) {;
            //CS11S1
            if (sectionData.getText().equals("CS11S1")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("cs001_section").equals("CS11S1")) {
                        counter += 1;
                    }
                }
            }
            //CS11S2
            else if(sectionData.getText().equals("CS11S2")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("cs001_section").equals("CS11S2")) {
                        counter += 1;
                    }
                }
            }
        }

        //PE 001
        if(subjData.getText().equals("PE 001")) {;
            //CS11S1
            if (sectionData.getText().equals("CS11S1")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("pe001_section").equals("CS11S1")) {
                        counter += 1;
                    }
                }
            }
            //CS11S2
            else if(sectionData.getText().equals("CS11S2")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("pe001_section").equals("CS11S2")) {
                        counter += 1;
                    }
                }
            }
        }

        //MATH 014
        if(subjData.getText().equals("MATH 014")) {;
            //CS11S1
            if (sectionData.getText().equals("CS11S1")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("math014_section").equals("CS11S1")) {
                        counter += 1;
                    }
                }
            }
            //CS11S2
            else if(sectionData.getText().equals("CS11S2")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("math014_section").equals("CS11S2")) {
                        counter += 1;
                    }
                }
            }
        }

        //GEC 004
        if(subjData.getText().equals("GEC 004")) {;
            //CS11S1
            if (sectionData.getText().equals("CS11S1")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("gec004_section").equals("CS11S1")) {
                        counter += 1;
                    }
                }
            }
            //CS11S2
            else if(sectionData.getText().equals("CS11S2")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("gec004_section").equals("CS11S2")) {
                        counter += 1;
                    }
                }
            }
        }

        // Looping JScrollPane
        for(int x=0; x < counter; x++) {

            scrollPanel.setBounds(0, 0, 800, 400);
            scrollPanel.setBackground(Color.decode("#3f3f3f"));
            scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
            scrollPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            ImageIcon container = new ImageIcon(getClass().getResource("icons\\WhitePanel.png"));
            scrollLabel = new JLabel(container);
            scrollLabel.setLayout(null);
            arrowProfstudentListFrame.add(scrollPanel);

            //Labels-------------------------------------------------------------------------------------------------

            studentData = new JLabel();
            studentData.setFont(new Font("Segoe UI", Font.BOLD, 16));
            studentData.setBounds(5, 13, 250, 25);
            studentDataArray.add(studentData);

            programData = new JLabel();
            programData.setFont(new Font("Segoe UI", Font.BOLD, 16));
            programData.setBounds(320, 13, 200, 25);
            programDataArray.add(programData);

            emailData = new JLabel();
            emailData.setFont(new Font("Segoe UI", Font.BOLD, 16));
            emailData.setBounds(558, 13, 350, 25);
            emailDataArray.add(emailData);

            //add
            scrollLabel.add(studentData);
            scrollLabel.add(programData);
            scrollLabel.add(emailData);
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

        backPanel = new RoundedPanel();
        backPanel.setLayout(null);
        backPanel.setBackground(Color.decode("#d98659"));
        backPanel.setBounds(75,20,80,40);
        background1.add(backPanel);
        backPanel.add(backLabel);

        dataPanel = new RoundedPanel();
        dataPanel.setBounds(20, 50, 846, 50);
        dataPanel.setLayout(null);

        //add
        arrowProfstudentListFrame.add(background1, BorderLayout.NORTH);
        arrowProfstudentListFrame.add(background2, BorderLayout.SOUTH);

        background1.add(scrollPane);
        background1.add(stuListBackground);
        background1.add(stuListIcon);
        background1.add(sectionIcon);
        background1.add(menuIcon);

        stuListBackground.add(studentLbl);
        stuListBackground.add(programLbl);
        stuListBackground.add(emailLbl);
        stuListBackground.add(lineLbl);

        stuListIcon.add(stuListLbl);
        sectionIcon.add(sectionLbl);

        arrowProfstudentListFrame.setVisible(true);

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
        List<String> studentNames = new ArrayList<>();
        List<String> studentEmails = new ArrayList<>();

        //CS 002
        if(subjData.getText().equals("CS 002")) {
            //CS11S1
            if (sectionData.getText().equals("CS11S1")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S1")) {
                        String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                        String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                        String email = studentModel.getStudentUsernameArray().get(i).get("email");

                        studentNames.add(firstName + " " + lastName);
                        studentEmails.add(email);
                    }
                }
            }
            //CS11S2
            else if(sectionData.getText().equals("CS11S2")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("cs002_section").equals("CS11S2")) {
                        String firstName = studentModel.getStudentUsernameArray().get(i).get("firstNameame");
                        String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                        String email = studentModel.getStudentUsernameArray().get(i).get("email");

                        studentNames.add(firstName + " " + lastName);
                        studentEmails.add(email);
                    }
                }
            }
        }

        //CS 001
        if(subjData.getText().equals("CS 001")) {
            //CS11S1
            if (sectionData.getText().equals("CS11S1")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("cs001_section").equals("CS11S1")) {
                        String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                        String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                        String email = studentModel.getStudentUsernameArray().get(i).get("email");

                        studentNames.add(firstName + " " + lastName);
                        studentEmails.add(email);
                    }
                }
            }
            //CS11S2
            else if(sectionData.getText().equals("CS11S2")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("cs001_section").equals("CS11S2")) {
                        String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                        String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                        String email = studentModel.getStudentUsernameArray().get(i).get("email");

                        studentNames.add(firstName + " " + lastName);
                        studentEmails.add(email);
                    }
                }
            }
        }

        //PE 001
        if(subjData.getText().equals("PE 001")) {
            //CS11S1
            if (sectionData.getText().equals("CS11S1")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("pe001_section").equals("CS11S1")) {
                        String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                        String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                        String email = studentModel.getStudentUsernameArray().get(i).get("email");

                        studentNames.add(firstName + " " + lastName);
                        studentEmails.add(email);
                    }
                }
            }
            //CS11S2
            else if(sectionData.getText().equals("CS11S2")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("pe001_section").equals("CS11S2")) {
                        String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                        String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                        String email = studentModel.getStudentUsernameArray().get(i).get("email");

                        studentNames.add(firstName + " " + lastName);
                        studentEmails.add(email);
                    }
                }
            }
        }

        //MATH 014
        if(subjData.getText().equals("MATH 014")) {
            //CS11S1
            if (sectionData.getText().equals("CS11S1")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("math014_section").equals("CS11S1")) {
                        String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                        String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                        String email = studentModel.getStudentUsernameArray().get(i).get("email");

                        studentNames.add(firstName + " " + lastName);
                        studentEmails.add(email);
                    }
                }
            }
            //CS11S2
            else if(sectionData.getText().equals("CS11S2")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("math014_section").equals("CS11S2")) {
                        String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                        String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                        String email = studentModel.getStudentUsernameArray().get(i).get("email");

                        studentNames.add(firstName + " " + lastName);
                        studentEmails.add(email);
                    }
                }
            }
        }

        //GEC 004
        if(subjData.getText().equals("GEC 004")) {
            //CS11S1
            if (sectionData.getText().equals("CS11S1")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("gec004_section").equals("CS11S1")) {
                        String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                        String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                        String email = studentModel.getStudentUsernameArray().get(i).get("email");

                        studentNames.add(firstName + " " + lastName);
                        studentEmails.add(email);
                    }
                }
            }
            //CS11S2
            else if(sectionData.getText().equals("CS11S2")){
                for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
                    if (studentModel.getStudentUsernameArray().get(i).get("gec004_section").equals("CS11S2")) {
                        String firstName = studentModel.getStudentUsernameArray().get(i).get("firstName");
                        String lastName = studentModel.getStudentUsernameArray().get(i).get("lastName");
                        String email = studentModel.getStudentUsernameArray().get(i).get("email");

                        studentNames.add(firstName + " " + lastName);
                        studentEmails.add(email);
                    }
                }
            }
        }

        for (int i = 0; i < studentNames.size(); i++) {
            studentDataArray.get(i).setText(studentNames.get(i));
            programDataArray.get(i).setText("Computer Science");
            emailDataArray.get(i).setText(studentEmails.get(i));
        }
    }
}
