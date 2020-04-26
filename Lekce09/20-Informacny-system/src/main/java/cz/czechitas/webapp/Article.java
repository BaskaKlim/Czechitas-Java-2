package cz.czechitas.webapp;

import java.time.*;

public class Article {

    private Long number;
    private String title;
    private String author;
    private LocalDate date;


    public Article( String title, String author, LocalDate date) {
        this.title = title;
        this.author = author;
        this.date = date;
    }

    //full constructor
    public Article(Long number, String title, String author, LocalDate date) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate newValue) {
        date = newValue;
    }
}
