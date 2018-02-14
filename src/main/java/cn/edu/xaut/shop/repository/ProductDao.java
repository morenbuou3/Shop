package cn.edu.xaut.shop.repository;

import cn.edu.xaut.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long>{
    Product findByBarcode(String barcode);
}
