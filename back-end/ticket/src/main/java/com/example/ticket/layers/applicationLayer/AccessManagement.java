package com.example.ticket.layers.applicationLayer;

import java.util.*;
import com.example.ticket.beans.UserRepositoryComponent;
import com.example.ticket.exceptions.*;
import com.example.ticket.types.userType.*;
import com.example.ticket.types.permission.*;
import com.example.ticket.repositories.PermissionRepository;
import com.example.ticket.exceptions.*;
import com.example.ticket.types.permission.Permission;
import com.example.ticket.types.userType.NormalUser;
import com.example.ticket.types.userType.User;
import com.example.ticket.types.userType.VipUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessManagement {

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private UserRepositoryComponent userRepository;

    public User login(String inputUser, String inputPass) throws AccountException {
        return isUserInfoValid(inputUser, inputPass);
    }

    public boolean signUp(String email, String username, String password, String name) throws AccountException {
        if (userExists(username, email))
            return false;
        userRepository.saveUser(new NormalUser(username, password, email, name));
        return true;
    }

    public List<Permission> getPermissions(String role){
        return createMenu(role);
    }

    public void upgradeToVip(String username) throws AlreadyUpdatedException {
        User user = userRepository.getUserByUsername(username);
        if (user instanceof VipUser)
            throw new AlreadyUpdatedException();
        User temp = new VipUser(user.getUsername(), user.getPassword(), user.getEmail(), user.getName());
        temp.setId(user.getId());
        userRepository.saveUser(temp);
    }

    public User getUser(String username){
        return userRepository.getUserByUsername(username);
    }

    private boolean userExists(String username, String email) throws AccountException{
        if (userRepository.isUserInsideDatabase(username, email))
            throw new AlreadyRegisteredException();
        return false;
    }

    private User isUserInfoValid(String username, String password) throws AccountException{
        User user = userRepository.getUserByUsername(username);
        if (user == null)
            throw new NotRegisteredException();
        if (user.getPassword().equals(password))
            return user;
        throw new WrongPassException();
    }

    private List<Permission> createMenu(String role){
        List<Permission> options;
        if (role.equals("normal") || role.equals("vip")) {
            options = new ArrayList<>(permissionRepository.findAllByPermissionTypeOrPermissionType(role, "both"));
        }
        else
            options = new ArrayList<>(permissionRepository.findPermissionEntityByPermissionType(role));
        options.removeIf(option -> !option.isAllowed());
        return options;
    }

}
