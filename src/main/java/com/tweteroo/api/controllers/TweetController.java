package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
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
    public ResponseEntity<String> getAllTweets(@RequestParam(defaultValue = "0") int page){
        int size = 5;
        Pageable filters = PageRequest.of(page, size);
        Page<Tweet> tweets = service.listAll(filters);

        System.out.println(tweets.getContent());

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
