package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class Main extends JPanel {

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(49,119,201,17);
        g.drawRect(49,92,202,17);
        g.drawRect(49,52,202,15);
    }


    public static void main(String[] args) {
        JLabel login = new JLabel("");
        JLabel password = new JLabel("");
        JTextArea textArea1 = new JTextArea("");
        JTextArea textArea2 = new JTextArea(" ");
        JButton confirm = new JButton("Подтверждение");
        JFrame frame = new JFrame("nt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        frame.getContentPane().add(login);
        frame.getContentPane().add(password);
        frame.getContentPane().add(confirm);
        frame.getContentPane().add(textArea1);
        frame.getContentPane().add(textArea2);


        confirm.setBounds(50, 120, 200, 15);
        textArea1.setBounds(50, 93, 200, 15);
        textArea2.setBounds(50, 53, 200, 15);
        Main panel = new Main();
        panel.setLayout(new GridLayout(3, 2));
        panel.setPreferredSize(new Dimension(600, 600));
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.add(panel, BorderLayout.CENTER);

        login.setBounds(50, -410, 900, 900);
        login.setText("Введите Логин");
        password.setBounds(50, -370, 900, 900);
        password.setText("Введите Пароль");

        frame.setLocationRelativeTo(null);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (FileWriter writer = new FileWriter("notes3.txt", false)) {
                    String Login = textArea1.getText();
                    String Password = textArea2.getText();
                    writer.write("Логин " + Login);
                    writer.append("\n");
                    writer.append("Пароль " + Password);
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println("anlack");
                }
                JFrame frame_login = new JFrame("Авторизация");
                frame_login.setLayout(null);
                frame_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame_login.setVisible(true);
                frame_login.setSize(new Dimension(300, 100));
                JLabel label = new JLabel();
                label.setBounds(60, -30, 300, 120);
                label.setFont(new Font("Ariel", Font.BOLD,15));
                frame_login.getContentPane().add(label);
                label.setText("Вы Авторизировались");
                frame_login.setLocationRelativeTo(null);
                frame.setVisible(false);
                frame_login.setResizable(false);
            }
        });
    }
}