package dao;

import database.DBConnection;
import model.Student;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student s){

        try{

            String sql="INSERT INTO students(name,gender,email,phone,photo) VALUES(?,?,?,?,?)";


            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,s.getName());
            ps.setString(2,s.getGender());
            ps.setString(3,s.getEmail());
            ps.setString(4,s.getPhone());
            ps.setString(5,s.getPhoto());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Student> getStudents(){

        List<Student> list = new ArrayList<>();

        try{

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while(rs.next()){

                list.add(new Student(

                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("photo")
                ));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public void deleteStudent(int id){

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM students WHERE id=?"
            );

            ps.setInt(1,id);
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // ADD THIS METHOD
    public void updateStudent(Student s){

        try{

            String sql = "UPDATE students SET name=?, gender=?, email=?, phone=?, photo=? WHERE id=?";

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,s.getName());
            ps.setString(2,s.getGender());
            ps.setString(3,s.getEmail());
            ps.setString(4,s.getPhone());
            ps.setString(5,s.getPhoto());
            ps.setInt(6,s.getId());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}