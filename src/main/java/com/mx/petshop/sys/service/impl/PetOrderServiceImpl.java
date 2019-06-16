package com.mx.petshop.sys.service.impl;

import com.mx.petshop.sys.entity.PetOrder;
import com.mx.petshop.sys.mapper.PetOrderMapper;
import com.mx.petshop.sys.service.IPetOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Service
public class PetOrderServiceImpl extends ServiceImpl<PetOrderMapper, PetOrder> implements IPetOrderService {

}
