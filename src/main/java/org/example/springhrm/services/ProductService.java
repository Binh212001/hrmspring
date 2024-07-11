package org.example.springhrm.services;

import org.example.springhrm.entity.Product;
import org.example.springhrm.utils.Response;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
     Page<Product> findByPage(int page, int size);

     Response addProduct(String name, Double price, String description, MultipartFile image, Integer quantity);

     Product getProductById(Long id);

     Response updateProduct(Long id, String name, Double price, String description, MultipartFile image, Integer quantity);
}
