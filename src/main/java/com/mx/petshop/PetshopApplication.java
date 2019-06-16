package com.mx.petshop;

import com.mx.petshop.sys.ui.PetShopUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetshopApplication.class, args);

        PetShopUI ui = new PetShopUI();

        ui.start();
    }
}
