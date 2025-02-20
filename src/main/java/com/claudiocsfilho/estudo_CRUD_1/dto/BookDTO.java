package com.claudiocsfilho.estudo_CRUD_1.dto;

import com.claudiocsfilho.estudo_CRUD_1.entitites.Book;

import java.time.LocalDate;

public class BookDTO {

    private Long id;
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private String isbn;

    public BookDTO(){}

    public BookDTO(Long id, String titulo, String autor, LocalDate dataPublicacao, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
    }

    public BookDTO(Book entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        autor = entity.getAutor();
        dataPublicacao = entity.getDataPublicacao();
        isbn = entity.getIsbn();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }
}
