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

public class EncodeGradesView implements Observer {
    //JFrame Declaration-----------------------------------------------------------------------------------------------
    public JFrame encodeFrame = new JFrame();

    Instructor model;

    //JPanel declaration-----------------------------------------------------------------------------------------------
    public JPanel background1 = new JPanel();
    public JPanel background2, scrollPanel; //grey background
    public RoundedPanel encodeBackground, encodePanel; //black panel
    static RoundedPanel encodeIcon, editIcon; //this one needs to be implemented with mouse listener

    //JScroll Pane-----------------------------------------------------------------------------------------------------
    JScrollPane scrollPane = new JScrollPane();

    //JLabel declaration------------------------------------------------------------------------------------------------
    JLabel encodeLbl1, sectionLbl, subjLbl, gradedLbl, statLbl, lineLbl, encodeLabel, scrollLabel, actionLabel; //displays the text "ENCODE GRADES"
    public JLabel menuIcon = new JLabel();
    static JLabel sectionData,subjData, gradedData, numStudentData, statusData, editLbl; //display what section it is

    //JTextArea and JTextField Declaration------------------------------------------------------------------------------
    JTextArea stuNumTA = new JTextArea(); //displays "NUMBER OF STUDENTS"

    //ImageIcon declaration---------------------------------------------------------------------------------------------
    ImageIcon menuLogo = new ImageIcon("icons\\MenuIcon.png");

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    //Menu Frame Declaration
    public JFrame menuFrame = new JFrame();

    //Menu
    public RoundedPanel studentProfilePanel = new RoundedPanel();
    RoundedPanel encodeGradesPanel = new RoundedPanel();
    public RoundedPanel seeSchedulePanel = new RoundedPanel();
    public RoundedPanel logoutPanel = new RoundedPanel();

    //Labels
    JLabel menuLabel = new JLabel();
    JLabel ___menu = new JLabel();

    public static JLabel studentProfileLabel = new JLabel();
    static JLabel encodeGradesLabel = new JLabel();
    public static JLabel seeSchedLabel = new JLabel();
    public static JLabel logoutLabel = new JLabel();

    public static JLabel studentProfileLabel2 = new JLabel();
    static JLabel encodeGradesLabel2 = new JLabel();
    public static JLabel seeSchedLabel2 = new JLabel();

    List<JLabel> sectionDataArray = new ArrayList<>();
    List<JLabel> subjDataArray = new ArrayList<>();
    List<JLabel> gradedDataArray = new ArrayList<>();
    List<JLabel> numStudentDataArray = new ArrayList<>();
    List<JLabel> statusDataArray = new ArrayList<>();

