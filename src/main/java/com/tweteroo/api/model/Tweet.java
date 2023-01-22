package com.tweteroo.api.model;

import com.tweteroo.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

    public Tweet(TweetDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
        this.text = data.text();
    }

    @Column(length = 50, nullable = false)
    private String username;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private String text;

}
