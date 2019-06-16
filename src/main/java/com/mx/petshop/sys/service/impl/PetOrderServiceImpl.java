package com.mx.petshop.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mx.petshop.sys.entity.PetOrder;
import com.mx.petshop.sys.mapper.PetOrderMapper;
import com.mx.petshop.sys.service.ICustomerService;
import com.mx.petshop.sys.service.IPetOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mx.petshop.sys.service.IPetService;
import com.mx.petshop.sys.service.IShopService;
import com.mx.petshop.sys.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IShopService shopService;

    @Autowired
    private IPetService petService;

    @Override
    public void addPetOrder(PetOrder petOrder) {
        String petOrderId = "petOrder$" + DateUtil.formatFullTime(LocalDateTime.now());
        petOrder.setPetOrderId(petOrderId);

        this.customerService.updateWallet(petOrder.getCusId(), petOrder.getTradePrice().multiply(BigDecimal.valueOf(-1)));

        String shopId = this.petService.findPetByPetId(petOrder.getPetId()).getShopId();
        this.shopService.updateWallet(shopId, petOrder.getTradePrice());

        this.save(petOrder);
    }

    @Override
    public void deletePetOrder(String petOrderId) {
        this.remove(new LambdaQueryWrapper<PetOrder>().eq(PetOrder::getPetOrderId,petOrderId));
    }

    @Override
    public void updatePetOrder(PetOrder petOrder) {
        this.update(petOrder, new LambdaQueryWrapper<PetOrder>().eq(PetOrder::getPetOrderId, petOrder.getPetOrderId()));
    }

    @Override
    public PetOrder findPetOrderByPetOrderId(String petOrderId) {
        return this.getOne(new LambdaQueryWrapper<PetOrder>().eq(PetOrder::getPetOrderId, petOrderId));
    }

    @Override
    public List<PetOrder> findPetOrderList(PetOrder petOrder) {
        LambdaQueryWrapper<PetOrder> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(petOrder.getCusId())) {
            queryWrapper.eq(PetOrder::getCusId, petOrder.getCusId());
        }
        if (StringUtils.isNotBlank(petOrder.getPetId())) {
            queryWrapper.eq(PetOrder::getPetId, petOrder.getPetId());
        }
        return this.list(queryWrapper);
    }
}
