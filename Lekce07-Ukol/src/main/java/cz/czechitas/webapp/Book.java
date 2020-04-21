
package cz.czechitas.webapp;

public class Book {
    Long keyNumber;
    String author;
    String title;
    String detail;

    public Book(){

    }

    public Book(Long keyNumber, String author, String title, String detail) {
        this.keyNumber = keyNumber;
        this.author = author;
        this.title = title;
        this.detail=detail;
    }

    public Long getKeyNumber() {
        return keyNumber;
    }

    public void setKeyNumber(Long newValue) {
        keyNumber = newValue;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newValue) {
        author = newValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newValue) {
        title = newValue;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String newValue) {
        detail = newValue;
    }
}
