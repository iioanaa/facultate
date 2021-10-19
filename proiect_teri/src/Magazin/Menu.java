package Magazin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loginButton;
    private JButton singinButton;
    public JPanel LoginScreen;
    private JPanel Login;
    private JPanel Singin;
    private JPanel Magazin;
    private JTextField NewUsernameFild;
    private JPasswordField NewPasswordFild;
    private JButton SaveButton;
    private JButton BackButton;
    public static String Username = "Ioana";
    public static String Password = "1234";


    public Menu() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(textField1.getText(), Username) && Objects.equals(passwordField1.getText(), Password)) {
                    Login.setVisible(false);
                    Magazin.setVisible(true);
                }
            }
        });
        singinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.setVisible(false);
                Singin.setVisible(true);
            }
        });
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.setVisible(true);
                Singin.setVisible(false);
            }
        });
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Password = passwordField1.getText();
                Username = textField1.getText();
                Login.setVisible(true);
                Singin.setVisible(false);
            }
        });
    }

}