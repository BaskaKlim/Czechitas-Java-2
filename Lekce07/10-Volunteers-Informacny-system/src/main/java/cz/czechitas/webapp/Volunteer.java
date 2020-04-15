package cz.czechitas.webapp;

import java.awt.*;
import java.util.*;


public class Volunteer {
    //variables
    String firstName;
    String lastName;
    String fullName;
    String name;
    String email;
    String job;
    String bio;
    String gender;
    String  date;

    public Volunteer(){

    }
    
    public Volunteer(String firstName, String lastName, String email, String job, String bio, String gender, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.job = job;
        this.bio = bio;
        this.gender = gender;
        this.date = date;
    }

    //getters and setters - properties (vlastnosti)
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

    public String getFullName() {
        fullName= firstName + " " +lastName;
        return fullName;
    }

    public void setFullName(String newValue) {
        fullName = newValue;
    }

    public String getName() {
        name = firstName+lastName;
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
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

    public String getDate() {
        return date;
    }

    public void setDate(String newValue) {
        date = newValue;
    }

}
