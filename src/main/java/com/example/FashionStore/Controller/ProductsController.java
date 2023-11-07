package com.example.FashionStore.Controller;

import com.example.FashionStore.Model.Products;
import com.example.FashionStore.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/getProducts")
    public ResponseEntity<?> getProducts(){
        return productsService.getProducts();
    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Integer productId){
        return productsService.getProductById(productId);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Products product){
        return productsService.createProduct(product);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody Products product){
        return productsService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@RequestBody Products product){
        return productsService.deleteProduct(product);
    }


}
