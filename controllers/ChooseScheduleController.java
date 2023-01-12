package controllers;

import models.Enrollment;
import models.Student;
import views.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChooseScheduleController {
    private ChooseScheduleView view;
    private JLabel SetSubjectsLabel;
    private Student studentModel;
    private Enrollment enrollmentModel;

    public ChooseScheduleController(JLabel SetSubjectsLabel){

        enrollmentModel = new Enrollment();
        studentModel = new Student();
        this.SetSubjectsLabel = SetSubjectsLabel;
        view = new ChooseScheduleView(SetSubjectsLabel, studentModel, enrollmentModel);

        studentModel.addObserver(view);
        studentModel.changed();

        view.menuIcon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.menuFrame.setVisible(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        view.MainFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.menuFrame.setVisible(false);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        view.studentProfilePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new StudentMainController();
                view.MainFrame.dispose();
                view.menuFrame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                view.studentProfileLabel.setForeground(Color.DARK_GRAY);
                view.studentProfileLabel2.setForeground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                view.studentProfileLabel.setForeground(Color.WHITE);
                view.studentProfileLabel2.setForeground(Color.WHITE);
            }
        });

        view.setSchedulePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SetScheduleController();
                view.MainFrame.dispose();
                view.menuFrame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                view.setSchedLabel.setForeground(Color.DARK_GRAY);
                view.setSchedLabel2.setForeground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                view.setSchedLabel.setForeground(Color.WHITE);
                view.setSchedLabel2.setForeground(Color.WHITE);
            }
        });

        view.studentCalendarPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new StudentCalendarController();
                view.MainFrame.dispose();
                view.menuFrame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                view.studentCalLabel.setForeground(Color.DARK_GRAY);
                view.studentCalLabel2.setForeground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                view.studentCalLabel.setForeground(Color.WHITE);
                view.studentCalLabel2.setForeground(Color.WHITE);
            }
        });

        view.seeGradePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new seeGradesController();
                view.MainFrame.dispose();
                view.menuFrame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                view.seeGradesLabel.setForeground(Color.DARK_GRAY);
                view.seeGradesLabel2.setForeground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                view.seeGradesLabel.setForeground(Color.WHITE);
                view.seeGradesLabel2.setForeground(Color.WHITE);
            }
        });

        view.logoutPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SignInController();
                view.MainFrame.dispose();
                view.menuFrame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                view.logoutLabel.setForeground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                view.logoutLabel.setForeground(Color.WHITE);
            }
        });
    }

    public static class backPanel implements MouseListener {
        ChooseScheduleView view;

        public backPanel(ChooseScheduleView view){
            this.view = view;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            view.MainFrame.dispose();

            new SetScheduleController();
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public static class selectPanel implements MouseListener {
        ChooseScheduleView view;
        JLabel SetSectionLabel;
        JLabel SetSubjectsLabel;

        Student studentModel;
        Enrollment enrollmentModel;

        public selectPanel(ChooseScheduleView view, JLabel SetSectionLabel, JLabel SetSubjectsLabel, Student studentModel, Enrollment enrollmentModel){

            this.view = view;
            this.SetSectionLabel = SetSectionLabel;
            this.SetSubjectsLabel = SetSubjectsLabel;
            this.studentModel = studentModel;
            this.enrollmentModel = enrollmentModel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            //update database

            //CS 002
            if(SetSubjectsLabel.getText().equals("CS 002")){
                if(SetSectionLabel.getText().equals("CS11S1")){
                    studentModel.getCurrentlyLoggedIn().set("cs002_section", "CS11S1");
                    new SetScheduleController();
                    view.MainFrame.dispose();
                    //add to table
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.getEnrollmentArray().add(enroll);
                    enrollmentModel.enroll(enroll, "cs11s1_cs002");
                }
                if(SetSectionLabel.getText().equals("CS11S2")){
                    studentModel.getCurrentlyLoggedIn().set("cs002_section", "CS11S2");
                    new SetScheduleController();
                    view.MainFrame.dispose();
                    //add to table
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.getEnrollmentArray().add(enroll);
                    enrollmentModel.enroll(enroll, "cs11s2_cs002");
                }
            }

            //GEC 004
            if(SetSubjectsLabel.getText().equals("GEC 004")){
                if(SetSectionLabel.getText().equals("CS11S1")){
                    studentModel.getCurrentlyLoggedIn().set("gec004_section", "CS11S1");
                    new SetScheduleController();
                    view.MainFrame.dispose();
                    //add to table
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.getEnrollmentArray().add(enroll);
                    enrollmentModel.enroll(enroll, "cs11s1_gec004");
                }
                if(SetSectionLabel.getText().equals("CS11S2")){
                    studentModel.getCurrentlyLoggedIn().set("gec004_section", "CS11S2");
                    new SetScheduleController();
                    view.MainFrame.dispose();
                    //add to table
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.getEnrollmentArray().add(enroll);
                    enrollmentModel.enroll(enroll, "cs11s2_gec004");
                }
            }

            //PE 001
            if(SetSubjectsLabel.getText().equals("PE 001")){
                if(SetSectionLabel.getText().equals("CS11S1")){
                    studentModel.getCurrentlyLoggedIn().set("pe001_section", "CS11S1");
                    new SetScheduleController();
                    view.MainFrame.dispose();
                    //add to table
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.getEnrollmentArray().add(enroll);
                    enrollmentModel.enroll(enroll, "cs11s1_pe001");
                }
                if(SetSectionLabel.getText().equals("CS11S2")){
                    studentModel.getCurrentlyLoggedIn().set("pe001_section", "CS11S2");
                    new SetScheduleController();
                    view.MainFrame.dispose();
                    //add to table
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.getEnrollmentArray().add(enroll);
                    enrollmentModel.enroll(enroll, "cs11s2_pe001");
                }
            }

            //MATH 014
            if(SetSubjectsLabel.getText().equals("MATH 014")){
                if(SetSectionLabel.getText().equals("CS11S1")){
                    studentModel.getCurrentlyLoggedIn().set("math014_section", "CS11S1");
                    new SetScheduleController();
                    view.MainFrame.dispose();
                    //add to table
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.getEnrollmentArray().add(enroll);
                    enrollmentModel.enroll(enroll, "cs11s1_math014");
                }
                if(SetSectionLabel.getText().equals("CS11S2")){
                    studentModel.getCurrentlyLoggedIn().set("math014_section", "CS11S2");
                    new SetScheduleController();
                    view.MainFrame.dispose();
                    //add to table
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.getEnrollmentArray().add(enroll);
                    enrollmentModel.enroll(enroll, "cs11s2_math014");
                }
            }

            //CS 001
            if(SetSubjectsLabel.getText().equals("CS 001")){
                if(SetSectionLabel.getText().equals("CS11S1")){
                    studentModel.getCurrentlyLoggedIn().set("cs001_section", "CS11S1");
                    new SetScheduleController();
                    view.MainFrame.dispose();
                    //add to table
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.getEnrollmentArray().add(enroll);
                    enrollmentModel.enroll(enroll, "cs11s1_cs001");
                }
                if(SetSectionLabel.getText().equals("CS11S2")){
                    studentModel.getCurrentlyLoggedIn().set("cs001_section", "CS11S2");
                    new SetScheduleController();
                    view.MainFrame.dispose();
                    //add to table
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.getEnrollmentArray().add(enroll);
                    enrollmentModel.enroll(enroll, "cs11s2_cs001");
                }
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}


