package View;

import Controller.LoginController;
import Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sanjeevbudha on 4/28/16.
 */
public class LoginScreen extends JFrame implements ActionListener {

    JButton btnLogin, btnReset, btnExit;
    JTextField jUser;
    JPasswordField jPassword;
    JLabel jLabelUser, jLabelPassword;

    public LoginScreen(String name){
        super(name);
        btnLogin = new JButton("Login");
//        btnReset = new JButton("Reset");
        btnExit  = new JButton("Exit");

        jUser     = new JTextField();
        jPassword = new JPasswordField();

        jLabelUser = new JLabel("Username :");
        jLabelPassword = new JLabel("Password :");

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnLogin.addActionListener(this);
//        btnReset.addActionListener(this);
        btnExit.addActionListener(this);

        jLabelUser.setBounds(10,50,120,20);
        jLabelPassword.setBounds(10,80,120,20);
        jUser.setBounds(140,50,300,20);
        jPassword.setBounds(140,80,300,20);

        btnLogin.setBounds(210,110,100,30);
//        btnReset.setBounds(240,110,100,30);
        btnExit.setBounds(320, 110,100,30);

        this.add(jLabelUser);
        this.add(jLabelPassword);
        this.add(jUser);
        this.add(jPassword);
        this.add(btnLogin);
//        this.add(btnReset);
        this.add(btnExit);

        this.setSize(500,300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String message = null;

        if(e.getSource() == btnLogin){
            String username = jUser.getText();
            String password = new String(jPassword.getPassword());

            User user = new LoginController().authentication(username,password);

            if(user.getFirstName()!=null){
                this.dispose();
                new DashBoard("Welcome "+user.getFirstName()+" " + user.getLastName());

            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid username or/and password");

            }
        }
//        else if (e.getSource() == btnReset){
//            message = "Reset Successful";
//        }
        else if (e.getSource() == btnExit){
            this.dispose();
        }

    }
}
