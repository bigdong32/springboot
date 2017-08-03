package com.linesum.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

/**
 * 启动类
 * @author wdongsen@linesum.com
 * @data 2017-07-07 14:28
 */
@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void customize(ConfigurableEmbeddedServletContainer container){
        container.setPort(8081);
    }
}
