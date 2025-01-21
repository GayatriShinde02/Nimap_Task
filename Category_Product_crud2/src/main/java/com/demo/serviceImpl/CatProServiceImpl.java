package com.demo.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.repository.CatProRepository;
import com.demo.repository.ProductRepository;
import com.demo.serviceI.CatProServiceI;

@Service
public class CatProServiceImpl implements CatProServiceI
{
	@Autowired
	CatProRepository cr;
	
	@Autowired
	ProductRepository pr;

	@Override
	public void saveData(Category c) 
	{
		cr.save(c);
		
	}

	

	@Override
	public Category getCategoryById(int id) 
	{
		
		return cr.findById(id).get();
	}

	

	@Override
	public void updateCategory(Category c, int id) 
	{
		cr.save(c);
		
	}

	@Override
	public void deletecategory(int id) 
	{
		cr.deleteById(id);
		
	}

	
	@Override
	public Product getProductById(int prodid) 
	{
		
		return pr.findById(prodid).get();
	}

	@Override
	public void updateProduct(Product pd) 
	{
		Category c=pd.getCr();
		c.getProd().add(pd);
		cr.save(c);
		
	}

	@Override
	public void deleteProduct(int prodid)
	{
		
		pr.deleteById(prodid);
	}

	@Override
	public void saveProduct(Product p)
	{
		Category ca=p.getCr();
		ca.getProd().add(p);
	   cr.save(ca);		
		
	}

	@Override
	public void deleteProduct(Product p, Category ca) 
	{
		List<Product> s=ca.getProd();
		for(int i=0;i<s.size();i++)
		{
			Product pd=s.get(i);
			if(pd.getProdid()==p.getProdid())
			{
				s.remove(i);
				break;
			}
		}
		ca.setProd(s);
		pr.deleteById(p.getProdid());
		
		
	}

	@Override
	public List<Product> pagingData(int pageNo) 
	{
		Pageable pageable=PageRequest.of(pageNo, 2);
		return pr.findAll(pageable).getContent();
	}



	@Override
	public List<Category> pagingDataCategory(int pageNo) {
		Pageable pageable=PageRequest.of(pageNo, 2);
		return cr.findAll(pageable).getContent();
	}
	

	



}
