package com.example.library;

import java.util.Date;

public class Book {
    private Author author;
    private Genre genre;
    private String name;
    private boolean isTaken;

    public Book(Author author, Genre genre, Date publishedOn, String name) {
        this.author = author;
        this.genre = genre;
        this.name = name;
        this.isTaken = false;
    }

    public Book() {

    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public boolean isTaken() {
        return isTaken;
    }
    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public void setName(String bookName) {
    }

    public void setGenre(Genre genre) {
    }
}
