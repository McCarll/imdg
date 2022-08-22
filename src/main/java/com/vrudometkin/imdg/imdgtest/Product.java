package com.vrudometkin.imdg.imdgtest;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

import java.util.List;

@Data
public class Product {
    @CsvBindByPosition(position = 0)
    private String uniq_id;
    private String sku;
    private String name_title;
    private String description;
    private String list_price;
    private String sale_price;
    private String category;
    private String category_tree;
    private String averageproductrating;
    private String product_url;
    private String productimageurls;
    private String brand;
    private String totalnumberreviews;
    private String reviews;

    public Product(String[] line) {
        this.uniq_id = line[0];
        this.sku = line[1];
        this.name_title = line[2];
        this.description = line[3];
        this.list_price = line[4];
        this.sale_price = line[5];
        this.category = line[6];
        this.category_tree = line[7];
        this.averageproductrating = line[8];
        this.product_url = line[9];
        this.productimageurls = line[10];
        this.brand = line[11];
        this.totalnumberreviews = line[12];
        this.reviews = line[13];
    }
}
