package cz.czechitas.webapp;

import java.util.*;

public class RegistrationForm {
    String firstName;
    String lastName;
    String email;
    String job;
    String bio;
    String gender;
    Date date;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newValue) {
        firstName = newValue;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newValue) {
        lastName = newValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newValue) {
        email = newValue;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String newValue) {
        job = newValue;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String newValue) {
        bio = newValue;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String newValue) {
        gender = newValue;
    }

    public Date getDate() {
        date = Calendar.getInstance().getTime();
        return date;
    }

    public void setDate(Date newValue) {
        date = newValue;
    }
}
