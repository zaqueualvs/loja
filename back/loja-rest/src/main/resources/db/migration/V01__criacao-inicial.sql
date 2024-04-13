CREATE TABLE product
(
    id            BIGINT      NOT NULL AUTO_INCREMENT,
    name          VARCHAR(20) NOT NULL,
    description   VARCHAR(100) NOT NULL,
    target_market VARCHAR(40) NOT NULL,

    primary key (id)
);

CREATE TABLE tag
(
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,

    primary key (id)
);

CREATE TABLE product_tag
(
    product_id BIGINT,
    tag_id     BIGINT,

    CONSTRAINT fk_product_tag_product
        FOREIGN KEY (product_id)
            REFERENCES product (id),
    CONSTRAINT fk_product_tag_tag
        FOREIGN KEY (tag_id)
            REFERENCES tag (id)

);