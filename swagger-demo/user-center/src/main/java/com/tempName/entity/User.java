package com.tempName.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wenjie
 * @since 2020-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    @TableField("username")
    private String username;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

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
     * 状态（0-不可用，1-可用）
     */
    @TableField("status")
    private Integer status;

    /**
     * 逻辑删除（0-有效，1-无效）
     */
    @ApiModelProperty(value = "删除")
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;

}
