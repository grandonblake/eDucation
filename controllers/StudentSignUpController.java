package controllers;

import models.*;
import views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentSignUpController {
    private Student model;
    private StudentSignUpView view;

    public StudentSignUpController(){
        model = new Student();
        view = new StudentSignUpView();

        view.homeLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SignInController();
                view.MainFrame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                view.homeLabel.setForeground(Color.GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                view.homeLabel.setForeground(Color.WHITE);
            }
        });

        view.signInLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new StudentSignInController();
                view.MainFrame.dispose();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                view.signInLabel.setForeground(Color.GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                view.signInLabel.setForeground(Color.WHITE);
            }
        });

        view.usernameTextF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.usernameTextF.getText().equals("USERNAME")) {
                    view.usernameTextF.setText("");
                    view.usernameTextF.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (view.usernameTextF.getText().isEmpty()) {
                    view.usernameTextF.setForeground(Color.LIGHT_GRAY);
                    view.usernameTextF.setText("USERNAME");
                }
            }
        });

        view.passwordTextF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (view.passwordTextF.getText().equals("PASSWORD")) {
                    view.passwordTextF.setText("");
                    view.passwordTextF.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (view.passwordTextF.getText().isEmpty()) {
                    view.passwordTextF.setForeground(Color.LIGHT_GRAY);
                    view.passwordTextF.setText("PASSWORD");
                }
            }
        });

        view.SignUpButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String studentUsernameRegister = view.getTextUsername();
                String studentPasswordRegister = view.getTextPassword();

                if(studentUsernameRegister.equals("USERNAME") && studentPasswordRegister.equals("PASSWORD")){
                    JOptionPane.showMessageDialog(view.MainFrame, "Kindly input valid username and password", "Register Credentials Invalid", JOptionPane.ERROR_MESSAGE);
                }
                else if ((studentUsernameRegister.length() >= 4 && studentUsernameRegister.length() <= 16) &&
                        (studentPasswordRegister.length() >= 4 && studentPasswordRegister.length() <= 16)) {

                    if(Student.studentRegister(studentUsernameRegister, studentPasswordRegister)){
                        new StudentSignUpDetailsController();
                        view.MainFrame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(view.MainFrame, "Username is already taken", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    if(studentUsernameRegister.length() < 4 && studentPasswordRegister.length() < 4){
                        JOptionPane.showMessageDialog(view.MainFrame, "Username and Password is too short", "Username and Password Length Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(studentUsernameRegister.length() > 16  && studentPasswordRegister.length() > 16){
                        JOptionPane.showMessageDialog(view.MainFrame, "Maximum Length of Username and Password is reached [max: 16]", "Username Length Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(studentUsernameRegister.length() < 4  && studentPasswordRegister.length() > 16){
                        JOptionPane.showMessageDialog(view.MainFrame, "Username is too short.\nMaximum Length of Password is reached [max: 16]", "Username Length Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(studentUsernameRegister.length() > 16  && studentPasswordRegister.length() < 4){
                        JOptionPane.showMessageDialog(view.MainFrame, "Maximum Length of Username is reached [max: 16]\nPassword is too short", "Username Length Error", JOptionPane.ERROR_MESSAGE);
                    }

                    else {
                        if (studentUsernameRegister.length() < 4) {
                            JOptionPane.showMessageDialog(view.MainFrame, "Username is too short", "Username Length Error", JOptionPane.ERROR_MESSAGE);
                        }
                        if (studentPasswordRegister.length() < 4) {
                            JOptionPane.showMessageDialog(view.MainFrame, "Password is too short", "Password Length Error", JOptionPane.ERROR_MESSAGE);
                        }
                        if (studentUsernameRegister.length() > 16) {
                            JOptionPane.showMessageDialog(view.MainFrame, "Maximum Length of Username is reached [max: 16]", "Username Length Error", JOptionPane.ERROR_MESSAGE);
                        }
                        if (studentPasswordRegister.length() > 16) {
                            JOptionPane.showMessageDialog(view.MainFrame, "Maximum Length of Password is reached [max: 16]", "Password Length Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
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

