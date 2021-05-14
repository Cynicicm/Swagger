package com.tempName.test;

import com.tempName.builder.Computer;
import org.junit.Test;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/14
 */

public class BuilderTest {
    @Test
    public void builderTest() {
        Computer computer = new Computer.Builder("因特尔","三星")
                .setDisplay("三星24寸")
                .setKeyboard("罗技")
                .setUsbCount(2)
                .build();
        System.out.println(computer);
    }
}
