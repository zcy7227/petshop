package com.mx.petshop.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import com.mx.petshop.sys.entity.Customer;
import com.mx.petshop.sys.mapper.CustomerMapper;
import com.mx.petshop.sys.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mx.petshop.sys.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {


    @Override
    public void register(Customer customer) throws Exception {
        if (this.findCustomerByCustomerEmail(customer.getCusEmail()) != null) {
            throw new Exception("用户邮箱已注册！");
        }

        String customerId = "customer$" + DateUtil.formatFullTime(LocalDateTime.now());
        customer.setCusId(customerId);

        this.save(customer);
    }

    @Override
    public Customer login(String cusEmail, String cusPw) throws Exception {
        Customer customer = this.findCustomerByCustomerEmail(cusEmail);
        if (customer == null) {
            throw new Exception("用户邮箱未注册!");
        }
        if (!customer.getCusPw().equals(cusPw)) {
            throw new Exception("用户邮箱或密码错误！");
        }
        return customer;
    }

    @Override
    public boolean updatePassword(String cusEmail, String oldPw, String newPw) throws Exception {
        Customer customer = this.findCustomerByCustomerEmail(cusEmail);
        if (customer == null) {
            throw new Exception("用户邮箱未注册!");
        }
        if (!customer.getCusPw().equals(oldPw)) {
            throw new Exception("用户邮箱或密码错误！");
        }
        if (StringUtils.isBlank(newPw)) {
            throw new Exception("新密码为空");
        }

        customer.setCusPw(newPw);
        return this.update(customer, new LambdaQueryWrapper<Customer>().eq(Customer::getId, customer.getId()));
    }

    @Override
    public void updateWallet(String customerId, BigDecimal money) {
        Customer customer = this.findCustomerByCustomerId(customerId);
        customer.setWallet(customer.getWallet().add(money));
    }

    @Override
    public Customer findCustomerByCustomerId(String customerId) {
        return this.getOne(new LambdaQueryWrapper<Customer>().eq(Customer::getCusId, customerId));
    }

    @Override
    public Customer findCustomerByCustomerEmail(String cusEmail) {
        return this.getOne(new LambdaQueryWrapper<Customer>().eq(Customer::getCusEmail, cusEmail));
    }

    @Override
    public List<Customer> findCustomerList() {
        return this.list();
    }
}
