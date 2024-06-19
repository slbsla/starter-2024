
package com.example.demo.repository;

import com.example.demo.domain.Contact;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Cacheable(value = "serviceCache", key = "#id")
    @Query("select contact from Contact contact where contact.id =:id")
    Contact findCached(@Param("id") Long id);
}
