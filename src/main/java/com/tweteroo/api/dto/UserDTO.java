package com.tweteroo.api.dto;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(

                @NotBlank String username,

                @URL @NotBlank String avatar) {
}
