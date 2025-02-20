package com.claudiocsfilho.estudo_CRUD_1.services;

import com.claudiocsfilho.estudo_CRUD_1.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;


}
