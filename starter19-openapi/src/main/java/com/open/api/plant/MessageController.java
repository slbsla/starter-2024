package com.open.api.plant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
    @GetMapping("/messages")
    public String getMessage() {
        return "Hello !";
    }
}