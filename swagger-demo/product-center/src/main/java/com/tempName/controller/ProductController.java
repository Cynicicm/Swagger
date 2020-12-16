package com.tempName.controller;

import com.tempName.common.entity.Product;
import com.tempName.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/16
 */
@RestController
@Api(tags = "商品模块")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ApiOperation("Retrieve")
    @GetMapping("/product/{id}")
    public Product retrieve(@PathVariable(value = "id")  Integer id) {
        return iProductService.retrieve(id);
    }

    @ApiOperation("Create")
    @PostMapping("/product")
    public int create(@RequestBody Product product) {
        return iProductService.create(product);
    }

    @ApiOperation("Update")
    @PutMapping("/product")
    public int update(@RequestBody Product product) {
        return iProductService.update(product);
    }

    @ApiOperation("Delete")
    @DeleteMapping("/product/{id}")
    public int delete(@PathVariable(value = "id") Integer id) {
        return iProductService.delete(id);
    }

    @ApiOperation("ListAll")
    @GetMapping("/product/list")
    public List<Product> listAll() {
        return iProductService.listAll();
    }
}
