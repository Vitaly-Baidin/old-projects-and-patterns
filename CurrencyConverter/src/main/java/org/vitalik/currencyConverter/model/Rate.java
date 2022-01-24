package org.vitalik.currencyConverter.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "rates")
public class Rate {
    @EmbeddedId
    private KeyDateCurrency id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "num_code", insertable = false, updatable = false)
    private Currency numCodeCurrencies;

    @Column(name = "rate_currency")
    private double value;

    public Rate() {

    }

    public Rate(Date date, int numCodeCurrencies, double value) {
        this.id = new KeyDateCurrency(date, numCodeCurrencies);
        this.value = value;
    }
}
