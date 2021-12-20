package com.gymshop.controller;

import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.gymshop.dao.CategoryDAO;
import com.gymshop.entities.Account;
import com.gymshop.entities.Category;
import com.gymshop.entities.ProductStatus;
import com.gymshop.service.accountService;
import com.gymshop.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gymshop.entities.Product;
import com.gymshop.service.productService;
import com.gymshop.service.uploadService;

@Controller
public class ClientController {
    @Autowired
    productService productService;
    @Autowired
    categoryService categoryService;
    @Autowired
    accountService accountService;
    @Autowired
	uploadService upload;
    @RequestMapping(value = {"/", "/client/home"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        List<Product> list = productService.findTopNewProduct();
        model.addAttribute("items", list);
        List<Category> categories = categoryService.getCategory();
        model.addAttribute("categories", categories);

        return "client/site/Home";
    }




    @RequestMapping("/client/product")
    public String clientProduct(Model model, @RequestParam("cid") Optional<String> cid,@Param("keyword") String keyword) {
    	 if (cid.isPresent()) {
             List<Product> list = productService.findByCategoryId(cid.get());
             model.addAttribute("items", list);
             List<Category> category = categoryService.findAll();
             model.addAttribute("categories", category);
             
         } else {
        	 List<Product> listProducts = productService.listAll(keyword);
             model.addAttribute("items", listProducts);
             model.addAttribute("keyword", keyword);
             List<Category> category = categoryService.findAll();
             model.addAttribute("categories", category);
        }
        return ("client/site/Products");
    }

    @RequestMapping("/client/testtttt")
    public String shoppingCart(Model model) {
        return ("client/Signup2");
    }


    @RequestMapping("/client/cart")
    public String testttt(Model model) {
        return ("client/site/ShoppingCart");
    }

    @RequestMapping("/client/checkout")
    public String clientCheckout(Model model) {
        return ("client/site/NewCheckout");
    }

    @RequestMapping("/client/productDetail/{id}")
    public String productDetail(Model model,@PathVariable("id") Long id) {
    	Product item =productService.findById(id); 
		 model.addAttribute("items",item);
        return ("client/site/ProductDetail");
    }
    
    
    @RequestMapping("/client/editProfile")
    public String editProfile(Model model, HttpServletRequest request ) {
    	String username = request.getRemoteUser();
    	model.addAttribute("accounts",accountService.findById(username));
        return ("client/site/Profile");
    }
    
    @PostMapping("/client/editProfile") 
	public String edit(Account acc,Model model) {	  	
		accountService.save(acc);
		return "redirect:/client/home";
		
	
		}

}
