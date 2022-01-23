DROP TABLE IF EXISTS currencies;
CREATE TABLE currencies(
    num_code integer PRIMARY KEY,
    char_code VARCHAR(6),
    name VARCHAR(60)
);
