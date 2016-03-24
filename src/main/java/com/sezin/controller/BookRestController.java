package com.sezin.controller;

import com.sezin.model.Book;
import com.sezin.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sezin on 3/23/16.
 */
@RestController
@RequestMapping("/books")
public class BookRestController {

    @Autowired
    BookRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{title}")
    public Book getBookByTitle(@PathVariable String title){
        return repository.findByTitle(title);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author){
        return repository.findByAuthor(author);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Book create(@RequestBody Book book){
        return repository.save(book);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id){
        repository.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Book update(@PathVariable String id, @RequestBody Book book){
        Book updated = repository.findOne(id);
        updated.setAuthor(book.getAuthor());
        updated.setTitle(book.getTitle());
        updated.setYear(book.getyear());
        return repository.save(book);

    }
}
