package controllers;

import models.*;
import views.*;
import java.awt.*;
import java.awt.event.*;

public class EncodeGradesController {
    private Instructor model;
    private EncodeGradesView view;

    public EncodeGradesController(){
        model = new Instructor();
        view = new EncodeGradesView(model);

        model.addObserver(view);
        model.changed();

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
                new InstructorMainController();
                view.encodeFrame.dispose();
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
                view.encodeFrame.dispose();
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

        view.logoutPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SignInController();
                view.encodeFrame.dispose();
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

        view.encodeFrame.addMouseListener(new MouseListener() {
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
    }

    public static class encode implements MouseListener {
        EncodeGradesView view;
        String section;
        String subjectTable;
        public encode(EncodeGradesView view, String section, String subjectTable){
            this.view = view;
            this.section = section;
            this.subjectTable = subjectTable;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            new StudentListController(section, subjectTable);
            view.encodeFrame.dispose();
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



