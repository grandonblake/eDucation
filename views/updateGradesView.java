package views;


import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import models.*;

import javax.swing.*;

public class updateGradesView implements Observer {
    public JFrame updateGradesFrame = new JFrame();
    //JPanel declaration------------------------------------------------------------------------------------------------
    JPanel background1 ,background2, scrollPanel;
    public RoundedPanel updateButton ,backButton,saveButton, namePanel,dataPanel,stuListBackground;
    //JScroll Pane------------------------------------------------------------------------------------------------------
    JScrollPane scrollPane = new JScrollPane();
    //JLabel declaration------------------------------------------------------------------------------------------------
    public JLabel studentName, menuIcon, descriptionLabel, scoreLabel, lineLbl, scrollLabel, itemLabel, percentLabel, updateButtonLabel, backButtonLabel, saveButtonLabel;
    //JTextField
    public JTextField descriptionData, scoreData, itemData, percentData;

    //◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘
    //Menu Frame Declaration
    public JFrame menuFrame = new JFrame();
    //Menu
    public RoundedPanel studentProfilePanel, encodeGradesPanel, seeSchedulePanel, logoutPanel;
    //Labels
    public JLabel menuLabel, ___menu, studentProfileLabel, encodeGradesLabel, seeSchedLabel, logoutLabel, studentProfileLabel2, encodeGradesLabel2, seeSchedLabel2;

    public List<JTextField> percentDataArray = new ArrayList<>();
    public List<JTextField> itemDataArray = new ArrayList<>();
    public List<JTextField> scoreDataArray = new ArrayList<>();
    public List<JTextField> descriptionDataArray = new ArrayList<>();

