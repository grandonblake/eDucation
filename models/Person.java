package models;

//PERSON INTERFACE
public interface Person {
    //similar methods from Student, Instructor, and Enrollment
    void changed();
    boolean login(String username, String password);
    void loadData();
}
