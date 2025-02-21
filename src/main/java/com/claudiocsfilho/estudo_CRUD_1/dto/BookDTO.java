package com.claudiocsfilho.estudo_CRUD_1.dto;

import com.claudiocsfilho.estudo_CRUD_1.entitites.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class BookDTO {

    private Long id;
    @NotBlank (message = "O campo precisa ser preenchido!")
    private String titulo;
    @NotBlank (message = "O campo precisa ser preenchido!")
    private String autor;
    @PastOrPresent(message = "Insira uma data válida")
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
