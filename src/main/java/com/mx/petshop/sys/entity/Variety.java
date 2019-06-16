package com.mx.petshop.sys.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 品种信息
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Variety implements Serializable {

    private static final long serialVersionUID = 5714937350148980024L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 品种id
     */
    private String varietyId;

    /**
     * 生物属
     */
    private String varietyGenus;

    /**
     * 生物亚种
     */
    private String varietySubspecies;

    /**
     * 原始价格
     */
    private BigDecimal originalPrice;


}
