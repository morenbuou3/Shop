package cn.edu.xaut.shop.controller;

import cn.edu.xaut.shop.entity.Product;
import cn.edu.xaut.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShopController {
    @Autowired
    ShopService shopService;

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    // 查询商品列表
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return shopService.getProductList();
    }

    // 返回指定格式发票
    @RequestMapping(value = "/receipts", method = RequestMethod.POST)
    public Map<String, Object> getReceipt(@RequestBody String[] items) {
        Map<String, Object> result = new HashMap<>();
        double subTotal = shopService.getDiscount(items);
        result.put("products", shopService.getReceiptItem(items));
        result.put("total", subTotal);
        result.put("dec", shopService.getTotal(items) - subTotal);
        return result;
    }
}
