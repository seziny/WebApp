package com.sezin.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by sezin on 3/23/16.
 */
public class Book {

    @Id
    private String id;

    @NotNull
    @Size(min=1, max=100)
    private String title;

    private String author;

    @Min(0)
    @Max(9999)
    private int year;

    private String userId;
    private String userName;


    public Book() {
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getyear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%s, author='%s', title='%s']",
                id, author, title);
    }

    public void setId(String bookId) {
        this.id = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
