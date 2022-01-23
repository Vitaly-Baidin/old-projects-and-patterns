package org.vitalik.currencyConverter.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "num_code")
    private int numCode;

    @Column(name = "char_code")
    private String charCode;
    private String name;

    public Currency() {
    }

    public Currency(int numCode, String charCode, String name) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.name = name;
    }

}
