package com.spring.micro.service;

import com.spring.micro.dto.ProductDto;
import com.spring.micro.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ProductService {

    ProductDto save(ProductDto productDto);

    void delete(String productId);

    ProductDto update(String productId,ProductDto productDto);

    ProductDto getById(String productId);

    Page<Product> getPagination(Pageable pageable);
}
