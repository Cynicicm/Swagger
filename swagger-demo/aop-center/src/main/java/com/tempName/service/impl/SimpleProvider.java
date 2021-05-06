package com.tempName.service.impl;

import com.tempName.service.IProvider;

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
