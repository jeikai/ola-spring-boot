-- =====================================
-- E-COMMERCE DATABASE
-- Compatible: MySQL / MariaDB
-- =====================================

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

SET NAMES utf8mb4;

-- =====================================
-- DATABASE
-- =====================================
CREATE DATABASE IF NOT EXISTS ecommerce_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE ecommerce_db;

-- =====================================
-- TABLE: customers
-- =====================================
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_email VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    password VARCHAR(255),
    address VARCHAR(255),
    postcode VARCHAR(20),
    city VARCHAR(50),
    phone VARCHAR(20)
) ENGINE=InnoDB;

-- =====================================
-- TABLE: categories
-- =====================================
CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,
    category_image VARCHAR(255),
    category_description TEXT
) ENGINE=InnoDB;

-- =====================================
-- TABLE: products
-- =====================================
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    product_desc TEXT,
    image1 VARCHAR(255),
    image2 VARCHAR(255),
    image3 VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    stock INT DEFAULT 0,
    category_id INT,
    CONSTRAINT fk_product_category
        FOREIGN KEY (category_id)
        REFERENCES categories(category_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
) ENGINE=InnoDB;

-- =====================================
-- TABLE: orders
-- =====================================
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    order_no VARCHAR(50) NOT NULL,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    order_total DECIMAL(10,2),
    customer_id INT,
    shipping_date DATETIME,
    is_delivered BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_order_customer
        FOREIGN KEY (customer_id)
        REFERENCES customers(customer_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB;

-- =====================================
-- TABLE: order_details
-- =====================================
CREATE TABLE order_details (
    order_details_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    product_qty INT NOT NULL,
    product_price DECIMAL(10,2) NOT NULL,
    order_id INT,
    subtotal DECIMAL(10,2),
    CONSTRAINT fk_od_order
        FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_od_product
        FOREIGN KEY (product_id)
        REFERENCES products(product_id)
        ON UPDATE CASCADE
) ENGINE=InnoDB;