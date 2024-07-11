package org.example.springhrm.services;

import org.example.springhrm.entity.Product;
import org.example.springhrm.repo.ProductRepository;
import org.example.springhrm.utils.FileHandler;
import org.example.springhrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    FileHandler fileHandler;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByPage(pageable);

    }

    @Override
    public Response addProduct(String name, Double price, String description, MultipartFile image, Integer quantity) {
        try {
            String imagePath = fileHandler.saveUploadedFile(image);
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setImage(imagePath);
            product.setQuantity(quantity);
            productRepository.save(product);
            return new Response("Product added successfully.", true);
        } catch (Exception e) {
            return new Response(e.getMessage(), false);
        }
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Response updateProduct(Long id, String name, Double price, String description, MultipartFile image, Integer quantity) {
        try {
            Product product = productRepository.findById(id).get();
            if (product != null) {
                product.setName(name);
                product.setPrice(price);
                product.setDescription(description);
                if (!image.isEmpty()) {
                    String imagePath = fileHandler.updateUploadedFile(image,product.getImage());
                    product.setImage(imagePath);
                }
                product.setQuantity(quantity);
                productRepository.save(product);
                return new Response("Product updated successfully.", true);
            }
            return new Response("Product not found.", false);
        } catch (Exception e) {
            return new Response(e.getMessage(), false);
        }
    }
}
