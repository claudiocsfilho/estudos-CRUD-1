package com.claudiocsfilho.estudo_CRUD_1.controllers;

import com.claudiocsfilho.estudo_CRUD_1.dto.BookDTO;
import com.claudiocsfilho.estudo_CRUD_1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> findById (@PathVariable Long id){
        BookDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<BookDTO>> findAll (Pageable pageable){
        Page<BookDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

}
