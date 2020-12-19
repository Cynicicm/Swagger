package com.tempName.commons.common.request;

import lombok.Data;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/17
 */
@Data
public class RegisterParam {
    private String username;
    private String password;
    private Integer age;
    private String email;
}
