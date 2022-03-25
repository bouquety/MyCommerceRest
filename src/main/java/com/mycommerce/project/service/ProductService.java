package com.mycommerce.project.service;

import com.mycommerce.project.controller.model.ProductResponse;
import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    public List<ProductResponse> fetchAll(){
        ProductDao productDao = DaoFactory.getProductDao();

        return productDao.getAllProducts().stream()
                .map(p -> p.toDto())
                .collect(Collectors.toList());
    }


}
