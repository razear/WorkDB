package main.myJavaFX;

import main.FirstClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zuni on 04.05.2018.
 */
public class EnterDataRes  {
    static JFrame jFrame =getFrame();

    static JPanel jPanel = new JPanel();



    public static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(350,250,350,200);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return jFrame;
    }

    public static void main(String[] args) {
        setComponentOnMyFrame("","","");

    }

    public static void setComponentOnMyFrame(String host,String login, String password) {
        jFrame.add(jPanel);

        jPanel.setLayout(new MyLayout());

        JLabel jLabelArd = new JLabel("Address bd: ");
        JTextField jTextFieldAdr = new JTextField(20);
        jTextFieldAdr.setText(host);
        jPanel.add(jLabelArd);
        jPanel.add(jTextFieldAdr);


        JLabel jLabelLog = new JLabel("Login bd: ");
        JTextField jTextFieldLog = new JTextField(20);
        jTextFieldLog.setText(login);
        jPanel.add(jLabelLog);
        jPanel.add(jTextFieldLog);

        JLabel jLabelPas = new JLabel("Password bd: ");
        JTextField jTextFieldPas = new JTextField(20);
        jTextFieldPas.setText(password);
        jPanel.add(jLabelPas);
        jPanel.add(jTextFieldPas);


        JButton jButton = new JButton("Submit");
        jPanel.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstClass.setHost(jTextFieldAdr.getText());
                FirstClass.setLogin(jTextFieldLog.getText());
                FirstClass.setPassword(jTextFieldPas.getText());
                FirstClass.setProperty();
                jFrame.dispose();
            }
        });

        jPanel.revalidate();
    }


    static class MyLayout implements LayoutManager{
        int lastPoz = 0;
        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return null;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
            for (int i =0 ; i<parent.getComponentCount(); i++){
               if (parent.getComponent(i).getClass() != JTextField.class) {
                   Component component = parent.getComponent(i);
                   component.setBounds(0, i * 15, 100, 20);
                   lastPoz = i * 15;
               } else {
                   Component component = parent.getComponent(i);

                   component.setBounds(90, lastPoz, 200, 20);
               }
            }
        }
    }

}
