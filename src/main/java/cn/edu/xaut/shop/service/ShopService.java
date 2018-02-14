package cn.edu.xaut.shop.service;

import cn.edu.xaut.shop.entity.Product;

import java.util.List;
import java.util.Map;

public interface ShopService {
    List<Product> getProductList();
    double getTotal(String[] items);
    double getDiscount(String[] items);
    List<Map<String, String>> getReceiptItem(String[] items);
}
