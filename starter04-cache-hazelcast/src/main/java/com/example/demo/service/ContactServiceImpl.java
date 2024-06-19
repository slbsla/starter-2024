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

import com.example.demo.controller.DTOCache;
import com.example.demo.domain.Contact;
import com.example.demo.repository.ContactRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> findAll(String myToken) throws InterruptedException {
        System.out.println(myToken);
        Thread.sleep(3000);
        return contactRepository.findAll();
    }

    @Cacheable(cacheNames = "contactCache", key = "#myToken")
    @Override
    public DTOCache findAllCached(String myToken) throws InterruptedException {
        DTOCache r = DTOCache.builder().contactList(findAll(myToken)).token(myToken).build();
        return r;
    }

    @Override
    public Contact find(Long id) {
        return contactRepository.getOne(id);
    }

    @Override
    public Contact findByIdUsingCache(Long id) {
        return contactRepository.findCached(id);
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
    public void delete(Long contact) {
        contactRepository.deleteById(contact);
    }
}
