
package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "s_action")
@Data
public class SAction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "action_verb")
    private String actionVerb;

    @Column(name = "action_description")
    private String actionDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profile")
    @JsonIgnore
    private SProfile profile;

}
