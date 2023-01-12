package controllers;
import models.*;

import views.StudentMainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentMainController {
    private Student model;
    private StudentMainView view;

    public StudentMainController(){
        model = new Student();
        view = new StudentMainView();
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

        view.EditPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.firstName.setEditable(true);
                view.firstName.setBorder(BorderFactory.createLineBorder(Color.white));
                view.middleName.setEditable(true);
                view.middleName.setBorder(BorderFactory.createLineBorder(Color.white));
                view.lastName.setEditable(true);
                view.lastName.setBorder(BorderFactory.createLineBorder(Color.white));
                view.ageComboBox.setEnabled(true);
                view.ageComboBox.setVisible(true);
                view.sexComboBox.setEnabled(true);
                view.sexComboBox.setVisible(true);
                view.contact.setEditable(true);
                view.contact.setBorder(BorderFactory.createLineBorder(Color.white));
                view.address.setEditable(true);
                view.address.setBorder(BorderFactory.createLineBorder(Color.white));
                view.email.setEditable(true);
                view.email.setBorder(BorderFactory.createLineBorder(Color.white));

                view.EditPanel.setVisible(false);
                view.SavePanel.setVisible(true);

                view.editable.setVisible(true);
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

        view.SavePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.firstName.setEditable(false);
                view.firstName.setBorder(BorderFactory.createEmptyBorder());
                view.middleName.setEditable(false);
                view.middleName.setBorder(BorderFactory.createEmptyBorder());
                view.lastName.setEditable(false);
                view.lastName.setBorder(BorderFactory.createEmptyBorder());
                view.ageComboBox.setEnabled(false);
                view.ageComboBox.setVisible(false);
                view.sexComboBox.setEnabled(false);
                view.sexComboBox.setVisible(false);
                view.contact.setEditable(false);
                view.contact.setBorder(BorderFactory.createEmptyBorder());
                view.address.setEditable(false);
                view.address.setBorder(BorderFactory.createEmptyBorder());
                view.email.setEditable(false);
                view.email.setBorder(BorderFactory.createEmptyBorder());

                view.EditPanel.setVisible(true);
                view.SavePanel.setVisible(false);

                view.editable.setVisible(false);

                view.age.setText(view.ageComboBox.getSelectedItem().toString());
                view.sex.setText(view.sexComboBox.getSelectedItem().toString());

                model.editStudent(view.firstName.getText(), view.middleName.getText(), view.lastName.getText(),
                        view.program.getText(), view.age.getText(), view.sex.getText(), view.contact.getText(),
                        view.address.getText(), view.email.getText());
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
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
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
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
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



