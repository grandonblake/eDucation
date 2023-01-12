package models;

import utils.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Instructor extends ObservableModel implements Person {
    //FIELDS
    private String username, password, prefix, firstName, middleInitial, lastName, age, sex, degree, email; //instructor information
    private static Instructor currentlyLoggedIn; ////the currently logged-in instructor

    //ARRAYLIST
    public static List<Instructor> instructorUsernameArray = new ArrayList<Instructor>(); //arrayList
    public static List<Instructor> getInstructorUsernameArray() {
        return instructorUsernameArray;
    }

    //CONSTRUCTORS
    public Instructor(){} //empty constructor
    public Instructor(String username, String password, String prefix, String firstName, String middleInitial, String lastName, String age, String sex, String degree, String email) { //complete constructor
        this.username = username;
        this.password = password;
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.degree = degree;
        this.email = email;
    }

    //GETTERS
    public Instructor getCurrentlyLoggedIn() { //get the currently logged-in instructor
        loadData();
        return currentlyLoggedIn;
    }

    public String get(String field) { //get instructor details
        if (field.equals("username")) {return username;}
        if (field.equals("password")) {return password;}
        if (field.equals("prefix")) {return prefix;}
        if (field.equals("firstName")) {return firstName;}
        if (field.equals("middleInitial")) {return middleInitial;}
        if (field.equals("lastName")) {return lastName;}
        if (field.equals("age")) {return age;}
        if (field.equals("sex")){return sex;}
        if (field.equals("degree")) {return degree;}
        if (field.equals("email")){return email;}
        else {return "Error in Get Method";}
    }

    //METHODS

    //method for instructor log-in
    public boolean login(String InstructorUsernameLogin, String InstructorPasswordLogin) {
        if (instructorUsernameArray.size() != 0) {
            for (int i = 0; i < instructorUsernameArray.size(); i++) {
                if (instructorUsernameArray.get(i).get("username").equals(InstructorUsernameLogin) && instructorUsernameArray.get(i).get("password").equals(InstructorPasswordLogin)) {
                    currentlyLoggedIn = instructorUsernameArray.get(i);
                    return true;
                }
            }
        }
        return false;
    }

    //to get the number of students from a section's table in the database
    public int numOfStudents(String tableName){
        int rowCount = 0;
        ResultSet rs = DBConnection.executeQuery(
                "SELECT COUNT(*) FROM " + tableName + ";"
        );
        try{
            while(rs.next()){
                rowCount = rs.getInt(1);
            }
        }
        catch(NullPointerException ex){}
        catch(SQLException ex){ ex.printStackTrace(); }
        return rowCount;
    }

    //to get the number of graded or complete students from a section's table in the database
    public int numOfGradedStudents(String tableName){
        int gradedCount = 0;
        ResultSet rs = DBConnection.executeQuery(
                "SELECT COUNT(*) FROM " + tableName + " WHERE status = 'COMPLETE';"
        );
        try{
            while(rs.next()){
                gradedCount = rs.getInt(1);
            }
        }
        catch(NullPointerException ex){}
        catch(SQLException ex){ ex.printStackTrace(); }
        return gradedCount;
    }

    //to edit or update student details in the database
    public void editInstructor(String prefix, String firstName, String middleInitial, String lastName, String age, String sex,
                            String degree, String email){

        String sql = String.format(
                "UPDATE instructor SET " +
                        "prefix=" + "'" + prefix + "', " +
                        "firstName=" + "'" + firstName + "', " +
                        "middleInitial=" + "'" + middleInitial + "', " +
                        "lastName=" + "'" + lastName + "', " +
                        "age=" + "'" + age + "', " +
                        "sex=" + "'" + sex + "', " +
                        "degree=" + "'" + degree + "', " +
                        "email=" + "'" + email + "'" +
                        "WHERE username =" + "'" + getCurrentlyLoggedIn().get("username") + "'"

        );
        DBConnection.executeUpdate(sql);
        loadData();

        for (int i = 0; i < instructorUsernameArray.size(); i++) {
            if (instructorUsernameArray.get(i).get("username").equals(currentlyLoggedIn.username)) {
                currentlyLoggedIn = instructorUsernameArray.get(i);

                changed();
            }
        }
    }

    //to load the instructors from the database
    public void loadData(){
        ResultSet rs = DBConnection.executeQuery(
                "SELECT * FROM instructor;"
        );
        try{
            instructorUsernameArray.clear();
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String prefix = rs.getString("prefix");
                String firstName = rs.getString("firstName");
                String middleInitial = rs.getString("middleInitial");
                String lastName = rs.getString("lastName");
                String age = rs.getString("age");
                String sex = rs.getString("sex");
                String degree = rs.getString("degree");
                String email = rs.getString("email");
                instructorUsernameArray.add(
                        new Instructor(username, password, prefix, firstName, middleInitial, lastName, age, sex, degree, email));
            }
        }
        catch(NullPointerException ex){}
        catch(SQLException ex){ ex.printStackTrace(); }
    }
}