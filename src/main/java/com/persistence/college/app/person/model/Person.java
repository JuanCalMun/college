package com.persistence.college.app.person.model;

import com.persistence.college.app.address.model.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PERSON")
public class Person implements Serializable {

    private static final long serialVersionUID = -6580545807873594151L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PER_ID")
    private long id;

    @Column(name = "PER_UUID")
    private UUID uuid;

    @Column(name = "PER_NAME")
    private String name;

    @Column(name = "PER_SURNAME")
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PER_ADR_ID")
    private Address address;
}
