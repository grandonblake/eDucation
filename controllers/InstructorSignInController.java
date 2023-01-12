package controllers;
import models.*;
import views.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstructorSignInController {
    private Instructor model;
    private InstructorSignInView view;

    public InstructorSignInController() {
        model = new Instructor();
        view = new InstructorSignInView();

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

        view.SignInButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(model.login(view.getUserNameTextField(), view.getPasswordTextField())) {
                    new InstructorMainController();
                    view.MainFrame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(view.MainFrame, "Invalid account!", "Error",  JOptionPane.ERROR_MESSAGE);
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