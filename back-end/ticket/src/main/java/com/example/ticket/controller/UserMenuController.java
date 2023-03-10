package com.example.ticket.controller;

import com.example.ticket.beans.JacksonMapperComponent;
import com.example.ticket.beans.JwtComponent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.example.ticket.layers.applicationLayer.AccessManagement;
import com.example.ticket.types.userType.User;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

@RequestMapping("/api/user")
@RestController
public class UserMenuController {

    @Autowired
    @Qualifier("jwtComp")
    private JwtComponent jwt;

    @Autowired
    @Qualifier("jackComp")
    private JacksonMapperComponent jack;

    @Autowired
    private AccessManagement accessManagement;

    @GetMapping("/menu")
    public ResponseEntity<String> sendUserPermissions(HttpServletRequest request, @CookieValue(name = "mytok") String token) throws JsonProcessingException {
        String role = jwt.getRole(token);
        System.out.println(accessManagement.getPermissions(role));
        String perms = jack.convertToJson(accessManagement.getPermissions(role));
        return new ResponseEntity<>(perms, HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<String> getUserInfo(@CookieValue(name = "mytok") String token) throws JsonProcessingException {
        String username = jwt.getUsername(token);
        User myUser = accessManagement.getUser(username);
        return new ResponseEntity<>(jack.convertToJson(myUser), HttpStatus.OK);
    }
}
