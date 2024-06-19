package com.example.demo.controller;

import com.example.demo.domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DTOCache implements Serializable {
    private String token ;
    private List<Contact> contactList ;
}
