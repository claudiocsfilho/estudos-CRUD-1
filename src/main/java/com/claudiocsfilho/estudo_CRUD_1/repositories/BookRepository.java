package com.claudiocsfilho.estudo_CRUD_1.repositories;

import com.claudiocsfilho.estudo_CRUD_1.entitites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
