package com.gymshop.controller;

import java.util.*;

import com.gymshop.dao.CategoryDAO;
import com.gymshop.entities.Category;
import com.gymshop.entities.ProductStatus;
import com.gymshop.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gymshop.entities.Product;
import com.gymshop.service.productService;

@Controller
public class ClientController {
    @Autowired
    productService productService;
    @Autowired
    categoryService categoryService;

    @RequestMapping(value = {"/", "/client/home"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        List<Product> list = productService.findTopNewProduct();
        model.addAttribute("items", list);
        List<Category> categories = categoryService.getCategory();
        model.addAttribute("categories", categories);

        return "client/site/Home";
    }




    @RequestMapping("/client/product")
    public String clientProduct(Model model, @RequestParam("cid") Optional<String> cid) {
        if (cid.isPresent()) {
            List<Product> list = productService.findByCategoryId(cid.get());
            model.addAttribute("items", list);
            List<Category> category = categoryService.findAll();
            model.addAttribute("categories", category);
        } else {
            List<Product> list = productService.findAll();
            model.addAttribute("items", list);
            List<Category> category = categoryService.findAll();
            model.addAttribute("categories", category);
        }
        return ("client/site/Products");
    }

    @RequestMapping("/client/cart")
    public String shoppingCart(Model model) {
        return ("client/site/ShoppingCart");
    }

    @RequestMapping("/client/checkout")
    public String clientCheckout(Model model) {
        return ("client/site/Checkout");
    }

    @RequestMapping("/client/productDetail/{id}")
    public String productDetail(Model model,@PathVariable("id") Long id) {
    	Product item =productService.findById(id); 
		 model.addAttribute("items",item);
        return ("client/site/ProductDetail");
    }

}
