/*
MIT License

Copyright (c) 2017 JUAN CALVOPINA M

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.example.demo.service;

import com.example.demo.controller.ContactController;
import com.example.demo.domain.Contact;
import com.example.demo.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by juanca on 5/20/17.
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {

        logger.info("[INFO] call to ContactServiceImpl - findAll xxxx01");
        logger.info("[INFO] call to ContactServiceImpl - findAll xxxx02");
        logger.info("[INFO] call to ContactServiceImpl - findAll xxxx03");
        logger.info("[INFO] call to ContactServiceImpl - findAll xxxx04");
        logger.info("[INFO] call to ContactServiceImpl - findAll xxxx05");
        logger.info("[INFO] call to ContactServiceImpl - findAll xxxx06");
        logger.info("[INFO] call to ContactServiceImpl - findAll xxxx07");

        return contactRepository.findAll();
    }

    @Override
    public Contact find(Long id) {

        logger.info("[INFO] call to ContactServiceImpl - findAll"  , id);

        return contactRepository.getOne(id);
    }

    @Override
    public Contact save(Contact contact) {

        logger.info("[INFO] call to ContactServiceImpl - save"  , contact.toString());

        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Long id, Contact contact) {
        logger.info("[INFO] call to ContactServiceImpl - update"  , contact.toString());
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
        logger.info("[INFO] call to ContactServiceImpl - delete"  , id);

        contactRepository.deleteById(id);
    }

}
