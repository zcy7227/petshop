package com.mx.petshop.sys.ui;

import com.mx.petshop.sys.entity.Customer;
import com.mx.petshop.sys.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by mxwbq on 2019/6/16.
 */
@Service
public class PetShopUI {

    @Autowired
    private ICustomerService customerService;

    private static final Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.print("##############################\n" +
                "\t欢迎来到宠物商店\n" +
                "1.登录;\n" +
                "2.注册\n" +
                "请输入：");
        int state = inputInt();
        if (1 == state) {
            login();
        } else if (2 == state) {
            register();
        } else {
            System.out.println("输入错误，请重新输入");
            start();
        }
    }

    private static int inputInt() {
        return sc.nextInt();
    }

    private static String inputString() {
        return sc.next();
    }

    private void login() {
        System.out.println("请输入用户邮箱：");
        String email = inputString();
        System.out.println("请输入密码：");
        String password = inputString();
        try {
            customerService.login(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void register() {
        System.out.println("请输入用户邮箱：");
        String email = inputString();
        System.out.println("请输入密码：");
        String password = inputString();
        System.out.println("请再次输入密码：");
        String password2 = inputString();
        if (!password.equals(password2)) {
            System.out.println("两次输入密码不同去，请重新注册");
            return;
        }
        Customer customer = new Customer();
        customer.setCusEmail(email);
        customer.setCusPw(password);
        customer.setWallet(new BigDecimal("0.00"));
        try {
            customerService.register(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
