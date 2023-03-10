package com.example.ticket.controller;

import java.time.Duration;

import com.example.ticket.beans.*;
import com.example.ticket.types.userType.*;
import javax.servlet.http.*;
import com.example.ticket.types.jacksonPojos.*;
import com.example.ticket.beans.JacksonMapperComponent;
import com.example.ticket.beans.JwtComponent;
import com.example.ticket.exceptions.AccountException;
import com.example.ticket.types.jacksonPojos.AuthPojo;
import com.example.ticket.types.jacksonPojos.LoginPojo;
import com.example.ticket.types.jacksonPojos.UserPojo;
import com.example.ticket.types.userType.NormalUser;
import com.example.ticket.types.userType.User;
import org.springframework.http.*;
import org.jose4j.lang.JoseException;
import org.springframework.web.bind.annotation.*;
import com.example.ticket.layers.applicationLayer.AccessManagement;
import org.springframework.beans.factory.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;

@RequestMapping("api/account")
@RestController
public class AccountController {

    @Autowired
    @Qualifier("jwtComp")
    private JwtComponent jwt;

    @Autowired
    @Qualifier("jackComp")
    private JacksonMapperComponent jack;

    @Autowired
    private AccessManagement accessManagement;



    @PostMapping("/signup")
    public ResponseEntity<String> signupNewUser(@RequestBody UserPojo pojo, HttpServletResponse resp) throws JsonProcessingException {
        User user = extractUser(pojo);
        AuthPojo object = null;
        String token = null;
        try{
            registerUser(user);
            token = jwt.generateToken(user);
            resp.setHeader("Set-Cookie",
                    generateCookie("mytok", token, Duration.ofMinutes(131400).getSeconds()).toString());
            object = generateAuthPojo(true, "", pojo.getName());
        } catch (AccountException e) {
            object = generateAuthPojo(false, e.getMessage(), "");
        } catch (JoseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(jack.convertToJson(object), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginPojo pojo, HttpServletResponse resp, HttpServletRequest req) throws JsonProcessingException {
        AuthPojo object = null;
        try {
            resp.addHeader("Accept-CH", "Sec-Ch-Ua-Platform-Version");
            User user = loginUser(pojo);
            String token = jwt.generateToken(user);
            resp.setHeader("Set-Cookie",
                    generateCookie("mytok", token, Duration.ofMinutes(131400).getSeconds()).toString());
            object = generateAuthPojo(true, "", user.getName());
        } catch (AccountException | JoseException e) {
            object = generateAuthPojo(false, e.getMessage(), "");
        }
        return new ResponseEntity<>(jack.convertToJson(object), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpServletResponse resp) {
        resp.setHeader("Set-Cookie", generateCookie("mytok", "", 0).toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private User extractUser(UserPojo user){
        return new NormalUser(user.getUsername(), user.getPassword(), user.getEmail(), user.getName());
    }

    private ResponseCookie generateCookie(String cookieName, String token, long age){
        ResponseCookie cookie = ResponseCookie.from(cookieName, token)
                .path("/")
                .httpOnly(true)
                .secure(true)
                .sameSite("None")
                .maxAge(age)
                .build();
        return cookie;
    }

    private AuthPojo generateAuthPojo(boolean flag, String description, String name){
        AuthPojo object = new AuthPojo();
        object.setFlag(flag);
        object.setDescription(description);
        object.setName(name);
        return object;
    }

    private boolean registerUser(User user) throws AccountException {
        return accessManagement.signUp(user.getEmail(), user.getUsername(), user.getPassword(), user.getName());
    }

    private User loginUser(LoginPojo pojo) throws AccountException {
        return accessManagement.login(pojo.getUsername(), pojo.getPassword());
    }
}
