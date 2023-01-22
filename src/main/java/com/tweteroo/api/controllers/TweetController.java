package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private TweetService service;
    
    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid TweetDTO req) {
        service.create(req);

        return new ResponseEntity<String>("OK", HttpStatus.CREATED);
        
    }

    @GetMapping
    public ResponseEntity<List<Tweet>> listAll() {
        return ResponseEntity.ok().body(service.listAll());
    }
}
