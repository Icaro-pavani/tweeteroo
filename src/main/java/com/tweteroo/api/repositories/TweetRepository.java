package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, String> {

}
