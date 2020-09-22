package com.minkhantkyaw;

public class Book {
    private int ID;
    private String title;
    private String author;
    private String genre;
    private boolean availability;
    private boolean isHold;
    private Integer patronID;

    public Book(int ID, String title, String author, String genre) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = true;
        this.isHold = false;
        this.patronID = null;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPatronID() {
        return patronID;
    }

    public boolean isAvailability() {
        return availability;
    }

    public boolean isHold() {
        return isHold;
    }

    public void holdBook(int patronID) {
        this.patronID = patronID;
        this.isHold = true;
    }

    public void borrowBook(int patronID) {
        this.patronID = patronID;
        this.availability = false;
    }

    public void returnBook() {
        this.patronID = null;
        this.availability = false;
    }

}
