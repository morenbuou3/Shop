package cn.edu.xaut.shop;

import cn.edu.xaut.shop.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class ShopApplicationTests {
    @Autowired
    ShopService shopService;

    @Test
    public void testGetTotal1() {
        String[] items = new String[1];
        items[0] = ("ITEM000000");
        double result = shopService.getTotal(items);
        assertThat(result, is(3.00));
    }

    @Test
    public void testGetTotal2() {
        String[] items = new String[1];
        items[0] = ("ITEM000003-2");
        double result = shopService.getTotal(items);
        assertThat(result, is(30.00));
    }

    @Test
    public void testGetTotal3() {
        String[] items = new String[1];
        items[0] = ("ITEM000003");
        double result = shopService.getTotal(items);
        assertThat(result, is(15.00));
    }

    @Test
    public void testGetTotal4() {
        String[] items = new String[2];
        items[0] = ("ITEM000000");
        items[1] = ("ITEM000003-2");
        double result = shopService.getTotal(items);
        assertThat(result, is(33.00));
    }

    @Test
    public void testGetTotal5() {
        String[] items = new String[4];
        items[0] = ("ITEM000000");
        items[1] = ("ITEM000000");
        items[2] = ("ITEM000000");
        items[3] = ("ITEM000003-2");
        double result = shopService.getTotal(items);
        assertThat(result, is(39.00));
    }

    @Test
    public void testGetDiscount1() {
        String[] items = new String[2];
        items[0] = ("ITEM000000");
        items[1] = ("ITEM000000");
        double result = shopService.getDiscount(items);
        assertThat(result, is(6.00));
    }

    @Test
    public void testGetDiscount2() {
        String[] items = new String[3];
        items[0] = ("ITEM000000");
        items[1] = ("ITEM000000");
        items[2] = ("ITEM000000");
        double result = shopService.getDiscount(items);
        assertThat(result, is(6.00));
    }

    @Test
    public void testGetDiscount3() {
        String[] items = new String[3];
        items[0] = ("ITEM000004");
        items[1] = ("ITEM000004");
        items[2] = ("ITEM000004");
        double result = shopService.getDiscount(items);
        assertThat(result, is(6.00));
    }

    @Test
    public void testGetDiscount4() {
        String[] items = new String[5];
        items[0] = ("ITEM000005");
        items[1] = ("ITEM000005");
        items[2] = ("ITEM000005");
        items[3] = ("ITEM000005");
        items[4] = ("ITEM000005");
        double result = shopService.getDiscount(items);
        assertThat(result, is(18.00));
    }

    @Test
    public void testGetDiscount5() {
        String[] items = new String[4];
        items[0] = ("ITEM000002-4");
        items[1] = ("ITEM000000");
        items[2] = ("ITEM000000");
        items[3] = ("ITEM000000");
        double result = shopService.getDiscount(items);
        assertThat(result, is(28.00));
    }

    @Test
    public void testGetDiscount6() {
        String[] items = new String[2];
        items[0] = ("ITEM000002");
        items[1] = ("ITEM000002");
        double result = shopService.getDiscount(items);
        assertThat(result, is(11.00));
    }
}
