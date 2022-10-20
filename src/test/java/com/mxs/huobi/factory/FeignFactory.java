package com.mxs.huobi.factory;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableFeignClients(basePackages = "com.mxs.huobi.client")
public class FeignFactory {
}
