package com.spring.micro.model.elasticsearch;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class ProductElasticModel {

    @Id
    private String id;

    private String name;

    private String description;

    private Double price;

    private String size;

    private Date createdAt;

}
