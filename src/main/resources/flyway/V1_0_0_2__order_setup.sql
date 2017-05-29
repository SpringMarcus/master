DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_items;

CREATE TABLE product
(
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  name VARCHAR(400),
  part_number VARCHAR(50),
  upc VARCHAR(50),
  sku VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE customer
(
  id BIGINT unsigned NOT NULL  AUTO_INCREMENT,
  email VARCHAR(100) NOT NULL,
  name VARCHAR(100),
  address_id bigint unsigned NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE orders
(
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  attributes_id bigint unsigned NOT NULL,
  customer_id bigint unsigned NOT NULL,
  order_status VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE shipment
(
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  order_id bigint unsigned NOT NULL,
  attributes_id bigint unsigned NOT NULL,
  shipment_status VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE order_item_group
(
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  shipment_id   bigint unsigned NOT NULL,
  attributes_id bigint unsigned NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE order_item
(
  id BIGINT unsigned NOT NULL AUTO_INCREMENT,
  product_id          bigint unsigned NOT NULL,
  order_item_group_id bigint unsigned NOT NULL,
  attributes_id       bigint unsigned NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE attributes
(
  id BIGINT unsigned NOT NULL AUTO_INCREMENT,
  splittable        tinyint(1) DEFAULT NULL,
  to_address_id     bigint unsigned NOT NULL,
  from_address_id   bigint unsigned NOT NULL,
  return_address_id bigint unsigned NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE address
(
  id BIGINT unsigned NOT NULL AUTO_INCREMENT,
  address_1 VARCHAR(100),
  address_2 VARCHAR(100),
  address_3 VARCHAR(100),
  city      VARCHAR(50),
  state     VARCHAR(50),
  country_code VARCHAR(2),
  PRIMARY KEY (id)
);
