package controllers;

import models.Student;
import views.*;

import java.awt.*;
import java.awt.event.*;

public class StudentCalendarController {
    private StudentCalendarView view;
    private Student studentModel;

    public StudentCalendarController(){
        studentModel = new Student();
        view = new StudentCalendarView(studentModel);

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
}



