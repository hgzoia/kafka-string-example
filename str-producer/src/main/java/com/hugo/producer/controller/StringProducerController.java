package com.hugo.producer.controller;

import com.hugo.producer.service.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class StringProducerController {

    private final StringProducerService service;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message){
        service.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
