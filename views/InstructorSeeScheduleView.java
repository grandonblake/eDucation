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

public class InstructorSeeScheduleView implements Observer {
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

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    //Menu Frame Declaration
    public JFrame schedFrame = new JFrame();
    public JFrame menuFrame = new JFrame();

    public RoundedPanel studentProfilePanel, encodeGradesPanel, seeSchedulePanel, logoutPanel;
    public JLabel studentProfileLabel, encodeGradesLabel, seeSchedLabel, logoutLabel, studentProfileLabel2, encodeGradesLabel2, seeSchedLabel2, menuLabel, ___menu;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    JPanel background1, background2, scrollPanel;
    RoundedPanel schedBackground, schedIcon, schedData;
    JScrollPane ScrollPane = new JScrollPane();
    public JLabel schedLabel, menuIcon, sectionLabel, subjLabel, dayLabel, timeLabel, lineLbl, sectionData, subjData, dayData, timeData, studentNumData, scrollLabel, arrowIcon;
    JTextArea studentNumTA;

    private Instructor model;

    List<JLabel> sectionDataArray = new ArrayList<>();
    List<JLabel> subjDataArray = new ArrayList<>();
    List<JLabel> dayDataArray = new ArrayList<>();
    List<JLabel> timeDataArray = new ArrayList<>();
    List<JLabel> studentNumDataArray = new ArrayList<>();

