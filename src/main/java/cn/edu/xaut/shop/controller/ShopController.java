package cn.edu.xaut.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

}
