package com.tweteroo.api.model;

import com.tweteroo.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {

    public User(UserDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();

    }

    @Column(length = 50, nullable = false)
    private String username;

    @Column(nullable = false)
    private String avatar;
}
