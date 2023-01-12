import controllers.SignInController;
import models.Instructor;
import models.Student;

public class Main {
    public static void main(String[] args) {
        new Student().loadData();
        new Instructor().loadData();
        new SignInController();
    }
}