package models;
import utils.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Enrollment extends ObservableModel{
    //FIELDS
    private String student_username;
    private String status = "INCOMPLETE";

    //QUIZ SCORES
    private int quiz_1_score = 0;
    private int quiz_2_score = 0;
    private int quiz_3_score = 0;
    //ASSIGNMENT SCORES
    private int assignment_1_score = 0;
    private int assignment_2_score = 0;
    private int assignment_3_score = 0;
    //EXAM SCORES
    private int prelim_exam_score = 0;
    private int periodical_exam_score = 0;
    //QUIZ ITEMS
    private int quiz_1_items = 0;
    private int quiz_2_items = 0;
    private int quiz_3_items = 0;
    //ASSIGNMENT ITEMS
    private int assignment_1_items = 0;
    private int assignment_2_items = 0;
    private int assignment_3_items = 0;
    //EXAM ITEMS
    private int prelim_exam_items = 0;
    private int periodical_exam_items = 0;

    //ARRAYLIST
    private List<Enrollment> EnrollmentArray = new ArrayList<Enrollment>();
    public List<Enrollment> getEnrollmentArray() {
        return EnrollmentArray;
    }

    //GETTERS
    public String get(String field){
        if(field.equals("student_username")){
            return student_username;
        }
        else if(field.equals("status")){
            return status;
        }
        else{
            return "Error in Get Method";
        }
    }

    public int getInt(String field){
        if(field.equals("quiz_1_score")){
            return quiz_1_score;
        }
        else if(field.equals("quiz_2_score")){
            return quiz_2_score;
        }
        else if(field.equals("quiz_3_score")){
            return quiz_3_score;
        }
        else if(field.equals("assignment_1_score")){
            return assignment_1_score;
        }
        else if(field.equals("assignment_2_score")){
            return assignment_2_score;
        }
        else if(field.equals("assignment_3_score")){
            return assignment_3_score;
        }
        else if(field.equals("prelim_exam_score")){
            return prelim_exam_score;
        }
        else if(field.equals("periodical_exam_score")){
            return periodical_exam_score;
        }
        else if(field.equals("quiz_1_items")){
            return quiz_1_items;
        }
        else if(field.equals("quiz_2_items")){
            return quiz_2_items;
        }
        else if(field.equals("quiz_3_items")){
            return quiz_3_items;
        }
        else if(field.equals("assignment_1_items")){
            return assignment_1_items;
        }
        else if(field.equals("assignment_2_items")){
            return assignment_2_items;
        }
        else if(field.equals("assignment_3_items")){
            return assignment_3_items;
        }
        else if(field.equals("prelim_exam_items")){
            return prelim_exam_items;
        }
        else if(field.equals("periodical_exam_items")){
            return periodical_exam_items;
        }
        else{
            return 0;
        }
    }

    //SETTERS
    public void set(String field, String set){
        if(field.equals("student_username")){
            student_username = set;
        }
        if(field.equals("status")){
            status = set;
        }
    }

    //CONSTRUCTORS
    public Enrollment(){} //empty constructor
    public Enrollment(String student_username){ //constructor with student username only
        this.student_username = student_username;
    }
    public Enrollment(String student_username, String status, int quiz_1_score, int quiz_2_score, int quiz_3_score, int assignment_1_score,
                      int assignment_2_score, int assignment_3_score, int prelim_exam_score, int periodical_exam_score,
                      int quiz_1_items, int quiz_2_items, int quiz_3_items, int assignment_1_items, int assignment_2_items,
                      int assignment_3_items, int prelim_exam_items, int periodical_exam_items){ //complete constructor
        this.student_username = student_username;
        this.status = status;
        this.quiz_1_score = quiz_1_score;
        this.quiz_2_score = quiz_2_score;
        this.quiz_3_score = quiz_3_score;
        this.assignment_1_score = assignment_1_score;
        this.assignment_2_score = assignment_2_score;
        this.assignment_3_score = assignment_3_score;
        this.prelim_exam_score = prelim_exam_score;
        this.periodical_exam_score = periodical_exam_score;

        this.quiz_1_items = quiz_1_items;
        this.quiz_2_items = quiz_2_items;
        this.quiz_3_items = quiz_3_items;
        this.assignment_1_items = assignment_1_items;
        this.assignment_2_items = assignment_2_items;
        this.assignment_3_items = assignment_3_items;
        this.prelim_exam_items = prelim_exam_items;
        this.periodical_exam_items = periodical_exam_items;

    }

    //loads a specific section's table from the database
    public void loadData(String tableName){
        ResultSet rs = DBConnection.executeQuery(
                "SELECT * FROM " + tableName + ";"
        );
        try{
            EnrollmentArray.clear();
            while(rs.next()){
                String student_username = rs.getString("student_username");
                String status = rs.getString("status");

                int quiz_1_score = rs.getInt("quiz_1_score");
                int quiz_2_score = rs.getInt("quiz_2_score");
                int quiz_3_score = rs.getInt("quiz_3_score");
                int assignment_1_score = rs.getInt("assignment_1_score");
                int assignment_2_score = rs.getInt("assignment_2_score");
                int assignment_3_score = rs.getInt("assignment_3_score");
                int prelim_exam_score = rs.getInt("prelim_exam_score");
                int periodical_exam_score = rs.getInt("periodical_exam_score");

                int quiz_1_items = rs.getInt("quiz_1_items");
                int quiz_2_items = rs.getInt("quiz_2_items");
                int quiz_3_items = rs.getInt("quiz_3_items");
                int assignment_1_items = rs.getInt("assignment_1_items");
                int assignment_2_items = rs.getInt("assignment_2_items");
                int assignment_3_items = rs.getInt("assignment_3_items");
                int prelim_exam_items = rs.getInt("prelim_exam_items");
                int periodical_exam_items = rs.getInt("periodical_exam_items");

                EnrollmentArray.add(
                        new Enrollment(student_username, status, quiz_1_score, quiz_2_score, quiz_3_score, assignment_1_score,
                                assignment_2_score, assignment_3_score, prelim_exam_score, periodical_exam_score,
                                quiz_1_items, quiz_2_items , quiz_3_items, assignment_1_items, assignment_2_items,
                                assignment_3_items, prelim_exam_items, periodical_exam_items));
            }
        }
        catch(NullPointerException ex){}
        catch(SQLException ex){ ex.printStackTrace(); }
    }

    //adds a student on the database
    public void enroll(Enrollment object, String tableName){
        String sql = String.format(
                "INSERT INTO " + tableName + " (student_username, status) " +
                        "VALUES ('%s', '%s')",
                object.get("student_username"),
                object.get("status")
        );
        DBConnection.executeUpdate(sql);
        loadData(tableName);
    }

    //removes a student in a section
    public void remove(Enrollment object, String tableName){
        String sql = String.format(
                "DELETE FROM " + tableName +
                        " WHERE student_username = '%s'",
                object.get("student_username")
        );
        DBConnection.executeUpdate(sql);
        loadData(tableName);
    }

    //updates the grades of a specific student of a specific table on a database
    public void encodeGrades(int quiz_1_score, int quiz_2_score, int quiz_3_score, int assignment_1_score,
                     int assignment_2_score, int assignment_3_score, int prelim_exam_score, int periodical_exam_score,
                     int quiz_1_items, int quiz_2_items, int quiz_3_items, int assignment_1_items, int assignment_2_items,
                     int assignment_3_items, int prelim_exam_items, int periodical_exam_items, String tableName, String studentUsername){

        String status = null;
        loadData(tableName);

        String sql = String.format(
                "UPDATE " + tableName + " SET " +
                        "quiz_1_score=" + "'" + quiz_1_score + "', " +
                        "quiz_2_score=" + "'" + quiz_2_score + "', " +
                        "quiz_3_score=" + "'" + quiz_3_score + "', " +
                        "assignment_1_score=" + "'" + assignment_1_score + "', " +
                        "assignment_2_score=" + "'" + assignment_2_score + "', " +
                        "assignment_3_score=" + "'" + assignment_3_score + "', " +
                        "prelim_exam_score=" + "'" + prelim_exam_score + "', " +
                        "periodical_exam_score=" + "'" + periodical_exam_score + "', " +
                        "quiz_1_items=" + "'" + quiz_1_items + "', " +
                        "quiz_2_items=" + "'" + quiz_2_items + "', " +
                        "quiz_3_items=" + "'" + quiz_3_items + "', " +
                        "assignment_1_items=" + "'" + assignment_1_items + "', " +
                        "assignment_2_items=" + "'" + assignment_2_items + "', " +
                        "assignment_3_items=" + "'" + assignment_3_items + "', " +
                        "prelim_exam_items=" + "'" + prelim_exam_items + "', " +
                        "periodical_exam_items=" + "'" + periodical_exam_items + "'" +
                        "WHERE student_username =" + "'" + studentUsername + "'"
        );
        DBConnection.executeUpdate(sql);
        loadData(tableName);

        for (int i = 0; i < EnrollmentArray.size(); i++) {
            if(EnrollmentArray.get(i).get("student_username").equals(studentUsername)){
                //checks if all fields have scores
                if(EnrollmentArray.get(i).getInt("quiz_1_score") != 0 && EnrollmentArray.get(i).getInt("quiz_2_score") != 0 && EnrollmentArray.get(i).getInt("quiz_3_score") != 0
                        && EnrollmentArray.get(i).getInt("assignment_1_score") != 0 && EnrollmentArray.get(i).getInt("assignment_2_score") != 0 && EnrollmentArray.get(i).getInt("assignment_3_score") != 0
                        && EnrollmentArray.get(i).getInt("prelim_exam_score") != 0 && EnrollmentArray.get(i).getInt("periodical_exam_score") != 0
                        && EnrollmentArray.get(i).getInt("prelim_exam_items") != 0 && EnrollmentArray.get(i).getInt("periodical_exam_items") != 0
                        && EnrollmentArray.get(i).getInt("quiz_1_items") != 0 && EnrollmentArray.get(i).getInt("quiz_2_items") != 0 && EnrollmentArray.get(i).getInt("quiz_3_items") != 0
                        && EnrollmentArray.get(i).getInt("assignment_1_items") != 0 && EnrollmentArray.get(i).getInt("assignment_2_items") != 0 && EnrollmentArray.get(i).getInt("assignment_3_items") != 0){

                    status = "COMPLETE"; //changes the status to complete

                }
                else{
                    status = "INCOMPLETE"; //changes the status to incomplete
                }

                String sql2 = String.format(
                        "UPDATE " + tableName + " SET " +
                                "status=" + "'" + status + "'" +
                                "WHERE student_username=" + "'" + studentUsername + "'"
                );

                DBConnection.executeUpdate(sql2);
                loadData(tableName);
            }
        }
    }
}