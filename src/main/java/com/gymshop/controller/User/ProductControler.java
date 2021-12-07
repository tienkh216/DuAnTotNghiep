package com.gymshop.controller.User;


import com.gymshop.entities.Product;
import com.gymshop.service.productService;
import com.gymshop.service.productStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/client/products")
public class ProductControler {


    @Autowired
    com.gymshop.service.productService productService;


    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

}
