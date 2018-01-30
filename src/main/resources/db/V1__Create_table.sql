CREATE TABLE IF NOT EXISTS `product`(
    `product_id` INT NOT NULL AUTO_INCREMENT,
    `product_name` VARCHAR(100) NOT NULL,
    `product_unit` VARCHAR(20) NOT NULL,
    `product_price` DECIMAL(9,2) NOT NULL,
    `product_discount` VARCHAR(40),
    PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8