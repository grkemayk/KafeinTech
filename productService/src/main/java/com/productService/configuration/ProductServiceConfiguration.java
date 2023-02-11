package com.productService.configuration;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan({"org.commonModule.entity"})
@EnableJpaRepositories({"org.commonModule.repository", "com.productService.repository"})
@EnableFeignClients(basePackages = {"org.commonModule.service"})
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ProductServiceConfiguration {
}
