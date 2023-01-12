package controllers;

import models.*;
import views.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class StudentSignUpDetailsController {
    private Student model;
    private StudentSignUpDetailsView view;

    public StudentSignUpDetailsController() {
        model = new Student();
        view = new StudentSignUpDetailsView();

        view.submitPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String studentContactNumber = view.getContactNumber();

                if (studentContactNumber.length() != 11) {
                    JOptionPane.showMessageDialog(view.MainFrame, "Contact Number should contain 11 characters", "Contact Number is Invalid", JOptionPane.ERROR_MESSAGE);
                }
                else if(view.getFirstName().isEmpty() || view.getMiddleName().isEmpty() || view.getLastName().isEmpty() || view.getContactNumber().isEmpty() || view.getAddress().isEmpty()){
                    JOptionPane.showMessageDialog(view.MainFrame, "Complete all input fields", "Input Details", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    model.getStudentUsernameArray().get(model.getStudentUsernameArray().size() - 1).set("firstName", view.getFirstName().trim());
                    model.getStudentUsernameArray().get(model.getStudentUsernameArray().size() - 1).set("middleName", view.getMiddleName().trim());
                    model.getStudentUsernameArray().get(model.getStudentUsernameArray().size() - 1).set("lastName", view.getLastName().trim());
                    model.getStudentUsernameArray().get(model.getStudentUsernameArray().size() - 1).set("program", view.getProgram());
                    model.getStudentUsernameArray().get(model.getStudentUsernameArray().size() - 1).set("age", view.getAge());
                    model.getStudentUsernameArray().get(model.getStudentUsernameArray().size() - 1).set("sex", view.getSex());
                    model.getStudentUsernameArray().get(model.getStudentUsernameArray().size() - 1).set("contactNumber", view.getContactNumber().trim());
                    model.getStudentUsernameArray().get(model.getStudentUsernameArray().size() - 1).set("address", view.getAddress().trim());
                    model.getStudentUsernameArray().get(model.getStudentUsernameArray().size() - 1).set("email", view.getEmail().trim());
                    model.addStudent(model.getStudentUsernameArray().get(model.getStudentUsernameArray().size() - 1));
                    new StudentSignInController();
                    view.MainFrame.dispose();
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
    }
}