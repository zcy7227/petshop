package com.mx.petshop.sys.service.impl;

import com.mx.petshop.sys.entity.Shop;
import com.mx.petshop.sys.mapper.ShopMapper;
import com.mx.petshop.sys.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商店信息 服务实现类
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Override
    public void addShop(Shop shop) {

    }

    @Override
    public void deleteShop(String shopId) {

    }

    @Override
    public void updateShop(Shop shop) {

    }

    @Override
    public Shop findShopByShopId(String shopId) {
        return null;
    }

    @Override
    public List<Shop> findShopList(Shop shop) {
        return null;
    }
}
