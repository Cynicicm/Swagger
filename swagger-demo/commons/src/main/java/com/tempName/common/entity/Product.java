package com.tempName.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/16
 */
@Data
public class Product {
    private int id;
    private String name;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除（0-有效，1-无效）
     */
    @ApiModelProperty(value = "删除")
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;
}
