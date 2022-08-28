package com.vrudometkin.imdg.imdgtest;

import lombok.AllArgsConstructor;
import org.apache.ignite.client.ClientCache;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class ImgdService {

    DbStorage storage;
    ClientCache cache;


    public Product getById(String id) {
        Optional<Product> productOptional = cacheGet(id);
        return productOptional.orElseGet(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Product product = storage.products.stream().filter(p -> id.equals(p.getUniq_id())).findFirst().orElse(null);
            if (product != null) {
                cachePut(product);
            }
            return product;
        });
    }

    private Optional<Product> cacheGet(String id) {
        return Optional.ofNullable((Product) cache.get(id));
    }

    private void cachePut(Product product) {
        cache.put(product.getUniq_id(), product);
    }

    public void updatePrice(String id, String price) {
        storage.products.stream().filter(product -> id.equals(product.getUniq_id())).findFirst().get().setSale_price(price);
    }

}
