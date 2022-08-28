package com.vrudometkin.imdg.imdgtest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ApiController {
    private ImgdService service;

    @GetMapping("/{id}")
    public Product get(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/{price}")
    public void updatePrice(@PathVariable String id, @PathVariable String price) {
        service.updatePrice(id, price);
    }
}
