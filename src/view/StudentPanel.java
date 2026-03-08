package view;

import controller.StudentController;
import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.List;

public class StudentPanel extends JPanel {

    JTextField name=new JTextField();
    JTextField email=new JTextField();
    JTextField phone=new JTextField();

    JComboBox gender=new JComboBox(new String[]{"Male","Female"});

    JLabel photoLabel=new JLabel("No Image");

    JTable table=new JTable();

    String photoPath="";

    StudentController controller=new StudentController();

    public StudentPanel(){

        setLayout(new BorderLayout());

        setBackground(new Color(0,200,160));

        JPanel left=new JPanel(new GridLayout(10,1,5,5));

        left.setPreferredSize(new Dimension(300,500));

        left.add(new JLabel("Student Name"));
        left.add(name);

        left.add(new JLabel("Gender"));
        left.add(gender);

        left.add(new JLabel("Email"));
        left.add(email);

        left.add(new JLabel("Phone"));
        left.add(phone);

        JButton browse=new JButton("Browse Photo");

        browse.addActionListener(e->choosePhoto());

        left.add(browse);

        left.add(photoLabel);

        JButton add=new JButton("Add New");
        JButton delete=new JButton("Delete");
        JButton refresh=new JButton("Refresh");

        add.addActionListener(e->addStudent());
        delete.addActionListener(e->deleteStudent());
        refresh.addActionListener(e->loadStudents());

        left.add(add);
        left.add(delete);
        left.add(refresh);

        add(left,BorderLayout.WEST);

        table.setRowHeight(25);

        add(new JScrollPane(table),BorderLayout.CENTER);

        loadStudents();
    }

    private void choosePhoto(){

        JFileChooser chooser=new JFileChooser();

        if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){

            File file=chooser.getSelectedFile();

            photoPath=file.getAbsolutePath();

            photoLabel.setText(file.getName());
        }
    }

    private void addStudent(){

        Student s=new Student(

                0,
                name.getText(),
                gender.getSelectedItem().toString(),
                email.getText(),
                phone.getText(),
                photoPath
        );

        controller.addStudent(s);

        loadStudents();
    }

    private void deleteStudent(){

        int row=table.getSelectedRow();

        if(row==-1) return;

        int id=(int)table.getValueAt(row,0);

        controller.deleteStudent(id);

        loadStudents();
    }

    private void loadStudents(){

        List<Student> list=controller.getStudents();

        DefaultTableModel model=new DefaultTableModel();

        model.setColumnIdentifiers(new String[]{
                "ID","Name","Gender","Email","Phone","Photo"
        });

        for(Student s:list){

            model.addRow(new Object[]{
                    s.getId(),
                    s.getName(),
                    s.getGender(),
                    s.getEmail(),
                    s.getPhone(),
                    s.getPhoto()
            });
        }

        table.setModel(model);
    }
}