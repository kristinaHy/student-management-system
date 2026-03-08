package model;

public class Student {

    private int id;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private String photo;

    // Constructor with id
    public Student(int id, String name, String gender, String email, String phone, String photo) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
    }

    // Constructor without id (for insert)
    public Student(String name, String gender, String email, String phone, String photo) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhoto() {
        return photo;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}