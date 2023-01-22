package com.tweteroo.api.dto;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(

        @NotBlank String username,

        @URL @NotBlank String avatar,

        @NotBlank String text) {
}
