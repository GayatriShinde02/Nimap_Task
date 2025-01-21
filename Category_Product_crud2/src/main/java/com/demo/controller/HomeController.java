package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.serviceI.CatProServiceI;

@RestController
@RequestMapping("/api")
public class HomeController 
{
  @Autowired
  CatProServiceI csi;
  
  @PostMapping("/categories/saveData")
  public String saveData(@RequestBody Category c)
  {
	  csi.saveData(c);
	  return "data save successfully";
  }
  
  @GetMapping("/categories")
  public List<Category> pagingDataCategory(@RequestParam("page") int pageNo)
  {
	  List<Category> list=csi.pagingDataCategory(pageNo);
	  return list;
  }
  
  @GetMapping("/categories/{id}")
  public Category getCategoryById(@PathVariable("id") int id)
  {
	  Category cr=csi.getCategoryById(id);
	  return cr;
  }
  
  @PutMapping("/categories/{id}")
  public String updateCategory(@RequestBody Category c,@PathVariable int id)
  {
	 csi.updateCategory(c,id);
	 return "update data successfully";
  }
  
  @DeleteMapping("/categories/{id}")
  public String deleteCategory(@PathVariable("id") int id)
  {
	  csi.deletecategory(id);
	  return "delete data successfully";
  }
  
 
  
  @PostMapping("/saveProduct")
  public String saveProduct(@RequestBody Product p)
  {
	  Category ct=csi.getCategoryById(p.getCr().getId());
	  p.setCr(ct);
	  csi.saveProduct(p);
	  return "save product deatails successfully";
  }
  @GetMapping("/products")
  public List<Product> pagingData(@RequestParam("page") int pageNo)
  {
	  List<Product>al=csi.pagingData(pageNo);
	 return al;
  }
  
  @GetMapping("/products/{prodid}")
  public Product getProductById(@PathVariable("prodid") int prodid)
  {
	  Product pd=csi.getProductById(prodid);
	  return pd;	  
  }
  
  @PutMapping("/products/{prodid}")
  public String updateProduct(@RequestBody Product pd)
  {
	  Category c=csi.getCategoryById(pd.getCr().getId());
	  pd.setCr(c);
	  csi.updateProduct(pd);
	  return "update product data successfully";
  }
  
  @DeleteMapping("/products/{prodid}")
  public String deleteProduct(@PathVariable("prodid") int prodid)
  {
	  Product p=csi.getProductById(prodid);
	  Category ca=csi.getCategoryById(p.getCr().getId());
	  csi.deleteProduct(p,ca);
	  return "delete product data successfully";
	  
  }   
  }
