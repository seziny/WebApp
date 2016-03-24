package com.sezin.controller;

import com.sezin.model.Book;
import com.sezin.model.UserAccount;
import com.sezin.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sezin on 3/23/16.
 */

@RestController
@RequestMapping("/account")
public class UserRestController {

    @Autowired
    UserAccountRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public UserAccount create(@RequestBody UserAccount userAccount){
        return repository.save(userAccount);
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "{username}")
    public UserAccount get(@PathVariable String username){
        return repository.findByUsername(username);
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "{username}")
    public List<Book> getListOfBooks(@PathVariable String username){
        UserAccount userAccount = repository.findByUsername(username);
        if(userAccount != null) {
            return userAccount.getBooks();
        }
        else
            return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{username}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public UserAccount addBook(@PathVariable String username, @RequestBody Book book){
        UserAccount updated = repository.findByUsername(username);
        updated.addBooks(updated.getBooks(), book);
        return repository.save(updated);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{username}")
    public void deleteBook(@PathVariable String username, @RequestBody Book book){
        UserAccount updated = repository.findByUsername(username);
        updated.removeBooks(updated.getBooks(), book);
        repository.save(updated);
    }


}
