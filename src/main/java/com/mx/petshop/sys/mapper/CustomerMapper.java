package com.mx.petshop.sys.mapper;

import com.mx.petshop.sys.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
