package com.mx.petshop.sys.service;

import com.mx.petshop.sys.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商店信息 服务类
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
public interface IShopService extends IService<Shop> {

    /**
     * 添加商家
     * @param shop 商家
     */
    void addShop(Shop shop);

    /**
     * 删除商家
     * @param shopId 商家Id
     */
    void deleteShop(String shopId);

    /**
     * 更新商家信息
     * @param shop 商家
     */
    void updateShop(Shop shop);

    /**
     * 根据商家Id，查询商家
     * @param shopId 商家Id
     * @return 商家
     */
    Shop findShopByShopId(String shopId);

    /**
     * 根据商家信息，查询商家列表
     * @param shop 商家信息
     * @return 商家列表
     */
    List<Shop> findShopList(Shop shop);
}
