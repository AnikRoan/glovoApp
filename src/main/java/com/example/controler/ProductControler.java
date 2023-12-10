package com.example.controler;

import com.example.dto.Product;
import com.example.resours.ApiResponse;
import com.example.servis.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/products")
public class ProductControler {
        private final ProductService productService;

        public ProductControler(ProductService productService) {
            this.productService = productService;
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


        @GetMapping("/all")
        public ApiResponse<List<Product>> getAll() {
            ApiResponse<List<Product>> allProducts = new ApiResponse<>();
            List<Product> products = productService.getAllProducts();
            if (!CollectionUtils.isEmpty(products)) {
                allProducts.setSuccessful(true);
                allProducts.setData(products);
            } else {
                allProducts.setSuccessful(false);
                allProducts.setMesage("products not found");
            }
            return allProducts;


        }


        @GetMapping("/{id}")
        public ApiResponse<Product> get(@PathVariable Integer id) {
            ApiResponse<Product> productResponse = new ApiResponse<>();
            Product product = productService.getProductByID(id);
            if (product != null) {
                productResponse.setSuccessful(true);
                productResponse.setData(product);
            } else {
                productResponse.setSuccessful(false);
                productResponse.setMesage("product not found");
            }
            return productResponse;
        }

        @PostMapping("/update")
        public ApiResponse<Product> saveProduct(@RequestBody Product product) {
            this.productService.updateProduct(product);
            ApiResponse<Product> updateProduct = new ApiResponse<>();
            updateProduct.setSuccessful(true);
            updateProduct.setMesage("product updated successfully");
            updateProduct.setData(product);

            return updateProduct;


        }

        @PostMapping("/create")
        public ApiResponse<Product> createProduct(@RequestBody Product product) {
            productService.addProduct(product);
            ApiResponse<Product> newProduct = new ApiResponse<>();
            newProduct.setSuccessful(true);
            newProduct.setData(product);
            newProduct.setMesage("create product");

            return newProduct;
        }

        @DeleteMapping("/{id}")
        public ApiResponse<String> delitProduct(@PathVariable int id) {
            Product prod  = this.productService.getProductByID(id);
            ApiResponse<String> product = new ApiResponse<>();
            if (prod != null) {
                this.productService.removeProduct(id);
                product.setSuccessful(true);
                product.setMesage("product deleted");
            } else {
                product.setSuccessful(false);
                product.setMesage("product not found");
            }
            return product;


        }
    }


