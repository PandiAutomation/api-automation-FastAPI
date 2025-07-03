package com.jktech.models;

public class CreateBookRequest {
    private int id;
    private String name;
    private String author;
    private int published_year;
    private String book_summary;

    public CreateBookRequest(int id, String name, String author, int published_year,String book_summary) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.published_year = published_year;
        this.book_summary = book_summary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
    
    public int getpublished_year() {
        return published_year;
    }
    
    public String getbook_summary() {
        return book_summary;
    }

}
