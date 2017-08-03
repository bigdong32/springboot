package com.linesum.example.hystrix;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 熔断器配置
 * @author wdongsen@linesum.com
 * @data 2017-07-10 14:01
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "hystrix")
public class HystrixProperties {

    private Integer timeOutInMillions;
}
