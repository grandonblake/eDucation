package controllers;

import models.*;
import views.seeGradesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class seeGradesController {
    private Student studentModel;
    private Enrollment enrollmentModel;
    private seeGradesView view;

    public seeGradesController(){
        studentModel = new Student();
        enrollmentModel = new Enrollment();
        view = new seeGradesView(studentModel, enrollmentModel);

        studentModel.addObserver(view);
        studentModel.changed();

        view.MainFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
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