
CREATE SCHEMA IF NOT EXISTS product;
CREATE SEQUENCE IF NOT EXISTS category_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS product_seq INCREMENT BY 50;


CREATE TABLE IF NOT EXISTS product.category (
    id BIGSERIAL  PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product.product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    available_quantity DOUBLE PRECISION NOT NULL,
    price NUMERIC(38, 2),
    category_id BIGINT,
    CONSTRAINT fk_category
        FOREIGN KEY (category_id) REFERENCES  product.category(id)
);
