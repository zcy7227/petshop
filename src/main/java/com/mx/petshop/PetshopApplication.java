package com.mx.petshop;

import com.mx.petshop.sys.entity.*;
import com.mx.petshop.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PetshopApplication { // implements CommandLineRunner {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IPetOrderService petOrderService;

    @Autowired
    private IPetService petService;

    @Autowired
    private IShopService shopService;

    @Autowired
    private IVarietyService varietyService;

    private String cusId;

    private int type;

    private static final Scanner sc = new Scanner(System.in);

    private static int inputInt() {
        return sc.nextInt();
    }

    private static String inputString() {
        return sc.next();
    }

    public static void main(String[] args) {
        SpringApplication.run(PetshopApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        start();
//    }

    public void start() {
        System.out.print("##############################\n" +
                "\t欢迎来到宠物商店\n" +
                "1.登录\n" +
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

    private void login() {
        System.out.println("请输入用户邮箱：");
        String email = inputString();
        System.out.println("请输入密码：");
        String password = inputString();
        try {
            Customer customer = customerService.login(email, password);
            cusId = customer.getCusId();
            if (customer.getType() == 1) {
                type = 1;
                manger();
            } else {
                type = 0;
                show();
            }
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
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        System.out.println("欢迎登陆宠物商店");
        selectShop();
        System.out.println("请输入选择的商店Id");
        String shopId = inputString();
        showPet(shopId);
    }

    public void showPet(String shopId) {
        System.out.print("这里是商店" + shopId + "请选择操作：\n" +
                "1.购买宠物\n" +
                "2.退出\n" +
                "请选择：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                buyPet(shopId);
                break;
            case 2:
                show();
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                show();
            }
        }
    }

    public void buyPet(String shopId) {
        System.out.println("商店宠物库存如下：");
        Pet pet = new Pet();
        pet.setShopId(shopId);
        pet.setPetState(0);
        selectPet(pet);
        System.out.println("请选择");
        String petId = inputString();
        pet = petService.findPetByPetId(petId);
        PetOrder petOrder = new PetOrder();
        petOrder.setCusId(cusId);
        petOrder.setPetId(petId);
        petOrder.setTradePrice(pet.getOriginalPrice());
        petOrder.setTradeTime(LocalDate.now());
        petOrderService.addPetOrder(petOrder);
        System.out.println("购买成功！");
        showPet(shopId);
    }

    public void manger() {
        System.out.print("\n\t欢迎管理员登录！！！\n" +
                "1.用户管理\n" +
                "2.宠物管理\n" +
                "3.订单查看\n" +
                "4.商店管理\n" +
                "5.品种管理\n" +
                "请选择您进入的库：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                mangerCustomer();
                break;
            case 2:
                mangerPet();
                break;
            case 3:
                mangerPetOrder();
                manger();
                break;
            case 4:
                mangerShop();
                break;
            case 5:
                mangerVariety();
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                manger();
            }
        }
    }

    public void mangerCustomer() {
        System.out.print("\t欢迎管理员进入用户信息界面！！！\n" +
                "1.查看用户信息\n" +
                "2.修改用户信息\n" +
                "3.返回上一层\n" +
                "请选择您的操作：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                selectCustomer();
                mangerCustomer();
                break;
            case 2:
                updateCustomer();
                break;
            case 3:
                manger();
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                mangerCustomer();
            }
        }
    }

    public void mangerPet() {
        System.out.print("\t欢迎管理员进入宠物信息界面！！！\n" +
                "1.增加宠物信息\n" +
                "2.查看宠物信息\n" +
                "3.修改宠物信息\n" +
                "4.删除宠物信息\n" +
                "5.返回上一层\n" +
                "请选择您的操作：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                insertPet();
                break;
            case 2:
                selectPet(new Pet());
                mangerPet();
                break;
            case 3:
                updatePet();
                break;
            case 4:
                deletePet();
                break;
            case 5:
                manger();
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                mangerPet();
            }
        }
    }

    public void mangerPetOrder() {
        System.out.print("\t欢迎管理员进入宠物订单信息界面！！！\n" +
                "1.查询宠物订单信息\n" +
                "2.返回上一层\n" +
                "请选择您的操作：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                selectPetOrder();
                mangerPetOrder();
                break;
            case 2:
                manger();
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                mangerPetOrder();
            }
        }
    }

    public void mangerShop() {
        System.out.print("\t欢迎管理员进入商店信息界面！！！\n" +
                "1.增加商店信息\n" +
                "2.查询商店信息\n" +
                "3.修改商店信息\n" +
                "4.删除商店信息\n" +
                "5.返回上一层\n" +
                "请选择您的操作：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                insertShop();
                break;
            case 2:
                selectShop();
                mangerShop();
                break;
            case 3:
                updateShop();
                break;
            case 4:
                deleteShop();
                break;
            case 5:
                manger();
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                mangerShop();
            }
        }
    }

    public void mangerVariety() {
        System.out.print("\t欢迎管理员进入品种信息界面！！！\n" +
                "1.增加品种信息\n" +
                "2.查询品种信息\n" +
                "3.修改品种信息\n" +
                "4.删除品种信息\n" +
                "5.返回上一层\n" +
                "请选择您的操作：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                insertVariety();
                break;
            case 2:
                selectVariety();
                mangerVariety();
                break;
            case 3:
                updateVariety();
                break;
            case 4:
                deleteVariety();
                break;
            case 5:
                manger();
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                mangerVariety();
            }
        }
    }

    public void insertPet() {
        Pet pet = new Pet();
        System.out.print("请添加宠物信息：\n");
        System.out.print("宠物品种id:");
        pet.setVarietyId(inputString());
        System.out.print("商家id:");
        pet.setShopId(inputString());
        System.out.print("性别:");
        pet.setPetSex(inputString());
        pet.setBornDate(LocalDate.now());
        System.out.print("体重:");
        pet.setPetWeight(inputString());
        System.out.print("简介：");
        pet.setPetInfo(inputString());
        petService.addPet(pet);
        mangerPet();
    }

    public void insertShop() {
        Shop shop = new Shop();
        System.out.print("请添加商店信息：\n");
        System.out.print("商店名:");
        shop.setShopName(inputString());
        System.out.print("商店地址:");
        shop.setShopAddress(inputString());
        System.out.print("店主:");
        shop.setShopKeeper(inputString());
        shopService.addShop(shop);
        mangerShop();
    }

    public void insertVariety() {
        Variety variety = new Variety();
        System.out.print("请添加品种信息：\n");
        System.out.print("生物属:");
        variety.setVarietyGenus(inputString());
        System.out.print("生物亚种:");
        variety.setVarietySubspecies(inputString());
        System.out.print("原始价格:");
        variety.setOriginalPrice(new BigDecimal(inputString()));
        varietyService.addVariety(variety);
        mangerVariety();
    }

    public void insertCustomer() {
        Customer customer = new Customer();
        System.out.print("请添加用户信息：\n" +
                "用户邮箱：");
        customer.setCusEmail(inputString());
        System.out.print("密码:");
        customer.setCusPw(inputString());
        System.out.print("钱包:");
        customer.setWallet(new BigDecimal(inputString()));
        try {
            customerService.register(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mangerCustomer();
    }

    public void updateCustomer() {
        System.out.print("请输入你要修改的用户id");
        String id = inputString();
        Customer customer = customerService.findCustomerByCustomerId(id);
        System.out.print("请输入你要修改后的用户密码：");
        String newPw = inputString();

        try {
            customerService.updatePassword(customer.getCusEmail(), customer.getCusPw(), newPw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePet() {
        System.out.print("请输入你要修改的宠物id");
        String id = inputString();
        System.out.print("请选择您想修改的宠物信息（1.宠物品种id 2.商家id 3.体重 4.简介）：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                ;
                break;
            case 2:
                ;
                break;
            case 3:
                ;
                break;
            case 4:
                ;
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                updatePet();
            }
        }
    }

    public void updatePetOtder() {
        System.out.print("请输入你要修改的宠物订单id");
        String id = inputString();
        System.out.print("请选择您想修改的订单信息（1.顾客id 2.宠物id 3.交易价格）：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                ;
                break;
            case 2:
                ;
                break;
            case 3:
                ;
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                updatePetOtder();
            }
        }
    }

    public void updateShop() {
        System.out.print("请输入你要修改的商店id");
        String id = inputString();
        System.out.print("请选择您想修改的商店信息（1.商店名 2.商店地址 3.店主）：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                ;
                break;
            case 2:
                ;
                break;
            case 3:
                ;
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                updateShop();
            }
        }
    }

    public void updateVariety() {
        System.out.print("请输入你要修改的品种id");
        String id = inputString();
        System.out.print("请选择您想修改的品种信息（1.生物属 2.生物亚种 3.原始价格）：");
        int temp = inputInt();
        switch (temp) {
            case 1:
                ;
                break;
            case 2:
                ;
                break;
            case 3:
                ;
                break;
            default: {
                System.out.print("选择有误，请重新选择：");
                updateVariety();
            }
        }
    }

    public void deletePet() {
        System.out.print("请输入您要删除的宠物id:");
        String id = inputString();
        petService.deletePet(id);
    }

    public void deletePetOrder() {
        System.out.print("请输入您要删除的宠物订单id:");
        String id = inputString();
        petOrderService.deletePetOrder(id);
    }

    public void deleteShop() {
        System.out.print("请输入您要删除的商店id:");
        String id = inputString();
        shopService.deleteShop(id);
    }

    public void deleteVariety() {
        System.out.print("请输入您要删除的品种id:");
        String id = inputString();
        varietyService.deleteVariety(id);
    }

    public void selectCustomer() {
        List<Customer> list = customerService.findCustomerList();
        System.out.println("\n\n用户Id    登录邮箱        密码   钱包   创建时间");
        for (Customer c : list) {
            System.out.println(c.getCusId() + "   " + c.getCusEmail() + "   " + c.getCusPw() + "   " + c.getWallet() + "   " + c.getCreateBy());
        }
    }

    public void selectPet(Pet pet) {
        List<Pet> list = petService.findPetList(pet);
        System.out.println("\n\n宠物id    宠物品种Id  商家Id   宠物状态   出生日期  性别  体重  简介");
        for (Pet p : list) {
            System.out.println(p.getPetId() + "   " + p.getVarietyId() + "   " + p.getShopId() + "   " + p.getPetState() + "   " +
                    " " + p.getBornDate() + "   " + p.getPetSex() + "   " + p.getPetWeight() + "   " + p.getPetInfo());
        }
    }

    public void selectPetOrder() {
        List<PetOrder> list = petOrderService.findPetOrderList(new PetOrder());
        System.out.println("\n\n宠物订单Id    顾客Id  宠物id   交易价格   交易时间");
        for (PetOrder petO : list) {
            System.out.println(petO.getPetOrderId() + "   " + petO.getCusId() + "   " + petO.getPetId() + "   " + petO.getTradePrice() + "   " +
                    " " + petO.getTradeTime());
        }
    }

    public void selectShop() {
        List<Shop> list = shopService.findShopList(new Shop());
        System.out.println("\n\n商店id    商店名  商店地址   店主   钱包");
        for (Shop shop : list) {
            System.out.println(shop.getShopId() + "   " + shop.getShopName() + "   " + shop.getShopAddress() + "   " + shop.getShopKeeper() + "  " +
                    " " + shop.getWallet());
        }
    }

    public void selectVariety() {
        List<Variety> list = varietyService.findVarietyList(new Variety());
        System.out.println("\n\n品种id    生物属  生物亚种   原始价格");
        for (Variety variety : list) {
            System.out.println(variety.getVarietyId() + "   " + variety.getVarietyGenus() + "   " + variety.getVarietySubspecies() + "   " +
                    "" + variety.getOriginalPrice());
        }
    }
}
