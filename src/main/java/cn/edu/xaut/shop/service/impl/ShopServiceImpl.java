package cn.edu.xaut.shop.service.impl;

import cn.edu.xaut.shop.entity.Product;
import cn.edu.xaut.shop.repository.ProductDao;
import cn.edu.xaut.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ProductDao productDao;

    public List<Product> getProductList() {
        return productDao.findAll();
    }

    // 计算购物车总价
    public double getTotal(String[] items) {
        Product product;
        double total = 0;
        for (String item : items) {
            product = getProduct(item);
            Integer number = getWeighNumer(item);
            total += product.getPrice() * number;
        }
        return total;
    }

    // 计算优惠后总价
    public double getDiscount(String[] items) {
        double total = 0;
        Map<Long, Integer> map = getMerge(items);
        for (Long id : map.keySet()) {
            Product product = productDao.findOne(id);
            total += getSubTotal(product, map.get(id));
        }
        return total;
    }

    // 返回指定格式商品信息
    public List<Map<String, String>> getReceiptItem(String[] items) {
        List<Map<String, String>> result = new ArrayList<>();
        Map<Long, Integer> map = getMerge(items);
        for (Long id : map.keySet()) {
            Product product = productDao.findOne(id);
            Map<String, String> item = new LinkedHashMap<>();
            item.put("name", product.getName());
            item.put("number", map.get(id) + product.getUnit());
            item.put("price", product.getPrice() + "（元）");
            item.put("subTotal", getSubTotal(product, map.get(id)) + "（元）");
            item.put("weigh", product.getWeigh() + "");
            result.add(item);
        }
        return result;
    }

    // 计算每个商品价格（含优惠）
    private double getSubTotal(Product product, int number) {
        double subTotal = 0;
        if ("BUY_TWO_GET_ONE_FREE".equals(product.getDiscount())) {
            int discount = number / 3;
            subTotal = product.getPrice() * (number - discount);
        } else {
            subTotal = product.getPrice() * number;
        }
        return subTotal;
    }

    // 合并购物车同类项
    private Map<Long, Integer> getMerge(String[] items) {
        Map<Long, Integer> map = new HashMap<>();
        Product product;
        Integer number;
        for (String item : items) {
            product = getProduct(item);
            number = getWeighNumer(item);
            if (map.containsKey(product.getId())) {
                map.put(product.getId(), map.get(product.getId()) + number);
            }
            else {
                map.put(product.getId(), number);
            }
        }
        return map;
    }

    // 查询指定商品
    private Product getProduct(String item) {
        Product product;
        int index = item.indexOf('-');
        if (index > 0) {
            String itemBarcode = item.substring(0, index);
            product = productDao.findByBarcode(itemBarcode);
        } else {
            product = productDao.findByBarcode(item);
        }
        return product;
    }

    // 查询称重物品重量
    private Integer getWeighNumer(String item) {
        Integer number = 1;
        int index = item.indexOf('-');
        if (index > 0) {
            number = Integer.parseInt(item.substring(index + 1));
        }
        return number;
    }
}
