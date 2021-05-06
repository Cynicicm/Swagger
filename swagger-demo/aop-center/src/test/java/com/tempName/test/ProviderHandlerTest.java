package com.tempName.test;

import com.tempName.aop.service.IProvider;
import com.tempName.aop.service.impl.ProviderHandler;
import com.tempName.aop.service.impl.SimpleProvider;
import org.junit.Test;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/6
 */

public class ProviderHandlerTest {
    @Test
    public void dynamicTest() {
        ProviderHandler providerHandler = new ProviderHandler();
        IProvider iProvider = (IProvider) providerHandler.bind(new SimpleProvider());
        iProvider.getData();
    }
}
