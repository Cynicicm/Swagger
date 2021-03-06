package com.tempName.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tempName.commons.common.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/16
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
