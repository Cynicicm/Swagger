package com.tempName.aop.service.impl;

import com.tempName.aop.service.IProvider;

/**
 * @description:
 * @author: jwen
 * @date: 2021/4/29
 */

public class SimpleProvider implements IProvider {
    @Override
    public void getData() {
        System.out.println("SimpleProvider - Method : getData()");
    }
}
