package com.gohar.ecommerce.product;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    public ProductResponse findById(Integer productId) {
        return null;
    }

    public List<ProductPurchaseResponse> pruchaseProducts(List<ProductPurchaseRequest> productPurchaseRequests) {
        return List.of();
    }

    public Integer createProduct(@Valid ProductRequest productRequest) {
        return 0;
    }

    public List<ProductResponse> getAllProduct() {
        return List.of();
    }
}
