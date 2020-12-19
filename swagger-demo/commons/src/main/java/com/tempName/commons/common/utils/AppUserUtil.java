package com.tempName.commons.common.utils;

import com.tempName.commons.common.entity.User;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/17
 */
public class AppUserUtil {
    private static User user;

    public static User getLoginUser() {
        return AppUserUtil.user;
    }

    public static void setLoginUser(User user) {
        AppUserUtil.user = user;
    }
}
