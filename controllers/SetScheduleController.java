package controllers;

import models.*;
import views.SetScheduleView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

public class SetScheduleController {

    private SetScheduleView view;
    private Student studentModel;
    private Enrollment enrollmentModel;

    public SetScheduleController(){

        studentModel = new Student();
        enrollmentModel = new Enrollment();
        view = new SetScheduleView(studentModel, enrollmentModel);

        studentModel.addObserver(view);
        studentModel.changed();

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

        view.seeGradesLabel.addMouseListener(new MouseListener() {
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

    public static class removePanel implements MouseListener {
        SetScheduleView view;
        Student studentModel;
        Enrollment enrollmentModel;

        JLabel SetSubjectsLabel;

        public removePanel(SetScheduleView view, Student studentModel, JLabel SetSubjectsLabel, Enrollment enrollmentModel){

            this.view = view;
            this.studentModel = studentModel;
            this.SetSubjectsLabel = SetSubjectsLabel;
            this.enrollmentModel = enrollmentModel;

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            //CS 002
            if(SetSubjectsLabel.getText().equals("CS 002")) {

                if(studentModel.getCurrentlyLoggedIn().get("cs002_section").equals("CS11S1")) {
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.remove(enroll, "cs11s1_cs002");
                }
                else if(studentModel.getCurrentlyLoggedIn().get("cs002_section").equals("CS11S2")){
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.remove(enroll, "cs11s2_cs002");
                }

                studentModel.getCurrentlyLoggedIn().set("cs002_section", "null");
                studentModel.changed();

            }

            //GEC 004
            if(SetSubjectsLabel.getText().equals("GEC 004")) {

                if(studentModel.getCurrentlyLoggedIn().get("gec004_section").equals("CS11S1")) {
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.remove(enroll, "cs11s1_gec004");
                }
                else if(studentModel.getCurrentlyLoggedIn().get("gec004_section").equals("CS11S2")){
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.remove(enroll, "cs11s2_gec004");
                }

                studentModel.getCurrentlyLoggedIn().set("gec004_section", "null");
                studentModel.changed();
            }

            //PE 001
            if(SetSubjectsLabel.getText().equals("PE 001")) {

                if(studentModel.getCurrentlyLoggedIn().get("pe001_section").equals("CS11S1")) {
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.remove(enroll, "cs11s1_pe001");
                }
                else if(studentModel.getCurrentlyLoggedIn().get("pe001_section").equals("CS11S2")){
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.remove(enroll, "cs11s2_pe001");
                }

                studentModel.getCurrentlyLoggedIn().set("pe001_section", "null");
                studentModel.changed();
            }

            //MATH 014
            if(SetSubjectsLabel.getText().equals("MATH 014")) {

                if(studentModel.getCurrentlyLoggedIn().get("math014_section").equals("CS11S1")) {
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.remove(enroll, "cs11s1_math014");
                }
                else if(studentModel.getCurrentlyLoggedIn().get("math014_section").equals("CS11S2")){
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.remove(enroll, "cs11s2_math014");
                }
                studentModel.getCurrentlyLoggedIn().set("math014_section", "null");
                studentModel.changed();
            }

            //CS 001
            if(SetSubjectsLabel.getText().equals("CS 001")) {

                if(studentModel.getCurrentlyLoggedIn().get("cs001_section").equals("CS11S1")) {
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.remove(enroll, "cs11s1_cs001");
                }
                else if(studentModel.getCurrentlyLoggedIn().get("cs001_section").equals("CS11S2")){
                    Enrollment enroll = new Enrollment(studentModel.getCurrentlyLoggedIn().get("username"));
                    enrollmentModel.remove(enroll, "cs11s2_cs001");
                }

                studentModel.getCurrentlyLoggedIn().set("cs001_section", "null");
                studentModel.changed();
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

    public static class setPanel implements MouseListener {
        SetScheduleView view;
        JLabel SetSubjectsLabel;

        public setPanel(SetScheduleView view, JLabel SetSubjectsLabel){
            this.view = view;
            this.SetSubjectsLabel = SetSubjectsLabel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            new ChooseScheduleController(SetSubjectsLabel);
            view.MainFrame.dispose();
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



