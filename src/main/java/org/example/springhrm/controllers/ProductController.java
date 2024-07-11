package org.example.springhrm.controllers;

import org.example.springhrm.entity.Product;
import org.example.springhrm.services.ProductService;
import org.example.springhrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = {"/product"})
public class ProductController {


    @Autowired
    ProductService productService;

    @GetMapping(value = {"/", ""})
    public String home(Model model,
                       @RequestParam( value="page" ,defaultValue = "0") int page,
                       @RequestParam(value="size",defaultValue = "10") int size,
                       @RequestParam(value="message",required = false) String message
    ) {
        Page<Product> products = productService.findByPage(page, size);
        model.addAttribute("message", message);
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", products.getNumber());
        model.addAttribute("totalPages", products.getTotalPages());
        return "product/product";
    }

    @GetMapping("/add")
    public String showAddProductForm() {
        return "product/add";
    }

    @PostMapping("/new")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") Double price,
                             @RequestParam("description") String description,
                             @RequestParam("image") MultipartFile image,
                             @RequestParam("quantity") Integer quantity, Model model) {
        Response response = productService.addProduct(name, price, description, image, quantity);
        model.addAttribute("message", response.getMessage());
        if (response.getData().equals(true)) {
            return "redirect:/product";
        }
        return "product/add";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model, @RequestParam(value ="error" , required = false) String error) {
        Product product = productService.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            model.addAttribute("error", error);
            return "product/editProduct";
        } else {
            return "redirect:/products";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id,
                                  @RequestParam("name") String name,
                                  @RequestParam("price") Double price,
                                  @RequestParam("description") String description,
                                  @RequestParam("image") MultipartFile image,
                                  @RequestParam("quantity") Integer quantity) {
        Response response = productService.updateProduct(id, name, price, description, image, quantity);
        String error = response.getMessage();
        if ((boolean) response.getData()) {
            return "redirect:/product";
        }

        return "redirect:/product/edit/" + id + "?error="+error;
    }

}
