
package com.example.demo.service;

import com.example.demo.domain.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    Contact find(Long id);

    Contact save(Contact contact);

    Contact update(Long id, Contact contact);

    void delete(Long id);

}
