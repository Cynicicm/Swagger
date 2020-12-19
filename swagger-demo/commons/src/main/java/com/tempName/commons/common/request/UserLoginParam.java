package com.tempName.commons.common.request;

import lombok.Data;

/**
 * Description:
 *  用户登录参数
 * @author wenjie
 * @date Create on 2020/12/15
 */
@Data
public class UserLoginParam {
    private String username;
    private String password;
}
