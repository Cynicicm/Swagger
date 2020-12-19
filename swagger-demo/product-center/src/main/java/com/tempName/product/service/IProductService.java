package com.tempName.product.service;

import com.tempName.commons.common.entity.Product;

import java.util.List;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/16
 */

public interface IProductService {
    int create(Product product);
    Product retrieve(Integer id);
    int update(Product product);
    int delete(Integer id);
    List<Product> listAll();
}
