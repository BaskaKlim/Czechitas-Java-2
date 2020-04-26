package cz.czechitas.webapp;

import java.time.*;

public class Article {

    private Long number;
    private String title;
    private String author;



    public Article( String title, String author) {
        this.title = title;
        this.author = author;

    }

    //full constructor
    public Article(Long number, String title, String author) {
        this.number = number;
        this.title = title;
        this.author = author;
    }

    //Getters and setters for accessing to variables
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long newValue) {
        number = newValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newValue) {
        title = newValue;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newValue) {
        author = newValue;
    }


}
