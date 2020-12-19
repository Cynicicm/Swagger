package com.tempName.product.service.impl;

import com.tempName.commons.common.entity.Product;
import com.tempName.commons.common.utils.AppUserUtil;
import com.tempName.product.mapper.ProductMapper;
import com.tempName.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        try {
            Product entity = productMapper.selectById(product.getId());
            BeanUtils.copyProperties(product, entity);
            return productMapper.updateById(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public int delete(Integer id) {
        return productMapper.deleteById(id);
    }

    @Override
    public List<Product> listAll() {
        log.info("user:{}", AppUserUtil.getLoginUser());
        return productMapper.selectList(null);
    }
}
