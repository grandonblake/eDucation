package controllers;

import views.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstructorMainController {
    private Instructor model;
    private InstructorMainView view;

    public InstructorMainController() {
        model = new Instructor();
        view = new InstructorMainView();
        model.addObserver(view);
        model.changed();

        view.profInfoFrame.addMouseListener(new MouseListener() {
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

        view.editPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.firstNameTfield.setEditable(true);
                view.firstNameTfield.setBorder(BorderFactory.createLineBorder(Color.white));
                view.middleInitialTfield.setEditable(true);
                view.middleInitialTfield.setBorder(BorderFactory.createLineBorder(Color.white));
                view.lastNameTfield.setEditable(true);
                view.lastNameTfield.setBorder(BorderFactory.createLineBorder(Color.white));
                view.prefixTfield.setEditable(false);
                view.age.setVisible(false);
                view.prefixComboBox.setEnabled(true);
                view.prefixComboBox.setVisible(true);
                view.ageComboBox.setEnabled(true);
                view.ageComboBox.setVisible(true);
                view.sexComboBox.setEnabled(true);
                view.sexComboBox.setVisible(true);
                view.degree.setEditable(true);
                view.degree.setBorder(BorderFactory.createLineBorder(Color.white));
                view.email.setEditable(true);
                view.email.setBorder(BorderFactory.createLineBorder(Color.white));

                view.editPanel.setVisible(false);
                view.savePanel.setVisible(true);

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

        view.savePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.firstNameTfield.setEditable(false);
                view.firstNameTfield.setBorder(BorderFactory.createEmptyBorder());
                view.middleInitialTfield.setEditable(false);
                view.middleInitialTfield.setBorder(BorderFactory.createEmptyBorder());
                view.lastNameTfield.setEditable(false);
                view.lastNameTfield.setBorder(BorderFactory.createEmptyBorder());
                view.prefixTfield.setEditable(true);
                view.age.setVisible(true);
                view.prefixComboBox.setEnabled(false);
                view.prefixComboBox.setVisible(false);
                view.ageComboBox.setEnabled(false);
                view.ageComboBox.setVisible(false);
                view.sexComboBox.setEnabled(false);
                view.sexComboBox.setVisible(false);
                view.degree.setEditable(false);
                view.degree.setBorder(BorderFactory.createEmptyBorder());
                view.email.setEditable(false);
                view.email.setBorder(BorderFactory.createEmptyBorder());

                view.editPanel.setVisible(true);
                view.savePanel.setVisible(false);

                view.editable.setVisible(false);

                view.prefixTfield.setText(view.prefixComboBox.getSelectedItem().toString());
                view.age.setText(view.ageComboBox.getSelectedItem().toString());
                view.sex.setText(view.sexComboBox.getSelectedItem().toString());

                model.editInstructor(view.prefixTfield.getText(), view.firstNameTfield.getText(), view.middleInitialTfield.getText(),
                        view.lastNameTfield.getText(), view.age.getText(), view.sex.getText(), view.degree.getText(),
                        view.email.getText());
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

        //Action Listener for Add Button

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

        view.seeSchedulePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new InstructorSeeScheduleController();
                view.profInfoFrame.dispose();
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
                view.profInfoFrame.dispose();
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
                view.profInfoFrame.dispose();
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