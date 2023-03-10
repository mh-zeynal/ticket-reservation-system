package com.example.ticket.beans;

import com.example.ticket.layers.applicationLayer.PaymentManagement;
import org.springframework.context.annotation.*;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ServiceLayerConfiguration {
    private String rootPath = new FileSystemResource("").getFile().getAbsolutePath().replace("\\", "/");


    @Bean
    public PaymentManagement paymentManagement(){
        return new PaymentManagement(rootPath + "/src/main/resources/");
    }

}
