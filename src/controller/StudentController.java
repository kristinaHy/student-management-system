package controller;

import dao.StudentDAO;
import model.Student;

import java.util.List;

public class StudentController {

    StudentDAO dao=new StudentDAO();

    public void addStudent(Student s){
        dao.addStudent(s);
    }

    public List<Student> getStudents(){
        return dao.getStudents();
    }

    public void deleteStudent(int id){
        dao.deleteStudent(id);
    }
}