package controller;

import dao.StudentDAO;
import model.Student;

import java.util.List;

public class StudentController {

    private StudentDAO dao;

    public StudentController() {
        dao = new StudentDAO();
    }

    // CREATE
    public void addStudent(Student s){
        dao.addStudent(s);
    }

    // READ
    public List<Student> getStudents(){
        return dao.getStudents();
    }

    // UPDATE
    public void updateStudent(Student s){
        dao.updateStudent(s);
    }

    // DELETE
    public void deleteStudent(int id){
        dao.deleteStudent(id);
    }
}