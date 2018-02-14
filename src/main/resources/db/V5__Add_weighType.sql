ALTER TABLE product ADD product_weigh INT NOT NULL COMMENT '称重1/非称重0';
UPDATE product SET product_weigh=0 WHERE product_barcode='ITEM000000';
UPDATE product SET product_weigh=0 WHERE product_barcode='ITEM000001';
UPDATE product SET product_weigh=1 WHERE product_barcode='ITEM000002';
UPDATE product SET product_weigh=1 WHERE product_barcode='ITEM000003';
UPDATE product SET product_weigh=0 WHERE product_barcode='ITEM000004';
UPDATE product SET product_weigh=0 WHERE product_barcode='ITEM000005';