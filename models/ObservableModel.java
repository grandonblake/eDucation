package models;

import java.util.Observable;

//PARENT CLASS OF Student, Instructor, and Enrollment
public class ObservableModel extends Observable {

    public void changed(){
        setChanged(); //sets changes
        notifyObservers(); //notifies observers and runs the update method on the observer
    }

}