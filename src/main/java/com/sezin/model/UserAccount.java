package com.sezin.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sezin on 3/23/16.
 * Copyright © 2016 Logitech. All rights reserved.
 */
public class UserAccount {

    @Id
    private String id;
    private String username;
    private String password;

    private List<Book> books;

    public UserAccount(){}

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserAccount(String username, String password, List<Book> books) {
        this.username = username;
        this.password = password;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public boolean addBooks(List<Book> books, Book book){
        if(books == null){
            books = new ArrayList<>();
            setBooks(books);
            return books.add(book);
        }
        return books.add(book);
    }

    public void removeBooks(List<Book> books, Book book){
        if(books == null || books.isEmpty()) {
           return;
        }
        books.remove(book);
    }
}
