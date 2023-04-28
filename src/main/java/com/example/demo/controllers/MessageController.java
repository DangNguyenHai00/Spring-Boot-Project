package com.example.demo.controllers;

import com.example.demo.services.JmsDispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    JmsDispatcherService dispatcherService;
    @Autowired
    public MessageController(JmsDispatcherService dispatcherService)
    {
        this.dispatcherService = dispatcherService;
    }

    @PostMapping(path="/message",consumes = "application/json")
    public ResponseEntity<String> send(@RequestBody String message)
    {
        dispatcherService.sendMessage(message);
        return new ResponseEntity<String>("Message sent: "+message,HttpStatus.OK);
    }
}
