package com.mx.petshop.sys.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mxwbq on 2019/6/16.
 */
@Configuration
@MapperScan(value = {"com.mx.petshop.*.mapper"})
public class MybatisPlusConfig {
}
