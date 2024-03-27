INSERT INTO product(name, description, target_market)
VALUES ('Smartphone', 'Computador de bolso que pode ser levado para qualquer lugar', 'Qualquer pessoa');

INSERT INTO tag(name)
VALUES ('Tecnologia');

INSERT INTO product_tag(product_id, tag_id)
VALUES (1, 1);