    String subjectTable = null;

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
            g2d.setColor(Color.YELLOW);
            g2d.draw(shape);
            g2d.dispose();
        }
    }

    //constructor
    public EncodeGradesView(Instructor model) {
        this.model = model;
        EncodeGradesView();
    }

    public void EncodeGradesView() {
        encodeFrame.setSize(1000, 600);
        encodeFrame.setTitle("Instructor Encode Grades");
        encodeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        encodeFrame.setLayout(new BorderLayout());
        encodeFrame.setLocationRelativeTo(null);
        encodeFrame.setResizable(false);

        //---------------L A B E L S-------------------------------------------------------------------------------------------------------------
        encodeLbl1 = new JLabel("ENCODE GRADES");
        encodeLbl1.setForeground(Color.WHITE);
        encodeLbl1.setBounds(35,5,250,20);
        encodeLbl1.setFont(new Font("Segoe UI", Font.BOLD, 20));

        menuIcon.setIcon(menuLogo);
        menuIcon.setBounds(15, 0, 60, 60);

        sectionLbl = new JLabel("SECTION");
        sectionLbl.setForeground(Color.WHITE);
        sectionLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
        sectionLbl.setBounds(25, 10, 100, 40);

        subjLbl = new JLabel("SUBJECT");
        subjLbl.setForeground(Color.WHITE);
        subjLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
        subjLbl.setBounds(150, 10, 100, 40);

        gradedLbl = new JLabel("GRADED");
        gradedLbl.setForeground(Color.WHITE);
        gradedLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
        gradedLbl.setBounds(270, 10, 100, 40);

        statLbl = new JLabel("STATUS");
        statLbl.setForeground(Color.WHITE);
        statLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
        statLbl.setBounds(578, 10, 100, 40);

        actionLabel = new JLabel("ACTION");
        actionLabel.setForeground(Color.WHITE);
        actionLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        actionLabel.setBounds(775, 10, 100, 40);

        lineLbl = new JLabel("______________________________________________________________________________________________________________________________________");
        lineLbl.setForeground(Color.decode("#e1a938"));
        lineLbl.setBounds(20, 40, 900, 30);

        String[] sections = {"CS11S1", "CS11S2"};

        // Looping JScrollPane••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••
        scrollPanel = new JPanel();
        for (int i = 0; i < 2; i++) {
            scrollPanel.setBounds(0, 0, 800, 400);
            scrollPanel.setBackground(Color.decode("#3f3f3f"));
            scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
            scrollPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            ImageIcon container = new ImageIcon(getClass().getResource("icons\\WhitePanel.png"));
            scrollLabel = new JLabel(container);
            scrollLabel.setLayout(null);
            scrollPanel.add(scrollLabel);

            //Labels
            sectionData = new JLabel(sections[i]);
            sectionData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            sectionData.setBackground(Color.white);
            sectionData.setBorder(BorderFactory.createEmptyBorder());
            sectionData.setBounds(5, 15, 100, 20);
            scrollLabel.add(sectionData);
            sectionDataArray.add(sectionData);

            subjData = new JLabel();
            subjData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            subjData.setBackground(Color.white);
            subjData.setBorder(BorderFactory.createEmptyBorder());
            subjData.setBounds(135, 15, 100, 20);
            scrollLabel.add(subjData);
            subjDataArray.add(subjData);

            gradedData = new JLabel();
            gradedData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            gradedData.setBackground(Color.white);
            gradedData.setBorder(BorderFactory.createEmptyBorder());
            gradedData.setBounds(273, 15, 100, 20);
            scrollLabel.add(gradedData);
            gradedDataArray.add(gradedData);

            numStudentData = new JLabel();
            numStudentData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            numStudentData.setBackground(Color.white);
            numStudentData.setBorder(BorderFactory.createEmptyBorder());
            numStudentData.setBounds(412, 15, 100, 20);
            scrollLabel.add(numStudentData);
            numStudentDataArray.add(numStudentData);

            statusData = new JLabel();
            statusData.setBackground(Color.white);
            statusData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            statusData.setBorder(BorderFactory.createEmptyBorder());
            statusData.setForeground(Color.decode("#ad0a0a"));
            statusData.setBounds(535, 15, 150, 20);
            scrollLabel.add(statusData);
            statusDataArray.add(statusData);

            if(model.getCurrentlyLoggedIn().get("username").equals("gflores")){
                subjectTable = "cs002";
            }
            else if(model.getCurrentlyLoggedIn().get("username").equals("xaviersymth")){
                subjectTable = "cs001";
            }
            else if(model.getCurrentlyLoggedIn().get("username").equals("rygomz")){
                subjectTable = "pe001";
            }
            else if(model.getCurrentlyLoggedIn().get("username").equals("eva1226")){
                subjectTable = "math014";
            }
            else if(model.getCurrentlyLoggedIn().get("username").equals("tyler1")){
                subjectTable = "gec004";
            }

            encodeIcon = new RoundedPanel();
            encodeIcon.setBackground(Color.orange);
            encodeIcon.setLayout(null);
            encodeIcon.setBounds(740, 10, 100, 40);
            encodeLabel = new JLabel("ENCODE");
            encodeLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
            encodeLabel.setForeground(Color.WHITE);
            encodeLabel.setBounds(10, 3, 100, 20);
            encodeIcon.add(encodeLabel);
            encodeIcon.addMouseListener(new EncodeGradesController.encode(this, sections[i], subjectTable));
            scrollLabel.add(encodeIcon);

            //Encode Grades Background Panel
            encodeBackground = new RoundedPanel();
            encodeBackground.setBounds(45, 75, 910, 425);
            encodeBackground.setBackground(Color.decode("#3f3f3f"));
            encodeBackground.setLayout(null);

            //JScrollPane
            scrollPane = new JScrollPane(scrollPanel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(18);
            scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
            scrollPane.setBounds(20, 65, 865, 340);
            encodeBackground.add(scrollPane);
        }

        //---------------T E X T  F I E L D  /  T E X T  A R E A S--------------------------------------------------------------------------------

        stuNumTA = new JTextArea("NUMBER\n" + "OF STUDENTS");
        stuNumTA.setFont(new Font("Segoe UI", Font.BOLD, 16));
        stuNumTA.setBackground(Color.decode("#3f3f3f"));
        stuNumTA.setEditable(false);
        stuNumTA.setForeground(Color.WHITE);
        stuNumTA.setBorder(BorderFactory.createEmptyBorder());
        stuNumTA.setBounds(390, 10, 120, 50);

        //---------------P A N E L S-------------------------------------------------------------------------------------------------------------
        //background Panels
        background1 = new JPanel();
        background1.setBackground(Color.decode("#cfcfcf"));
        background1.setPreferredSize(new Dimension(100, 525));
        background1.setLayout(null);

        ImageIcon menu = new ImageIcon(getClass().getResource("icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15,10,50,50);
        background1.add(menuIcon);

        background2 = new JPanel();
        background2.setBackground(Color.decode("#d98659"));
        background2.setPreferredSize(new Dimension(50, 50));

        encodePanel = new RoundedPanel();
        encodePanel.setBounds(370, 10, 250, 45);
        encodePanel.setBackground(Color.decode("#d98659"));
        encodePanel.setLayout(null);

        //ADD
        encodeFrame.add(background1, BorderLayout.NORTH);
        encodeFrame.add(background2, BorderLayout.SOUTH);


        background1.add(encodeBackground);
        background1.add(encodePanel);
        background1.add(menuIcon);

        encodePanel.add(encodeLbl1);

        encodeBackground.add(sectionLbl);
        encodeBackground.add(subjLbl);
        encodeBackground.add(gradedLbl);
        encodeBackground.add(stuNumTA);
        encodeBackground.add(statLbl);
        encodeBackground.add(lineLbl);

        encodeBackground.add(actionLabel);

        encodeFrame.setVisible(true);

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
        encodeGradesPanel.setBounds(5,210,150,80);
        encodeGradesPanel.setBackground(Color.decode("#d98659"));
        encodeGradesPanel.setLayout(null);
        encodeGradesLabel = new JLabel("ENCODE");
        encodeGradesLabel.setBounds(33,10,100,20);
        encodeGradesLabel2 = new JLabel("GRADES");
        encodeGradesLabel2.setBounds(33,30,100,20);
        encodeGradesLabel.setForeground(Color.DARK_GRAY);
        encodeGradesLabel2.setForeground(Color.DARK_GRAY);
        encodeGradesLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        encodeGradesLabel2.setFont(new Font("Segoe UI", Font.BOLD,18));
        encodeGradesPanel.add(encodeGradesLabel);
        encodeGradesPanel.add(encodeGradesLabel2);

        //Logout Panel
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

        if(subjectTable.equals("cs002")){
            subjDataArray.get(0).setText("CS 002");
            subjDataArray.get(1).setText("CS 002");
        }
        else if(subjectTable.equals("cs001")){
            subjDataArray.get(0).setText("CS 001");
            subjDataArray.get(1).setText("CS 001");
        }
        else if(subjectTable.equals("pe001")){
            subjDataArray.get(0).setText("PE 001");
            subjDataArray.get(1).setText("PE 001");
        }
        else if(subjectTable.equals("math014")){
            subjDataArray.get(0).setText("MATH 014");
            subjDataArray.get(1).setText("MATH 014");
        }
        else if(subjectTable.equals("gec004")){
            subjDataArray.get(0).setText("GEC 004");
            subjDataArray.get(1).setText("GEC 004");
        }

        gradedDataArray.get(0).setText((String.valueOf(model.numOfGradedStudents("cs11s1_" + subjectTable))));
        gradedDataArray.get(1).setText((String.valueOf(model.numOfGradedStudents("cs11s2_" + subjectTable))));

        numStudentDataArray.get(0).setText((String.valueOf(model.numOfStudents("cs11s1_" + subjectTable))));
        numStudentDataArray.get(1).setText((String.valueOf(model.numOfStudents("cs11s2_" + subjectTable))));

        for (int i = 0; i < 2; i++) {
            if(gradedDataArray.get(i).getText().equals(numStudentDataArray.get(i).getText()) && !gradedDataArray.get(i).getText().equals("0")){
                statusDataArray.get(i).setText("COMPLETE");
            }else{
                statusDataArray.get(i).setText("INCOMPLETE");
            }
        }
    }
}