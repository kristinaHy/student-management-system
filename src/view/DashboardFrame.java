package view;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    JPanel contentPanel = new JPanel(new CardLayout());

    public DashboardFrame(){

        setTitle("Student Management System");
        setSize(1200,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(createSidebar(),BorderLayout.WEST);
        add(contentPanel,BorderLayout.CENTER);

        contentPanel.add(new StudentPanel(),"students");
        contentPanel.add(new CoursePanel(),"courses");
        contentPanel.add(new ScorePanel(),"scores");
        contentPanel.add(new MarksPanel(),"marks");

        setVisible(true);
    }

    private JPanel createSidebar(){

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(180,600));
        panel.setBackground(new Color(30,40,60));
        panel.setLayout(new GridLayout(4,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));

        JButton students = createMenuButton("Students");
        JButton courses = createMenuButton("Courses");
        JButton scores = createMenuButton("Scores");
        JButton marks = createMenuButton("Marks Sheet");

        students.addActionListener(e -> switchPanel("students"));
        courses.addActionListener(e -> switchPanel("courses"));
        scores.addActionListener(e -> switchPanel("scores"));
        marks.addActionListener(e -> switchPanel("marks"));

        panel.add(students);
        panel.add(courses);
        panel.add(scores);
        panel.add(marks);

        return panel;
    }

    private JButton createMenuButton(String text){

        JButton btn = new JButton(text);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(45,60,90));
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI",Font.BOLD,14));


        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(70,90,130));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(45,60,90));
            }
        });

        return btn;
    }

    private void switchPanel(String name){

        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel,name);
    }

    public static void main(String[] args){

        try{
            for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        }catch(Exception ignored){}

        new DashboardFrame();
    }
}