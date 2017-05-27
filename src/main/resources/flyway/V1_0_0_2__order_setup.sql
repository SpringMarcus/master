DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_items;

CREATE TABLE items
(
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  name VARCHAR(400),
  upc VARCHAR(15),
  PRIMARY KEY (id)
);


CREATE TABLE customers
(
  id BIGINT unsigned NOT NULL  AUTO_INCREMENT,
  email VARCHAR(100) NOT NULL,
  name VARCHAR(100),
  address VARCHAR(100),
  city VARCHAR(100),
  state VARCHAR(100),
  zip VARCHAR(100),
  phone VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE orders
(
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  customerId bigint unsigned NOT NULL,
  status VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE order_items
(
  id BIGINT unsigned NOT NULL AUTO_INCREMENT,
  orderId bigint unsigned NOT NULL,
  itemId  bigint unsigned NOT NULL,
  PRIMARY KEY (id)
);


