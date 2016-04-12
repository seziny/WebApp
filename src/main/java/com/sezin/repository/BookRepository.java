package com.sezin.repository;

import com.sezin.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by sezin on 3/22/16.
 * Copyright © 2016 Logitech. All rights reserved.
 */

@RepositoryRestResource(collectionResourceRel = "books", path = "books/")
public interface BookRepository extends MongoRepository<Book, String> {

    public Book findByTitle(String title);
    public List<Book> findByAuthor(String author);
    public List<Book> findByUserName(String userName);
}
