package com.tempName.service.impl;

import com.tempName.common.entity.Product;
import com.tempName.mapper.ProductMapper;
import com.tempName.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/16
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int create(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public Product retrieve(Integer id) {
        return productMapper.selectById(id);
    }

    @Override
    public int update(Product product) {
        Product entity = productMapper.selectById(product.getId());
        BeanUtils.copyProperties(product, entity);
        return productMapper.updateById(entity);
    }

    @Override
    public int delete(Integer id) {
        return productMapper.deleteById(id);
    }

    @Override
    public List<Product> listAll() {
        return productMapper.selectList(null);
    }
}
