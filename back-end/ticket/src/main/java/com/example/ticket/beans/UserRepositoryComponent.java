package com.example.ticket.beans;

import com.example.ticket.types.userType.*;
import com.example.ticket.repositories.UserRepository;
import com.example.ticket.types.userType.User;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserRepositoryComponent {
    @Autowired
    private UserRepository repository;

    public UserRepositoryComponent(){}

    public void saveUser(User user){
        repository.save(user);
    }

    public boolean isUserInsideDatabase(String username, String email){
     return repository.countByUsernameAndEmail(username, email) == 1;
    }

    public User getUserByUsername(String username){
        return repository.getFirstByUsername(username);
    }
}
