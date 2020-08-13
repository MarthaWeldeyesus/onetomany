package com.onemany.api.one_to_many.service;

import com.onemany.api.one_to_many.model.Author;
import com.onemany.api.one_to_many.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    

    @Autowired
    private AuthorRepository authorRepository;

    public Page<Author> getListOfAuthors(Pageable pageable){
        return authorRepository.findAll(pageable);
    }
}