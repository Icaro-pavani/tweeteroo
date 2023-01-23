package com.tweteroo.api.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    public void create(TweetDTO data) {
        User user = userRepository.findByUsername(data.username());
        Tweet tweet = new Tweet(data, user.getAvatar());
        tweetRepository.save(tweet);
    }

    public Page<Tweet> listAll(Pageable page) {
        return tweetRepository.findAll(page);
    }

}
