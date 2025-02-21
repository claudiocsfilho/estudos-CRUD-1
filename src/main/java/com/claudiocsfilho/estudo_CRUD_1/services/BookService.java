package com.claudiocsfilho.estudo_CRUD_1.services;

import com.claudiocsfilho.estudo_CRUD_1.dto.BookDTO;
import com.claudiocsfilho.estudo_CRUD_1.entitites.Book;
import com.claudiocsfilho.estudo_CRUD_1.repositories.BookRepository;
import com.claudiocsfilho.estudo_CRUD_1.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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

    @Transactional
    public BookDTO insert(BookDTO dto){
        Book book = new Book();
        copyDtoToEntity(dto, book);
        book = repository.save(book);
        return new BookDTO(book);
    }

    @Transactional
    public BookDTO update (Long id, BookDTO dto){
        try {
            Book book = repository.getReferenceById(id);
            copyDtoToEntity(dto, book);
            book = repository.save(book);
            return new BookDTO(book);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }

    @Transactional
    public void delete (Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Id não encontrado");
        }
        repository.deleteById(id);
    }



    //Metodo auxiliar para copiar DTO para Entity
    private void copyDtoToEntity (BookDTO dto, Book entity){
        entity.setTitulo(dto.getTitulo());
        entity.setAutor(dto.getAutor());
        entity.setDataPublicacao(dto.getDataPublicacao());
        entity.setIsbn(dto.getIsbn());
    }
}
