package com.vrudometkin.imdg.imdgtest;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImgdService {

    DbStorage storage;

    @Cacheable(cacheNames = "product_id", key = "#id")
    public Product getById(String id) {
        return storage.products.stream().filter(product -> id.equals(product.getUniq_id())).findFirst().orElseGet(null);
    }

    public void updatePrice(String id, String price){
        storage.products.stream().filter(product -> id.equals(product.getUniq_id())).findFirst().get().setSale_price(price);
    }

}
