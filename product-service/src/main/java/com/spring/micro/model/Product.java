package com.spring.micro.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    @NotNull
    @Size(min = 3,max = 40)
    private String name;

    @Column(name = "description")
    @NotNull
    @Size(min = 4,max = 600)
    private String description;

    @Column(name = "price")
    @NotNull
    @Size(min = 1,max = 20)
    private Double price;

    @Enumerated
    @NotNull
    @Column(name = "size")
    private ProductSize size;

}
