
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Employees implements Comparable<Employees>{
    private String ID;
    private String Name;
    private int Level;

    public Employees() {
    }

    public Employees(String ID, String Name, int Level) {
        this.ID = ID;
        this.Name = Name;
        this.Level = Level;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }
    
    @Override
    public String toString() {
        return String.format("%s", ID) + ", " + String.format("%s", Name) + ", " + String.format("%d", Level) + "\n";
    }
    @Override
    public int compareTo(Employees o) {
        return this.ID.compareTo(o.ID);
    }
}
