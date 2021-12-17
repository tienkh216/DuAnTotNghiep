package com.gymshop.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymshop.domain.DoanhThuThang;
import com.gymshop.domain.Top10;
import com.gymshop.entities.Product;
import com.gymshop.service.productService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/chart")
public class chartRestController {
	@Autowired
	productService productService;
	
	@GetMapping()
	public List<Top10> getTop10(){
		return productService.top10product();
	}
	
	
	@GetMapping("doanhThu/{year}")
	public List<DoanhThuThang> getDoanhThu(@PathVariable("year") int year){
		return productService.doanhThuThang(year);
	}
}
