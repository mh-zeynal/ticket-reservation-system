package com.example.ticket.beans;

import com.example.ticket.exceptions.AccountException;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
@Component
public class LoggerComponent {

    private Logger accountLogger = LoggerFactory.getLogger(AccountException.class);

    @AfterThrowing(value = "execution(* com.example.ticket..layers.applicationLayer.AccessManagement.*(..))", throwing = "e")
    public void logAccountExceptions(AccountException e) {
        accountLogger.debug(e.getMessage());
    }
}
