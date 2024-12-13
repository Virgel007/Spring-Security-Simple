package com.news.springboot.controllers;

import com.news.springboot.entity.Author;
import com.news.springboot.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/home")
@RestController
@RequiredArgsConstructor
public class PublicController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> allAuthors = authorService.getAll();
        if (allAuthors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allAuthors);
        }
        return ResponseEntity.ok(allAuthors);
    }
}
