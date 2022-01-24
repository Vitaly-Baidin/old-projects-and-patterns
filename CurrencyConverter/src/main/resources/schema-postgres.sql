DROP TABLE IF EXISTS currencies CASCADE;
CREATE TABLE currencies(
    num_code INTEGER PRIMARY KEY,
    char_code VARCHAR(6),
    name VARCHAR(60)
);
DROP TABLE IF EXISTS rates CASCADE;
CREATE TABLE rates(
    date_currency DATE,
    num_code_currencies INTEGER,
    rate_currency DECIMAL,
    PRIMARY KEY(date_currency, rate_currency),
    FOREIGN KEY(num_code_currencies) REFERENCES currencies(num_code) ON DELETE CASCADE
);
