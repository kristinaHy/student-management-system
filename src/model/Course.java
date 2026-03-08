package model;

public class Course {

    private int id;
    private String courseName;
    private int credit;

    public Course() {}

    public Course(int id, String courseName, int credit) {
        this.id = id;
        this.courseName = courseName;
        this.credit = credit;
    }

}