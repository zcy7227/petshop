package com.mx.petshop.sys.service.impl;

import com.mx.petshop.sys.entity.Customer;
import com.mx.petshop.sys.service.ICustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by mxwbq on 2019/6/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

    @Autowired
    private ICustomerService customerService;

    @Test
    public void register() {
        Customer customer = new Customer();
        customer.setCusEmail("zcy@qq.com");
        customer.setCusPw("zcy");
        customer.setWallet(new BigDecimal("0.00"));

        try {
            customerService.register(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        try {
            Customer customer = customerService.login("test@qq.com", "test");
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getOne() {
        Customer customer = customerService.findCustomerByCustomerEmail("test@qq.com");
        System.out.println(customer);
    }
}