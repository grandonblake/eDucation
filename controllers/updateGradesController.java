package controllers;

import views.updateGradesView;

import models.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class updateGradesController {
    private updateGradesView view;
    private Student studentModel;
    private Instructor instructorModel;
    private Enrollment enrollmentModel;
    String section;
    String studentData;
    String studentDataString;
    String subjectTable;
    String studentName2;

    public updateGradesController(String section, String studentData, String subjectTable){
        studentModel = new Student();
        instructorModel = new Instructor();
        enrollmentModel = new Enrollment();
        this.section = section;
        this.studentData = studentData;
        this.subjectTable = subjectTable;

        enrollmentModel.loadData(section.toLowerCase(Locale.ROOT) + "_" + subjectTable);

        for (int i = 0; i < studentModel.getStudentUsernameArray().size(); i++) {
            String username = studentModel.getStudentUsernameArray().get(i).get("username");

            if (username.equals(studentData)) {
                for (int j = 0; j < enrollmentModel.getEnrollmentArray().size(); j++) {
                    if (username.equals(enrollmentModel.getEnrollmentArray().get(j).get("student_username"))) {
                        studentDataString = enrollmentModel.getEnrollmentArray().get(j).get("student_username");
                        studentName2 = studentModel.getStudentUsernameArray().get(i).get("firstName") + " " + studentModel.getStudentUsernameArray().get(i).get("lastName");
                    }
                }
            }
        }

        view = new updateGradesView(studentModel, instructorModel, enrollmentModel, studentDataString, studentName2);

        instructorModel.addObserver(view);
        instructorModel.changed();

        view.updateGradesFrame.addMouseListener(new MouseListener() {
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

        view.updateButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < 8; i++) {
                    view.scoreDataArray.get(i).setEditable(true);
                    view.itemDataArray.get(i).setEditable(true);
                }

                view.updateButton.setVisible(false);
                view.saveButton.setVisible(true);
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

        view.saveButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean bool = false;
                for (int i = 0; i < view.scoreDataArray.size(); i++) {
                    if(Integer.parseInt(view.scoreDataArray.get(i).getText()) > Integer.parseInt(view.itemDataArray.get(i).getText())){
                        JOptionPane.showMessageDialog(view.updateGradesFrame, "Score is higher than number of items!", "Error!", JOptionPane.ERROR_MESSAGE);
                        bool = false;
                        break;
                    }
                    else {
                        bool = true;
                    }
                }

                if(bool){
                    for (int i = 0; i < 8; i++) {
                        view.scoreDataArray.get(i).setEditable(false);
                        view.itemDataArray.get(i).setEditable(false);
                    }


                    view.updateButton.setVisible(true);
                    view.saveButton.setVisible(false);

                    enrollmentModel.encodeGrades(Integer.parseInt(view.scoreDataArray.get(3).getText()), Integer.parseInt(view.scoreDataArray.get(4).getText()), Integer.parseInt(view.scoreDataArray.get(5).getText()),
                            Integer.parseInt(view.scoreDataArray.get(0).getText()), Integer.parseInt(view.scoreDataArray.get(1).getText()), Integer.parseInt(view.scoreDataArray.get(2).getText()),
                            Integer.parseInt(view.scoreDataArray.get(6).getText()), Integer.parseInt(view.scoreDataArray.get(7).getText()),
                            Integer.parseInt(view.itemDataArray.get(3).getText()), Integer.parseInt(view.itemDataArray.get(4).getText()), Integer.parseInt(view.itemDataArray.get(5).getText()),
                            Integer.parseInt(view.itemDataArray.get(0).getText()), Integer.parseInt(view.itemDataArray.get(1).getText()), Integer.parseInt(view.itemDataArray.get(2).getText()),
                            Integer.parseInt(view.itemDataArray.get(6).getText()), Integer.parseInt(view.itemDataArray.get(7).getText()), section + "_" + subjectTable, studentDataString);

                    instructorModel.changed();
                }
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

        view.backButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new StudentListController(section, subjectTable);
                view.updateGradesFrame.dispose();
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

        view.studentProfilePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new InstructorMainController();
                view.updateGradesFrame.dispose();
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
                view.updateGradesFrame.dispose();
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
                view.updateGradesFrame.dispose();
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
                view.updateGradesFrame.dispose();
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



