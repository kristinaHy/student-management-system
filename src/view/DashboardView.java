package view;

import javax.swing.*;
import java.awt.*;


public class DashboardView extends JFrame {


    public DashboardView(){

        setTitle("Student Management System");
        setSize(1200,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabs=new JTabbedPane();

        tabs.add("Students",new StudentPanel());
        tabs.add("Courses",new JPanel());
        tabs.add("Scores",new JPanel());
        tabs.add("Marks Sheet",new JPanel());

        add(tabs);

        setVisible(true);
    }

    public static void main(String[] args){


            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            new DashboardView();

    }
}