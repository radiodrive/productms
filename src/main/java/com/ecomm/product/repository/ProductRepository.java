package com.ecomm.product.repository;

import com.ecomm.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository <Product, String> {

    @Override
    List<Product> findAll();

    @Override
    <S extends Product> List<S> saveAll(Iterable<S> iterable);
}
