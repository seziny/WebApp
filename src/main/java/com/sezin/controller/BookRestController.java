package com.sezin.controller;

import com.sezin.model.Book;
import com.sezin.repository.BookRepository;
import com.sezin.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import java.util.List;

/**
 * Created by sezin on 3/23/16.
 */
@RestController
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    BookRepository repository;

    @Autowired
    UserAccountRepository userAccountRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    @RequestMapping(value = "/getByTitle/{title}", method = RequestMethod.GET)
    public Book getBookByTitle(@PathVariable String title){
        return repository.findByTitle(title);
    }

    @RequestMapping(value = "/getByAuthor/{author}", method = RequestMethod.GET)
    public List<Book> getBooksByAuthor(@PathVariable String author){
        return repository.findByAuthor(author);
    }

    @RequestMapping(value ="/getAll/{userName}", method = RequestMethod.GET)
    public List<Book> getBooksByUserName(@PathVariable String userName){
        return repository.findByUserName(userName);
    }


    @RequestMapping(value ="/add", method = RequestMethod.POST)
    public @ResponseBody Book create(@RequestBody Book book){
        if( userAccountRepository.findByUsername(book.getUserName()) != null &&
                repository.findByTitle(book.getTitle()) == null){
            return repository.save(book);
        }
        else
            return null;

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
