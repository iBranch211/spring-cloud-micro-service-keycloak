package com.spring.micro.repository.elasticsearch;

import com.spring.micro.model.Product;
import com.spring.micro.model.elasticsearch.ProductElasticModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductElasticRepository extends ElasticsearchRepository<ProductElasticModel,String> {
}
