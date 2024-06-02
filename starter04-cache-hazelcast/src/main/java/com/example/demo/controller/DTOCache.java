package com.example.demo.controller;

import com.example.demo.domain.Contact;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DTOCache {
    private String token ;
    private List<Contact> contactList ;
}
