package com.example.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import xyz.erupt.core.annotation.EruptScan;

@SpringBootApplication
@EntityScan
@EruptScan
public class WmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(WmsApplication.class, args);
    }
}