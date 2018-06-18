package com.pnpStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pnpStore.model.Product;
import com.pnpStore.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;


@Service
public class ProductService{

	@Autowired
	public ProductRepository productRepository;
   
        public List<Product> getAllProducts()
        {
            List<Product> prod = new ArrayList<>();
            
            productRepository.findAll().
            forEach(prod::add);
       
            return prod;
        }
        
        public Product getProductsByBarcode(int barcode)
        {
            Product prod = new Product();
            
            prod = productRepository.findOne(barcode);
     
            return prod;
        }
        
        public Product saveProduct(Product prod)
        {
            return productRepository.save(prod);   
        }
        
        public void DeleteProduct(int barcode)
        {
            productRepository.delete(barcode);
        }
        
        public Product getProductsByName(String prodName)
        {
            Product prod = new Product();
            
            prod = productRepository.getProdByName(prodName);
            
            return prod;
        }
        
        @Transactional
        public void updateProd(Product product)
        {
            int barcode = product.getBarcode();
            int catid = product.getCategoryID();
            double price = product.getPrice();
            String prodname = product.getProdName();
            String productinfo = product.getProdInfo();
         
            productRepository.updateProd(price,catid, prodname, productinfo, barcode);
        }
}
