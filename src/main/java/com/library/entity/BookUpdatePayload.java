package com.library.entity;

public class BookUpdatePayload {
    private String title;
    private String author;
    private int year;
    private String isbn;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }
}
