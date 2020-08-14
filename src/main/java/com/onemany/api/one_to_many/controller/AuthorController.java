package com.onemany.api.one_to_many.controller;

import com.onemany.api.one_to_many.model.Author;
import com.onemany.api.one_to_many.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/")
    public String testApi(){
        return "Hello API author using swagger ";
    }
    @GetMapping(value = "/authors")
    public Page<Author> getAuthors(Pageable aPageable){
        return authorService.getListOfAuthors(aPageable);
    }

}