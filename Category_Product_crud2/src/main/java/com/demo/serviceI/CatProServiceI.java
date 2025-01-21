package com.demo.serviceI;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.model.Category;
import com.demo.model.Product;

public interface CatProServiceI 
{

	void saveData(Category c);


	Category getCategoryById(int id);



	void updateCategory(Category c, int id);

	void deletecategory(int id);

	

	Product getProductById(int prodid);

	

	void deleteProduct(int prodid);

	void saveProduct(Product p);

	void deleteProduct(Product p, Category ca);

	void updateProduct(Product pd);

	List<Product> pagingData(int pageNo);

	List<Category> pagingDataCategory(int pageNo);


	

	

	

	

  
}
