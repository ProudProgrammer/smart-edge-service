package org.gaborbalazs.smartplatform.edgeservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"org.gaborbalazs.smartplatform.edgeservice"})
@EnableFeignClients(basePackages = {"org.gaborbalazs.smartplatform.edgeservice"})
public class EdgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdgeServiceApplication.class, args);
    }

}
