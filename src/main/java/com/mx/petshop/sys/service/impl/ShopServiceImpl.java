package com.mx.petshop.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mx.petshop.sys.entity.Shop;
import com.mx.petshop.sys.mapper.ShopMapper;
import com.mx.petshop.sys.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mx.petshop.sys.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        String shopId = "shop$" + DateUtil.formatFullTime(LocalDateTime.now());
        shop.setShopId(shopId);

        this.save(shop);
    }

    @Override
    public void deleteShop(String shopId) {
        this.remove(new LambdaQueryWrapper<Shop>().eq(Shop::getShopId, shopId));
    }

    @Override
    public void updateShop(Shop shop) {
        this.update(shop, new LambdaQueryWrapper<Shop>().eq(Shop::getShopId, shop.getShopId()));
    }

    @Override
    public void updateWallet(String shopId, BigDecimal money) {
        Shop shop = this.findShopByShopId(shopId);
        shop.setWallet(shop.getWallet().add(money));
    }

    @Override
    public Shop findShopByShopId(String shopId) {
        return this.getOne(new LambdaQueryWrapper<Shop>().eq(Shop::getShopId, shopId));
    }

    @Override
    public List<Shop> findShopList(Shop shop) {
        LambdaQueryWrapper<Shop> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(shop.getShopName())) {
            queryWrapper.eq(Shop::getShopName, shop.getShopName());
        }
        if (StringUtils.isNotBlank(shop.getShopAddress())) {
            queryWrapper.eq(Shop::getShopAddress, shop.getShopAddress());
        }
        if (StringUtils.isNotBlank(shop.getShopKeeper())) {
            queryWrapper.eq(Shop::getShopKeeper, shop.getShopKeeper());
        }
        return this.list(queryWrapper);
    }
}
