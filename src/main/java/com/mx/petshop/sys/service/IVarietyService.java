package com.mx.petshop.sys.service;

import com.mx.petshop.sys.entity.Variety;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 品种信息 服务类
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
public interface IVarietyService extends IService<Variety> {
    
    /**
     * 添加品种
     * @param variety 品种
     */
    void addVariety(Variety variety);

    /**
     * 删除品种
     * @param varietyId 品种Id
     */
    void deleteVariety(String varietyId);

    /**
     * 更新品种信息
     * @param variety 品种
     */
    void updateVariety(Variety variety);

    /**
     * 根据品种Id，查询品种
     * @param varietyId 品种Id
     * @return 品种
     */
    Variety findVarietyByVarietyId(String varietyId);

    /**
     * 根据品种信息，查询品种列表
     * @param variety 品种信息
     * @return 品种列表
     */
    List<Variety> findVarietyList(Variety variety);
}
