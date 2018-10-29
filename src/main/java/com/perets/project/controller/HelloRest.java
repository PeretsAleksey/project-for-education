package com.perets.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello from Spring", HttpStatus.OK);
    }
}
