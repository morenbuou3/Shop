ALTER TABLE product ADD product_img VARCHAR(20) NOT NULL COMMENT '商品图片';
UPDATE product SET product_img='cola.jpg' WHERE product_barcode='ITEM000000';
UPDATE product SET product_img='sprint.jpg' WHERE product_barcode='ITEM000001';
UPDATE product SET product_img='apple.jpg' WHERE product_barcode='ITEM000002';
UPDATE product SET product_img='litchi.jpg' WHERE product_barcode='ITEM000003';
UPDATE product SET product_img='battery.jpg' WHERE product_barcode='ITEM000004';
UPDATE product SET product_img='noodle.jpg' WHERE product_barcode='ITEM000005';