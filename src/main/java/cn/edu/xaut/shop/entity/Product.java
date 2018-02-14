package cn.edu.xaut.shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true, name = "product_id")
    private Long id;

    @Column(length = 100, nullable = false, name = "product_name")
    private String name;

    @Column(length = 20, nullable = false, name = "product_unit")
    private String unit;

    @Column(length = 20, nullable = false, name = "product_price")
    private Double price;

    @Column(length = 20, name = "product_discount")
    private String discount;

    @Column(length = 20, nullable = false, name = "product_barcode")
    private String barcode;

    @Column(length = 20, nullable = false, name = "product_img")
    private String img;

    @Column(length = 20, nullable = false, name = "product_weigh")
    private Integer weigh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getWeigh() {
        return weigh;
    }

    public void setWeigh(Integer weigh) {
        this.weigh = weigh;
    }
}
