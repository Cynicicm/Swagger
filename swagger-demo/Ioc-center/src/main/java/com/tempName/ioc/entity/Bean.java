package com.tempName.ioc.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/4/27
 */

@Data
public class Bean {
    private String name;
    private String className;
    private String scope = "singleton";
    private List<Property> properties = new ArrayList<>();
}

