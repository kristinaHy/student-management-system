package model;

public class Student {

    private int id;
    private String name;
    private String gender;
    private String email;
    private String phone;

    public Student() {}

    public Student(int id, String name, String gender, String email, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}