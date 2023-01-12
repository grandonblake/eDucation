package models;

import utils.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student extends ObservableModel implements Person{
    //FIELDS
    private String username, password, firstName, middleName, lastName, program, age, sex, contactNumber, address, email; //student information
    private String cs002_section = "null", gec004_section = "null", pe001_section = "null", math014_section = "null",
                    cs001_section = "null"; //student sections
    private static Student currentlyLoggedIn; //the currently logged-in student

    //ARRAYLIST
    static List<Student> studentUsernameArray = new ArrayList<>();
    public List<Student> getStudentUsernameArray() {return studentUsernameArray;}

    //CONSTRUCTORS
    public Student(){} //empty constructor
    public Student(String username, String password){ //constructor with only username and password
        this.username = username;
        this.password = password;
    }
    public Student(String username, String password, String firstName, String middleName, String lastName, String program,
                   String age, String sex, String contactNumber, String address, String email, String cs002_section,
                   String gec004_section, String pe001_section, String math014_section, String cs001_section){ //complete constructor
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.program = program;
        this.age = age;
        this.sex = sex;
        this.contactNumber = contactNumber;
        this.address = address;
        this.email = email;
        this.cs002_section = cs002_section;
        this.gec004_section = gec004_section;
        this.pe001_section = pe001_section;
        this.math014_section = math014_section;
        this.cs001_section = cs001_section;

    }

    //GETTER
    public Student getCurrentlyLoggedIn() {
        loadData();
        return currentlyLoggedIn;
    }

    public String get(String field){
        if(field.equals("username")){return username;}
        if(field.equals("password")){return password;}
        if(field.equals("firstName")){return firstName;}
        if(field.equals("middleName")){return middleName;}
        if(field.equals("lastName")){return lastName;}
        if(field.equals("program")){return program;}
        if(field.equals("age")){return age;}
        if(field.equals("sex")){return sex;}
        if(field.equals("address")){return address;}
        if(field.equals("contactNumber")){return contactNumber;}
        if(field.equals("email")){return email;}
        if(field.equals("cs002_section")){ return cs002_section;}
        if(field.equals("gec004_section")){ return gec004_section;}
        if(field.equals("pe001_section")){ return pe001_section;}
        if(field.equals("math014_section")){return math014_section;}
        if(field.equals("cs001_section")){return cs001_section;}
        else{return "Error in Get Method";}
    }

    //SETTER
    public void set(String field, String set){ //setter
        if(field.equals("username")){username = set;}
        if(field.equals("password")){password = set;}
        if(field.equals("firstName")){firstName = set;}
        if(field.equals("middleName")){middleName = set;}
        if(field.equals("lastName")){lastName = set;}
        if(field.equals("program")){program = set;}
        if(field.equals("age")){age = set;}
        if(field.equals("sex")){sex = set;}
        if(field.equals("address")){address = set;}
        if(field.equals("contactNumber")){contactNumber = set;}
        if(field.equals("email")){email = set;}
        if(field.equals("cs002_section")){
            cs002_section = set;
            editSection("cs002_section", set);
        }
        if(field.equals("gec004_section")){
            gec004_section = set;
            editSection("gec004_section", set);
        }
        if(field.equals("pe001_section")){
            pe001_section = set;
            editSection("pe001_section", set);
        }
        if(field.equals("math014_section")){
            math014_section = set;
            editSection("math014_section", set);
        }
        if(field.equals("cs001_section")){
            cs001_section = set;
            editSection("cs001_section", set);
        }
    }


    //METHODS


    //method for student registration
    public static boolean studentRegister(String studentUsernameRegister, String studentPasswordRegister){
        if(studentUsernameArray.size() == 0){
            Student student = new Student(studentUsernameRegister, studentPasswordRegister);
            studentUsernameArray.add(student);
            return true;
        }
        else {
            boolean noSimilarAccount = true;
            for(int i = 0; i < studentUsernameArray.size(); i++){
                if (studentUsernameArray.get(i).get("username").equals(studentUsernameRegister)){
                    noSimilarAccount = false;
                }
            }
            while(noSimilarAccount){
                Student student = new Student(studentUsernameRegister, studentPasswordRegister);
                studentUsernameArray.add(student);
                return true;
            }
        }
        return false;
    }

    //method for student log-in
    public boolean login(String studentUsernameLogin, String studentPasswordLogin){
        if (studentUsernameArray.size() != 0) {
            for (int i = 0; i < studentUsernameArray.size(); i++) {
                if (studentUsernameArray.get(i).get("username").equals(studentUsernameLogin) && studentUsernameArray.get(i).get("password").equals(studentPasswordLogin)) {
                    currentlyLoggedIn = studentUsernameArray.get(i);

                    return true;
                }
            }
        }
        return false;
    }

    //to add a student on the database
    public void addStudent(Student object){
        // call SQL query for insert
        String sql = String.format(
                "INSERT INTO student (username, password, firstName, middleName, lastName, program, age, sex, contactNumber, address, email, cs002_section, gec004_section, pe001_section, math014_section, cs001_section) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                object.get("username"),
                object.get("password"),
                object.get("firstName"),
                object.get("middleName"),
                object.get("lastName"),
                object.get("program"),
                object.get("age"),
                object.get("sex"),
                object.get("contactNumber"),
                object.get("address"),
                object.get("email"),
                object.get("cs002_section"),
                object.get("gec004_section"),
                object.get("pe001_section"),
                object.get("math014_section"),
                object.get("cs001_section")
        );
        DBConnection.executeUpdate(sql); // execute update and reload data to reflect changes
        loadData();
    }

    //to edit or update student details in the database
    public void editStudent(String firstName, String middleName, String lastName, String program, String age, String sex,
                            String contactNumber, String address, String email){

        String sql = String.format(
                "UPDATE student SET " +
                        "firstName=" + "'" + firstName + "', " +
                        "middleName=" + "'" + middleName + "', " +
                        "lastName=" + "'" + lastName + "', " +
                        "program=" + "'" + program + "', " +
                        "age=" + "'" + age + "', " +
                        "sex=" + "'" + sex + "', " +
                        "contactNumber=" + "'" + contactNumber + "', " +
                        "address=" + "'" + address + "', " +
                        "email=" + "'" + email + "'" +
                        "WHERE username =" + "'" + getCurrentlyLoggedIn().get("username") + "'"
        );
        DBConnection.executeUpdate(sql);
        loadData();

        for (int i = 0; i < studentUsernameArray.size(); i++) {
            if (studentUsernameArray.get(i).get("username").equals(currentlyLoggedIn.username)) {
                currentlyLoggedIn = studentUsernameArray.get(i);

                changed();
            }
        }
    }

    //to edit the section of a student
    public void editSection(String section, String set){
        String sql = String.format(
                "UPDATE student SET " +
                        section + "=" + "'" + set + "'" +
                        "WHERE username =" + "'" + getCurrentlyLoggedIn().get("username") + "'"
        );
        DBConnection.executeUpdate(sql);
        loadData();

        for (int i = 0; i < studentUsernameArray.size(); i++) {
            if (studentUsernameArray.get(i).get("username").equals(currentlyLoggedIn.username)) {
                currentlyLoggedIn = studentUsernameArray.get(i);

                changed();
            }
        }
    }

    //to load the students from the database
    public void loadData(){
        ResultSet rs = DBConnection.executeQuery(
                "SELECT * FROM student;"
        );
        try{
            studentUsernameArray.clear();
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firstName = rs.getString("firstName");
                String middleName = rs.getString("middleName");
                String lastName = rs.getString("lastName");
                String program = rs.getString("program");
                String age = rs.getString("age");
                String sex = rs.getString("sex");
                String contactNumber = rs.getString("contactNumber");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String cs002_section = rs.getString("cs002_section");
                String gec004_section = rs.getString("gec004_section");
                String pe001_section = rs.getString("pe001_section");
                String math014_section = rs.getString("math014_section");
                String cs001_section = rs.getString("cs001_section");
                studentUsernameArray.add(
                        new Student(username, password, firstName, middleName, lastName, program, age, sex, contactNumber, address,
                                email, cs002_section, gec004_section, pe001_section, math014_section, cs001_section));
            }
        }
        catch(NullPointerException ex){}
        catch(SQLException ex){ ex.printStackTrace(); }
    }
}