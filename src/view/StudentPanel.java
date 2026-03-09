package view;

import controller.StudentController;
import model.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.List;

public class StudentPanel extends JPanel {

    JTextField nameField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField phoneField = new JTextField();

    JComboBox<String> genderBox =
            new JComboBox<>(new String[]{"Male","Female"});

    JLabel photoPreview = new JLabel("No Image",SwingConstants.CENTER);

    JTable table = new JTable();

    String photoPath="";

    StudentController controller = new StudentController();

    public StudentPanel(){

        setLayout(new BorderLayout());
        setBackground(new Color(0,170,140));

        // LEFT FORM PANEL
        JPanel formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(280,500));
        formPanel.setLayout(new GridLayout(12,1,8,8));
        formPanel.setBorder(new EmptyBorder(15,15,15,15));
        formPanel.setBackground(new Color(0,170,140));

        formPanel.add(new JLabel("Student Name"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Gender"));
        formPanel.add(genderBox);

        formPanel.add(new JLabel("Email"));
        formPanel.add(emailField);

        formPanel.add(new JLabel("Phone"));
        formPanel.add(phoneField);

        // Photo Preview
        photoPreview.setPreferredSize(new Dimension(120,120));
        photoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JButton browseBtn = new JButton("Browse Photo");

        browseBtn.addActionListener(e -> choosePhoto());

        formPanel.add(browseBtn);
        formPanel.add(photoPreview);

        // Buttons
        JButton addBtn = new JButton("Add New");
        JButton deleteBtn = new JButton("Delete");
        JButton refreshBtn = new JButton("Refresh");

        styleButton(addBtn);
        styleButton(deleteBtn);
        styleButton(refreshBtn);

        addBtn.addActionListener(e -> addStudent());
        deleteBtn.addActionListener(e -> deleteStudent());
        refreshBtn.addActionListener(e -> loadStudents());

        formPanel.add(addBtn);
        formPanel.add(deleteBtn);
        formPanel.add(refreshBtn);

        add(formPanel,BorderLayout.WEST);

        // TABLE PANEL
        table.setRowHeight(28);
        table.setFont(new Font("Segoe UI",Font.PLAIN,14));

        table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,14));

        JScrollPane scroll = new JScrollPane(table);

        add(scroll,BorderLayout.CENTER);

        loadStudents();
    }

    // STYLE BUTTON
    private void styleButton(JButton btn){

        btn.setBackground(new Color(40,130,200));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI",Font.BOLD,14));
    }

    // PHOTO BROWSER
    private void choosePhoto(){

        JFileChooser chooser = new JFileChooser();

        if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){

            File file = chooser.getSelectedFile();

            photoPath = file.getAbsolutePath();

            ImageIcon icon = new ImageIcon(photoPath);

            Image img = icon.getImage().getScaledInstance(
                    120,120,Image.SCALE_SMOOTH
            );

            photoPreview.setIcon(new ImageIcon(img));
            photoPreview.setText("");
        }
    }

    // ADD STUDENT
    private void addStudent(){

        Student s = new Student(

                0,
                nameField.getText(),
                genderBox.getSelectedItem().toString(),
                emailField.getText(),
                phoneField.getText(),
                photoPath
        );

        controller.addStudent(s);

        loadStudents();
    }

    // DELETE STUDENT
    private void deleteStudent(){

        int row = table.getSelectedRow();

        if(row==-1){
            JOptionPane.showMessageDialog(this,"Select a row first");
            return;
        }

        int id = (int)table.getValueAt(row,0);

        controller.deleteStudent(id);

        loadStudents();
    }

    // LOAD STUDENTS
    private void loadStudents(){

        List<Student> list = controller.getStudents();

        DefaultTableModel model = new DefaultTableModel();

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
        table.getSelectionModel().addListSelectionListener(e -> {

            int row = table.getSelectedRow();

            if(row>=0){

                nameField.setText(table.getValueAt(row,1).toString());
                genderBox.setSelectedItem(table.getValueAt(row,2));
                emailField.setText(table.getValueAt(row,3).toString());
                phoneField.setText(table.getValueAt(row,4).toString());
            }

        });
    }

}