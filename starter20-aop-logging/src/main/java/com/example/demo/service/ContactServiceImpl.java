
package com.example.demo.service;

import com.example.demo.controller.ContactController;
import com.example.demo.domain.Contact;
import com.example.demo.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    private final  ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact find(Long id) {
        return contactRepository.getOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Long id, Contact contact) {
        Optional<Contact> contactToUpdate = contactRepository.findById(id);
        if (contactToUpdate.isPresent()) {
            contactToUpdate.get().setAddress(contact.getAddress());
            contactToUpdate.get().setBirthday(contact.getBirthday());
            contactToUpdate.get().setCompanyName(contact.getCompanyName());
            contactToUpdate.get().setEmail(contact.getEmail());
            contactToUpdate.get().setLastName(contact.getLastName());
            contactToUpdate.get().setName(contact.getName());
            contactToUpdate.get().setNickName(contact.getNickName());
            contactToUpdate.get().setPhoneNumber(contact.getPhoneNumber());
            contactToUpdate.get().setWebSite(contact.getWebSite());
            return contactRepository.save(contactToUpdate.get());
        }
        return null ;
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

}
