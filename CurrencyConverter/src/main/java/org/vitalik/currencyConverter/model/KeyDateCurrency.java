package org.vitalik.currencyConverter.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

@Data
@Embeddable
public class KeyDateCurrency implements Serializable {
    @Column(name = "date_currency")
    private Date date;
    @Column(name = "num_code_currencies")
    private int numCodeCurrencies;

    public KeyDateCurrency() {
    }

    public KeyDateCurrency(Date date, int numCodeCurrencies) {
        this.date = date;
        this.numCodeCurrencies = numCodeCurrencies;
    }
}