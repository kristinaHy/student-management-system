import dao.StudentDAO;
import model.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // CREATE
        Student student = new Student(
                "Kristina",
                "Female",
                "kristina@email.com",
                "9800000000",
                "photo.jpg"
        );

        dao.addStudent(student);

        // READ
        List<Student> students = dao.getAllStudents();

        for (Student s : students) {
            System.out.println(
                    s.getId() + " | " +
                            s.getName() + " | " +
                            s.getGender() + " | " +
                            s.getEmail() + " | " +
                            s.getPhone()
            );
        }
    }
}