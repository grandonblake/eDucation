package controllers;

import models.*;
import views.StudentListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentListController {
    private Student studentModel;
    private Instructor instructorModel;
    private Enrollment enrollmentModel;
    private StudentListView view;
    String section;
    String subjectTable;

    public StudentListController(String section, String subjectTable){
        studentModel = new Student();
        instructorModel = new Instructor();
        enrollmentModel = new Enrollment();
        this.section = section;
        this.subjectTable = subjectTable;
        view = new StudentListView(studentModel, instructorModel, enrollmentModel, section, subjectTable);

        instructorModel.addObserver(view);
        instructorModel.changed();

        view.studentListFrame.addMouseListener(new MouseListener() {
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

        view.backPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new EncodeGradesController();
                view.studentListFrame.dispose();
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
                new InstructorMainController();
                view.studentListFrame.dispose();
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

        view.seeSchedulePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new InstructorSeeScheduleController();
                view.studentListFrame.dispose();
                view.menuFrame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                view.seeSchedLabel.setForeground(Color.DARK_GRAY);
                view.seeSchedLabel2.setForeground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                view.seeSchedLabel.setForeground(Color.WHITE);
                view.seeSchedLabel2.setForeground(Color.WHITE);
            }
        });

        view.encodeGradesPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new EncodeGradesController();
                view.studentListFrame.dispose();
                view.menuFrame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                view.encodeGradesLabel.setForeground(Color.DARK_GRAY);
                view.encodeGradesLabel2.setForeground(Color.DARK_GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                view.encodeGradesLabel.setForeground(Color.WHITE);
                view.encodeGradesLabel2.setForeground(Color.WHITE);
            }
        });

        view.logoutPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SignInController();
                view.studentListFrame.dispose();
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

    public static class encodeButton implements MouseListener {
        StudentListView view;
        String section;
        String studentData;
        String subjectTable;
        public encodeButton(StudentListView view, String section, String studentData, String subjectTable){
            this.view = view;
            this.section = section;
            this.studentData = studentData;
            this.subjectTable = subjectTable;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            new updateGradesController(section, studentData, subjectTable);
            view.studentListFrame.dispose();
            view.menuFrame.dispose();
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }
}



