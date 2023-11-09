package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.Products;
import com.example.fashionstore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/getProducts")
    public ResponseEntity<?> getProducts(){
        Map<String, Object> response=new HashMap<>();
        try {
            List<Products> productsList = productsService.getProducts();
            response.put("ProductsList",productsList);
            response.put("Message","Products Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Integer productId){
        Map<String, Object> response=new HashMap<>();
        try {
            Products product = productsService.getProductById(productId);
            response.put("Product",product);
            response.put("Message","Product Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Products product){
        Map<String, Object> response=new HashMap<>();
        try {
            Products newProduct = productsService.createProduct(product);
            response.put("NewProduct",newProduct);
            response.put("Message","Created Product Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody Products product){
        Map<String, Object> response=new HashMap<>();
        try {
            Products updatedProduct=productsService.updateProduct(product);
            response.put("UpdatedProduct",updatedProduct);
            response.put("Message","Updated Product Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@RequestBody Products product){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=productsService.deleteProduct(product);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
