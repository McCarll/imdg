package com.vrudometkin.imdg.imdgtest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApiController {
    private ImgdService service;

    @GetMapping("/{id}")
    public Product get(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}/{price}")
    public void get(@PathVariable String id, @PathVariable String price) {
        service.updatePrice(id, price);
    }
}
