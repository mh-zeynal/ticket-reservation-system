package com.example.ticket.layers.applicationLayer;

import java.util.*;
import com.example.ticket.model.entity.Customer;
import com.example.ticket.model.entity.User;
import com.example.ticket.model.entity.UserWithPermissions;
import com.example.ticket.exception.*;
import com.example.ticket.repository.CustomerRepository;
import com.example.ticket.repository.UserRepository;
import com.example.ticket.repository.UserWithPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessManagement {

    @Autowired
    private UserWithPermissionRepository userWithPermissionRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public User login(String inputUser, String inputPass) throws AccountException {
        return isUserInfoValid(inputUser, inputPass);
    }

    public boolean signUp(String email, String username, String password, String name) throws AccountException {
        if (userExists(username, email))
            return false;
        User newUser = new User(username, password, email, "customer", name);
        userRepository.save(newUser);
        return true;
    }

    public List<UserWithPermissions> getPermissions(String username){
        return userWithPermissionRepository.getAllByUserUsername(username);
    }

    public void upgradeToVip(String username) throws AlreadyUpdatedException {
        Customer customer = customerRepository.getCustomerByUserUsername(username);
        if (customer.isVIP())
            throw new AlreadyUpdatedException();
        customer.setVIP(true);
        customerRepository.save(customer);
    }

    public User getUser(String username){
        return userRepository.getFirstByUsername(username);
    }

    private boolean userExists(String username, String email) throws AccountException{
        if (userRepository.countByUsernameAndEmail(username, email) != 0)
            throw new AlreadyRegisteredException();
        return false;
    }

    private User isUserInfoValid(String username, String password) throws AccountException{
        User user = userRepository.getFirstByUsername(username);
        if (user == null)
            throw new NotRegisteredException();
        if (user.getPassword().equals(password))
            return user;
        throw new WrongPassException();
    }

}
