
package com.example.demo.domain;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "CONTACT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "NICK_NAME")
    private String nickName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "WEB_SITE")
    private String webSite;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return new EqualsBuilder()
                .append(id, contact.id)
                .append(name, contact.name)
                .append(lastName, contact.lastName)
                .append(nickName, contact.nickName)
                .append(phoneNumber, contact.phoneNumber)
                .append(email, contact.email)
                .append(address, contact.address)
                .append(birthday, contact.birthday)
                .append(companyName, contact.companyName)
                .append(webSite, contact.webSite)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(lastName)
                .append(nickName)
                .append(phoneNumber)
                .append(email)
                .append(address)
                .append(birthday)
                .append(companyName)
                .append(webSite)
                .toHashCode();
    }

}
