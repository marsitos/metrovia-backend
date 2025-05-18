package com.metrovia;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PortRunner implements CommandLineRunner {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Aplicación corriendo en puerto: " + serverPort);
    }
}