    public InstructorSeeScheduleView(Instructor model) {
        this.model = model;
        InstructorSeeScheduleView();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    public void InstructorSeeScheduleView() {
        schedFrame.setSize(1000, 600);
        schedFrame.setTitle("Instructor See Schedule");
        schedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        schedFrame.setLayout(new BorderLayout());
        schedFrame.setLocationRelativeTo(null);
        schedFrame.setResizable(false);

        //Menu Icon
        ImageIcon menu = new ImageIcon(getClass().getResource("icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15,10,50,50);

        //-------L A B E L S-----------------------------------------------------------------------------------------------------------------------------
        schedLabel = new JLabel();
        schedLabel.setText("SCHEDULE");
        schedLabel.setForeground(Color.WHITE);
        schedLabel.setBounds(20,5,150,25);
        schedLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));

        sectionLabel = new JLabel();
        sectionLabel.setText("SECTION");
        sectionLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        sectionLabel.setForeground(Color.WHITE);
        sectionLabel.setBounds(25, 10, 120, 60);

        subjLabel = new JLabel();
        subjLabel.setText("SUBJECT");
        subjLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        subjLabel.setForeground(Color.WHITE);
        subjLabel.setBounds(160, 10, 120, 60);

        dayLabel = new JLabel();
        dayLabel.setText("DAY");
        dayLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        dayLabel.setForeground(Color.WHITE);
        dayLabel.setBounds(315, 10, 120, 60);

        timeLabel = new JLabel();
        timeLabel.setText("TIME");
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBounds(475, 10, 120, 60);

        lineLbl = new JLabel();
        lineLbl.setText("___________________________________________________________________________________________________________________________________");
        lineLbl.setForeground(Color.decode("#e1a938"));
        lineLbl.setBounds(25, 50, 870, 30);

        scrollPanel = new JPanel();
        // Looping JScrollPane
        // Looping JScrollPane
        for(int x=0; x < 2; x++) {

            scrollPanel.setBounds(0, 0, 800, 400);
            scrollPanel.setBackground(Color.decode("#3f3f3f"));
            scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
            scrollPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            ImageIcon container = new ImageIcon(getClass().getResource("icons\\WhitePanel.png"));
            scrollLabel = new JLabel(container);
            scrollLabel.setLayout(null);
            schedFrame.add(scrollPanel);

            //Labels-------------------------------------------------------------------------------------------------
            sectionData = new JLabel("N/A");
            sectionData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            sectionData.setBounds(25, 15, 100, 20);
            sectionDataArray.add(sectionData);

            subjData = new JLabel("N/A");
            subjData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            subjData.setBounds(160, 15, 250, 20);
            subjDataArray.add(subjData);

            dayData = new JLabel("N/A");
            dayData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            dayData.setBounds(290, 15, 160, 20);
            dayDataArray.add(dayData);

            timeData = new JLabel("N/A");
            timeData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            timeData.setBounds(410, 15, 250, 20);
            timeDataArray.add(timeData);

            studentNumData = new JLabel("N/A");
            studentNumData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            studentNumData.setBounds(700, 15, 160, 20);
            studentNumDataArray.add(studentNumData);

            arrowIcon = new JLabel("►");
            arrowIcon.setForeground(Color.GREEN);
            arrowIcon.setFont(new Font("Segoe UI", Font.BOLD, 24));
            arrowIcon.setBounds(800, 15, 160, 20);
            arrowIcon.addMouseListener(new InstructorSeeScheduleController.arrowIcon(schedFrame, menuFrame, sectionData, subjData));

            //add
            scrollLabel.add(sectionData);
            scrollLabel.add(subjData);
            scrollLabel.add(dayData);
            scrollLabel.add(timeData);
            scrollLabel.add(studentNumData);
            scrollLabel.add(arrowIcon);
            scrollPanel.add(scrollLabel);

            //JScrollPane
            ScrollPane = new JScrollPane(scrollPanel);
            ScrollPane.getVerticalScrollBar().setUnitIncrement(18);
            ScrollPane.setBackground(Color.decode("#3f3f3f"));
            ScrollPane.setHorizontalScrollBarPolicy(ScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            ScrollPane.setBorder(null);
            ScrollPane.setBounds(55, 150, 870, 250);

        }

        //--------T E X T  F I E L D S  /  T E X T  A R E A S---------------------------------------------------------------------------------------------

        studentNumTA = new JTextArea();
        studentNumTA.setText("    NUMBER\n" + "OF STUDENTS");
        studentNumTA.setFont(new Font("Segoe UI", Font.BOLD, 20));
        studentNumTA.setBackground(Color.decode("#3f3f3f"));
        studentNumTA.setEditable(false);
        studentNumTA.setForeground(Color.WHITE);
        studentNumTA.setBorder(BorderFactory.createEmptyBorder());
        studentNumTA.setBounds(650, 15, 160, 55);

        //-------P A N E L S -----------------------------------------------------------------------------------------------------------------------------------

        //background Panels
        background1 = new JPanel();
        background1.setBackground(Color.decode("#cfcfcf"));
        background1.setPreferredSize(new Dimension(100, 525));
        background1.setLayout(null);

        background2 = new JPanel();
        background2.setBackground(Color.decode("#d98659"));
        background2.setPreferredSize(new Dimension(50, 50));

        //schedPanel
        schedIcon = new RoundedPanel();
        schedIcon.setBounds(405, 15, 180, 45);
        schedIcon.setLayout(null);
        schedIcon.setBackground(Color.decode("#d98659"));

        //Schedule Table
        schedBackground = new RoundedPanel();
        schedBackground.setBounds(45, 75, 900, 350);
        schedBackground.setBackground(Color.decode("#3f3f3f"));
        schedBackground.setLayout(null);

        schedData = new RoundedPanel();
        schedData.setBounds(25, 80, 845, 50);
        schedData.setLayout(null);

        //add
        schedFrame.add(background1, BorderLayout.NORTH);
        schedFrame.add(background2, BorderLayout.SOUTH);

        background1.add(ScrollPane);
        background1.add(schedBackground);
        background1.add(schedIcon);
        background1.add(menuIcon);

        schedBackground.add(sectionLabel);
        schedBackground.add(subjLabel);
        schedBackground.add(dayLabel);
        schedBackground.add(timeLabel);
        schedBackground.add(studentNumTA);
        schedBackground.add(lineLbl);
        schedIcon.add(schedLabel);

        schedFrame.setVisible(true); //to show the frame

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
        seeSchedLabel.setForeground(Color.DARK_GRAY);
        seeSchedLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        seeSchedLabel.setBounds(51,10,50,20);
        seeSchedulePanel.add(seeSchedLabel);
        seeSchedLabel2 = new JLabel("SCHEDULE");
        seeSchedLabel2.setForeground(Color.DARK_GRAY);
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
        if(model.getCurrentlyLoggedIn().get("username").equals("gflores")){
            sectionDataArray.get(0).setText("CS11S1");
            subjDataArray.get(0).setText("CS 002");
            dayDataArray.get(0).setText("Monday");
            timeDataArray.get(0).setText("8:00 AM - 10:30 AM");
            studentNumDataArray.get(0).setText("");

            sectionDataArray.get(1).setText("CS11S2");
            subjDataArray.get(1).setText("CS 002");
            dayDataArray.get(1).setText("Tuesday");
            timeDataArray.get(1).setText("10:30 AM - 1:00 PM");
            studentNumDataArray.get(1).setText("");
        }
        else if(model.getCurrentlyLoggedIn().get("username").equals("xaviersymth")){
            sectionDataArray.get(0).setText("CS11S1");
            subjDataArray.get(0).setText("CS 001");
            dayDataArray.get(0).setText("Tuesday");
            timeDataArray.get(0).setText("8:00 AM - 10:30 AM");
            studentNumDataArray.get(0).setText("");

            sectionDataArray.get(1).setText("CS11S2");
            subjDataArray.get(1).setText("CS 001");
            dayDataArray.get(1).setText("Wednesday");
            timeDataArray.get(1).setText("10:30 AM - 1:00 PM");
            studentNumDataArray.get(1).setText("");

        }
        else if(model.getCurrentlyLoggedIn().get("username").equals("rygomz")){
            sectionDataArray.get(0).setText("CS11S1");
            subjDataArray.get(0).setText("PE 001");
            dayDataArray.get(0).setText("Wednesday");
            timeDataArray.get(0).setText("8:00 AM - 10:30 AM");
            studentNumDataArray.get(0).setText("");

            sectionDataArray.get(1).setText("CS11S2");
            subjDataArray.get(1).setText("PE 001");
            dayDataArray.get(1).setText("Thursday");
            timeDataArray.get(1).setText("10:30 AM - 1:00 PM");
            studentNumDataArray.get(1).setText("");

        }
        else if(model.getCurrentlyLoggedIn().get("username").equals("eva1226")){
            sectionDataArray.get(0).setText("CS11S1");
            subjDataArray.get(0).setText("MATH 014");
            dayDataArray.get(0).setText("Thursday");
            timeDataArray.get(0).setText("8:00 AM - 10:30 AM");
            studentNumDataArray.get(0).setText("");

            sectionDataArray.get(1).setText("CS11S2");
            subjDataArray.get(1).setText("MATH 014");
            dayDataArray.get(1).setText("Friday");
            timeDataArray.get(1).setText("10:30 AM - 1:00 PM");
            studentNumDataArray.get(1).setText("");
        }
        else if(model.getCurrentlyLoggedIn().get("username").equals("tyler1")){
            sectionDataArray.get(0).setText("CS11S1");
            subjDataArray.get(0).setText("GEC 004");
            dayDataArray.get(0).setText("Friday");
            timeDataArray.get(0).setText("8:00 AM - 10:30 AM");
            studentNumDataArray.get(0).setText("");

            sectionDataArray.get(1).setText("CS11S2");
            subjDataArray.get(1).setText("GEC 0041");
            dayDataArray.get(1).setText("Saturday");
            timeDataArray.get(1).setText("10:30 AM - 1:00 PM");
            studentNumDataArray.get(1).setText("");
        }

        String subjectTable = null;

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

        studentNumDataArray.get(0).setText((String.valueOf(model.numOfStudents("cs11s1_" + subjectTable))));
        studentNumDataArray.get(1).setText((String.valueOf(model.numOfStudents("cs11s2_" + subjectTable))));

    }

}

