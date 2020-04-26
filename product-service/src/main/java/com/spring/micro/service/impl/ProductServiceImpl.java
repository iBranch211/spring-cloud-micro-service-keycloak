package com.spring.micro.service.impl;

import com.spring.micro.dto.ProductDto;
import com.spring.micro.model.Product;
import com.spring.micro.model.ProductSize;
import com.spring.micro.model.elasticsearch.ProductElasticModel;
import com.spring.micro.repository.ProductRepository;
import com.spring.micro.repository.elasticsearch.ProductElasticRepository;
import com.spring.micro.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductElasticRepository productElasticRepository;

    private final ModelMapper modelMapper;


    @Override
    public ProductDto save(ProductDto productDto) {
        Product product=Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .size(ProductSize.valueOf(productDto.getSize()))
                .price(productDto.getPrice())
                .build();
        
       product=productRepository.save(product);

       ProductElasticModel productElasticModel=modelMapper.map(product, ProductElasticModel.class);
       productElasticRepository.save(productElasticModel);

       return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public void delete(String productId) {
        Product product=productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException(productId));
        if(product!=null){
            productRepository.delete(product);

            ProductElasticModel productElasticModel=modelMapper.map(product,ProductElasticModel.class);
            productElasticRepository.delete(productElasticModel);
        }
    }


    @Override
    public ProductDto update(String productId, ProductDto productDto) {
        Product product=productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException(productId));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setSize(ProductSize.valueOf(productDto.getSize()));
        product.setPrice(productDto.getPrice());
        product=productRepository.save(product);

        ProductElasticModel productElasticModel=modelMapper.map(product, ProductElasticModel.class);
        productElasticRepository.save(productElasticModel);

        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public ProductDto getById(String productId) {
        Product product=productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException(productId));
        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public Page<Product> getPagination(Pageable pageable) {
        Page<Product> products=productRepository.findAll(pageable);
        return products;
    }
}
