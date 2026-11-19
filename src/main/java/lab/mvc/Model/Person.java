package lab.mvc.Model;

import java.io.Serializable;

public class Person implements Serializable {

    public String lastname;
    public String firstname;
    public String birthday;
    public String sexe;

    public Person(String lastname, String firstname, String birthday, String sexe) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.sexe = sexe;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
