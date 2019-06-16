package com.mx.petshop.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 宠物信息
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class Pet implements Serializable {

    private static final long serialVersionUID = -3959246250489510619L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 宠物id
     */
    private String petId;

    /**
     * 宠物品种Id
     */
    private String varietyId;

    /**
     * 商家id
     */
    private String shopId;

    /**
     * 宠物状态：0 未出售；1 已出售
     */
    private Integer petState;

    /**
     * 出生日期
     */
    private LocalDate bornDate;

    /**
     * 性别
     */
    private String petSex;

    /**
     * 体重
     */
    private String petWeight;

    /**
     * 简介
     */
    private String petInfo;

    /**
     * 商店名，临时
     */
    private transient String shopName;

    /**
     * 生物属，临时
     */
    private transient String varietyGenus;

    /**
     * 生物亚种，临时
     */
    private transient String varietySubspecies;

    /**
     * 原始价格，临时
     */
    private transient BigDecimal originalPrice;
}
