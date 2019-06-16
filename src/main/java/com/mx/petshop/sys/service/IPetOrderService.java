package com.mx.petshop.sys.service;

import com.mx.petshop.sys.entity.PetOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单信息 服务类
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
public interface IPetOrderService extends IService<PetOrder> {
    
    /**
     * 添加订单
     * @param petOrder 订单
     */
    void addPetOrder(PetOrder petOrder);

    /**
     * 删除订单
     * @param petOrderId 订单Id
     */
    void deletePetOrder(String petOrderId);

    /**
     * 更新订单信息
     * @param petOrder 订单
     */
    void updatePetOrder(PetOrder petOrder);

    /**
     * 根据订单Id，查询订单
     * @param petOrderId 订单Id
     * @return 订单
     */
    PetOrder findPetOrderByPetOrderId(String petOrderId);

    /**
     * 根据订单信息，查询订单列表
     * @param petOrder 订单信息
     * @return 订单列表
     */
    List<PetOrder> findPetOrderList(PetOrder petOrder);
}
