package com.mx.petshop.sys.service.impl;

import com.mx.petshop.sys.entity.Customer;
import com.mx.petshop.sys.mapper.CustomerMapper;
import com.mx.petshop.sys.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
