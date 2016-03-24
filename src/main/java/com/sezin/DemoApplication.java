package com.sezin;

import com.sezin.model.Book;
import com.sezin.model.UserAccount;
import com.sezin.repository.BookRepository;
import com.sezin.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.*;

/**
 * Created by sezin on 3/23/16.
 */

@SpringBootApplication
@RestController
@ComponentScan
public class DemoApplication {

    @Autowired
    private BookRepository bookRepository;


    @RequestMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(final UserAccountRepository userAccountRepository) {

        return new CommandLineRunner() {

            @Override
            public void run(String... arg0) throws Exception {
                /*Book b = new Book("book", "yazar", 1990);
                List<Book> bookList = new ArrayList<>();
                bookList.add(b);
                userAccountRepository.save(new UserAccount("seziny", "new", bookList));*/

            }

        };

    }





}
