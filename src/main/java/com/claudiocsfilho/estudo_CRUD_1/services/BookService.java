package com.claudiocsfilho.estudo_CRUD_1.services;

import com.claudiocsfilho.estudo_CRUD_1.dto.BookDTO;
import com.claudiocsfilho.estudo_CRUD_1.entitites.Book;
import com.claudiocsfilho.estudo_CRUD_1.repositories.BookRepository;
import com.claudiocsfilho.estudo_CRUD_1.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Transactional(readOnly = true)
    public BookDTO findById (Long id){
        Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
        return new BookDTO(book);
    }

    @Transactional(readOnly = true)
    public Page<BookDTO> findAll (Pageable pageable){
        Page<Book> result = repository.findAll(pageable);
        return result.map(x -> new BookDTO(x));
    }
}
