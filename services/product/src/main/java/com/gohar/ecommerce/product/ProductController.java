package com.gohar.ecommerce.product;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class ProductController {
    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }
    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest productRequest){
        return ResponseEntity.ok(productServices.createProduct(productRequest));
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(productServices.getAllProduct());
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer productId){
        return  ResponseEntity.ok(productServices.findById(productId));
    }
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> pruchaseProducts(
            @RequestBody List<ProductPurchaseRequest> productPurchaseRequests
    ){
        return ResponseEntity.ok(productServices.pruchaseProducts(productPurchaseRequests));
    }
}
