package com.mx.petshop.sys.service;

import com.mx.petshop.sys.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
public interface ICustomerService extends IService<Customer> {

    /**
     * 用户注册
     * @param customer 用户信息
     */
    void register(Customer customer) throws Exception;

    /**
     * 用户登录
     * @param cusEmail 用户邮箱
     * @param cusPw 用户密码
     * @return 用户信息，登录失败返回空
     */
    Customer login(String cusEmail, String cusPw) throws Exception;

    /**
     * 修改用户密码
     * @param cusEmail 用户邮箱
     * @param oldPw 旧密码
     * @param newPw 新密码
     * @return 修改成功与否
     */
    boolean updatePassword(String cusEmail, String oldPw, String newPw) throws Exception;

    /**
     * 修改用户钱包金额
     * @param customerId 用户Id
     * @param money 金额
     */
    void updateWallet(String customerId, BigDecimal money);

    /**
     * 根据用户Id，查询用户
     * @param customerId 用户Id
     * @return 用户
     */
    Customer findCustomerByCustomerId(String customerId);

    /**
     * 根据用户Email，查询用户
     * @param cusEmail 用户Email
     * @return 用户
     */
    Customer findCustomerByCustomerEmail(String cusEmail);

    /**
     * 返回用户列表
     * @return 用户列表
     */
    List<Customer> findCustomerList();
}