    String studentDataString;
    Student studentModel;
    Instructor instructorModel;
    Enrollment enrollmentModel;
    String studentName2;

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
    public updateGradesView(Student studentModel, Instructor instructorModel, Enrollment enrollmentModel, String studentDataString, String studentName2) {
        this.studentModel = studentModel;
        this.instructorModel = instructorModel;
        this.enrollmentModel = enrollmentModel;
        this.studentDataString = studentDataString;
        this.studentName2 = studentName2;
        updateGradesView();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    public void updateGradesView() {
        updateGradesFrame.setSize(1000, 600);
        updateGradesFrame.setTitle("Instructor Update Grades");
        updateGradesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateGradesFrame.setLayout(null);
        updateGradesFrame.setLocationRelativeTo(null);
        updateGradesFrame.setResizable(false);

        //-------------------L A B E L S---------------------------------------------------------------------------------------------------------------------
        studentName = new JLabel();
        studentName.setBounds(55,5,400,20);
        studentName.setFont(new Font("Segoe UI", Font.BOLD, 20));
        studentName.setForeground(Color.WHITE);

        //Menu Icon
        ImageIcon menu = new ImageIcon(getClass().getResource("icons\\MenuIcon.png"));
        menuIcon = new JLabel(menu);
        menuIcon.setBounds(15,10,50,50);
        updateGradesFrame.add(menuIcon);

        descriptionLabel = new JLabel("DESCRIPTION");
        descriptionLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setBounds(20, 10, 150, 30);

        scoreLabel = new JLabel("SCORE");
        scoreLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(230, 10, 150, 30);

        itemLabel = new JLabel("ITEMS");
        itemLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        itemLabel.setForeground(Color.WHITE);
        itemLabel.setBounds(430, 10, 150, 30);

        percentLabel = new JLabel("PERCENTAGE");
        percentLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        percentLabel.setForeground(Color.WHITE);
        percentLabel.setBounds(630, 10, 150, 30);

        updateButton = new RoundedPanel();
        updateButton.setBackground(Color.white);
        updateButton.setLayout(null);
        updateButton.setBounds(780,7,100,40);
        updateButtonLabel = new JLabel("UPDATE");
        updateButtonLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        updateButtonLabel.setForeground(Color.black);
        updateButtonLabel.setBounds(8,0,150,25);
        updateButton.add(updateButtonLabel);

        saveButton = new RoundedPanel();
        saveButton.setBackground(Color.white);
        saveButton.setLayout(null);
        saveButton.setVisible(true);
        saveButton.setBounds(780,7,100,40);
        saveButtonLabel = new JLabel("SAVE");
        saveButtonLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        saveButtonLabel.setForeground(Color.black);
        saveButtonLabel.setBounds(23,0,150,25);
        saveButton.add(saveButtonLabel);

        backButton = new RoundedPanel();
        backButton.setBackground(Color.decode("#d98659"));
        backButton.setLayout(null);
        backButton.setBounds(75,20,100,40);
        backButtonLabel = new JLabel("BACK");
        backButtonLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        backButtonLabel.setForeground(Color.white);
        backButtonLabel.setBounds(18,0,80,25);
        backButton.add(backButtonLabel);

        lineLbl = new JLabel("_______________________________________________________________________________________________________________________________________");
        lineLbl.setForeground(Color.decode("#e1a938"));
        lineLbl.setBounds(20, 20, 850, 30);

        // Looping JScrollPane
        scrollPanel = new JPanel();

        String[] descriptions = {"Assignment 1", "Assignment 2", "Assignment 3", "Quiz 1", "Quiz 2", "Quiz 3", "Prelim Exam", "Periodical Exam"};

        for (int i = 0; i < 8; i++) {
            scrollPanel.setBounds(0, 0, 800, 400);
            scrollPanel.setBackground(Color.decode("#3f3f3f"));
            scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
            scrollPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            ImageIcon container = new ImageIcon(getClass().getResource("icons\\WhitePanel.png"));
            scrollLabel = new JLabel(container);
            scrollLabel.setLayout(null);
            scrollPanel.add(scrollLabel);

            //Labels-------------------------------------------------------------------------------------------------
            descriptionData = new JTextField(descriptions[i]);
            descriptionData.setBorder(null);
            descriptionData.setBackground(Color.white);
            descriptionData.setEditable(false);
            descriptionData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            descriptionData.setBounds(5, 10, 215, 25);
            scrollLabel.add(descriptionData);
            descriptionDataArray.add(descriptionData);

            scoreData = new JTextField();
            scoreData.setBorder(null);
            scoreData.setBackground(Color.white);
            scoreData.setEditable(false);
            scoreData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            scoreData.setForeground(Color.black);
            scoreData.setBounds(220, 10, 200, 25);
            scrollLabel.add(scoreData);
            scoreDataArray.add(scoreData);

            itemData = new JTextField();
            itemData.setBorder(null);
            itemData.setBackground(Color.white);
            itemData.setEditable(false);
            itemData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            itemData.setForeground(Color.black);
            itemData.setBounds(420, 10, 200, 25);
            scrollLabel.add(itemData);
            itemDataArray.add(itemData);

            percentData = new JTextField();
            percentData.setBorder(null);
            percentData.setBackground(Color.white);
            percentData.setEditable(false);
            percentData.setFont(new Font("Segoe UI", Font.BOLD, 18));
            percentData.setForeground(Color.black);
            percentData.setBounds(620, 10, 200, 25);
            scrollLabel.add(percentData);
            percentDataArray.add(percentData);

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
        background1.setBounds(0,0,985,535);
        background1.setBackground(Color.decode("#cfcfcf"));
        background1.setLayout(null);

        background2 = new JPanel();
        background2.setBounds(0,535,985,50);
        background2.setBackground(Color.decode("#d98659"));
        background2.setPreferredSize(new Dimension(50, 50));

        //Student List Background Panel
        stuListBackground = new RoundedPanel();
        stuListBackground.setBounds(45, 75, 910, 425);
        stuListBackground.setBackground(Color.decode("#3f3f3f"));
        stuListBackground.setLayout(null);

        namePanel = new RoundedPanel();
        namePanel.setBackground(Color.decode("#3f3f3f"));
        namePanel.setLayout(new GridBagLayout());
        namePanel.setBounds(555, 20, 400, 45);

        dataPanel = new RoundedPanel();
        dataPanel.setBounds(20, 50, 846, 50);
        dataPanel.setLayout(null);

        //add
        updateGradesFrame.add(scrollPane);
        updateGradesFrame.add(background1);
        updateGradesFrame.add(background2);

        background1.add(stuListBackground);
        background1.add(namePanel);

        background1.add(menuIcon);
        background1.add(backButton);

        stuListBackground.add(descriptionLabel);
        stuListBackground.add(scoreLabel);
        stuListBackground.add(lineLbl);
        stuListBackground.add(itemLabel);
        stuListBackground.add(percentLabel);
        stuListBackground.add(updateButton);
        stuListBackground.add(saveButton);

        namePanel.add(studentName);

        updateGradesFrame.setVisible(true);
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

        studentName.setText(studentName2);

        for (int i = 0; i < enrollmentModel.getEnrollmentArray().size(); i++) {
            if(studentDataString.equals(enrollmentModel.getEnrollmentArray().get(i).get("student_username")) && studentDataString != null) {
                scoreDataArray.get(0).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_score")));
                scoreDataArray.get(1).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_score")));
                scoreDataArray.get(2).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_score")));
                scoreDataArray.get(3).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_score")));
                scoreDataArray.get(4).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_score")));
                scoreDataArray.get(5).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_score")));
                scoreDataArray.get(6).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_score")));
                scoreDataArray.get(7).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_score")));

                itemDataArray.get(0).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_1_items")));
                itemDataArray.get(1).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_2_items")));
                itemDataArray.get(2).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("assignment_3_items")));
                itemDataArray.get(3).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_1_items")));
                itemDataArray.get(4).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_2_items")));
                itemDataArray.get(5).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("quiz_3_items")));
                itemDataArray.get(6).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("prelim_exam_items")));
                itemDataArray.get(7).setText(String.valueOf(enrollmentModel.getEnrollmentArray().get(i).getInt("periodical_exam_items")));
            }
        }

        percentDataArray.get(0).setText(String.format("%.2f", (Float.parseFloat(scoreDataArray.get(0).getText()) / Float.parseFloat(itemDataArray.get(0).getText()) * 100)) + "%");
        percentDataArray.get(1).setText(String.format("%.2f", (Float.parseFloat(scoreDataArray.get(1).getText()) / Float.parseFloat(itemDataArray.get(1).getText()) * 100)) + "%");
        percentDataArray.get(2).setText(String.format("%.2f", (Float.parseFloat(scoreDataArray.get(2).getText()) / Float.parseFloat(itemDataArray.get(2).getText()) * 100)) + "%");
        percentDataArray.get(3).setText(String.format("%.2f", (Float.parseFloat(scoreDataArray.get(3).getText()) / Float.parseFloat(itemDataArray.get(3).getText()) * 100)) + "%");
        percentDataArray.get(4).setText(String.format("%.2f", (Float.parseFloat(scoreDataArray.get(4).getText()) / Float.parseFloat(itemDataArray.get(4).getText()) * 100)) + "%");
        percentDataArray.get(5).setText(String.format("%.2f", (Float.parseFloat(scoreDataArray.get(5).getText()) / Float.parseFloat(itemDataArray.get(5).getText()) * 100)) + "%");
        percentDataArray.get(6).setText(String.format("%.2f", (Float.parseFloat(scoreDataArray.get(6).getText()) / Float.parseFloat(itemDataArray.get(6).getText()) * 100)) + "%");
        percentDataArray.get(7).setText(String.format("%.2f", (Float.parseFloat(scoreDataArray.get(7).getText()) / Float.parseFloat(itemDataArray.get(7).getText()) * 100)) + "%");
    }
}

