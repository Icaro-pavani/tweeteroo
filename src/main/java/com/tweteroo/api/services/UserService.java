package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> listAll() {
        return repository.findAll();
    }

    public void save(UserDTO data) {
        User registeredUser = repository.findByUsername(data.username());

        if (registeredUser == null) {
            repository.save(new User(data));
        } else {
            repository.findById(registeredUser.getId()).map(user -> {
                user.setAvatar(data.avatar());
                user.setUsername(data.username());
                
                return repository.save(user);
            });
        }
    }
    
}
