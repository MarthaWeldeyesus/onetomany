package com.onemany.api.one_to_many.repository;

import com.onemany.api.one_to_many.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    
}