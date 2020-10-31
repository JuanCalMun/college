package com.persistence.college.app.address.model;

import com.persistence.college.app.shared.model.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ADDRESS")
public class Address extends EntityBase implements Serializable {

    private static final long serialVersionUID = 469871668042811114L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADD_ID")
    private long id;

    @Column(name = "ADR_COUNTRY")
    private String country;

    @Column(name = "ADR_STREET")
    private String street;

    @Column(name = "ADR_NUMBER")
    private int number;

    @Column(name = "ADR_POSTALCODE")
    private int postalcode;

}
