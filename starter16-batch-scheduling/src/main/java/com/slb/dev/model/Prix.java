package com.slb.dev.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Prix")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Prix implements Serializable  {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "source")
    private String source;

    @Column(name = "price-value") // value not permitted
    private float value;

    @Column(name = "devise")
    private String devise;

    @Column(name = "reference")
    private String reference;

    @Column(name = "execution")
    private LocalDateTime execution;

    public Prix(String source, String devise) {
        this.source = source ;
        this.devise = devise ;
    }
}
