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
 * 商店信息
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Shop implements Serializable {

    private static final long serialVersionUID = 7457027946696246980L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商店id
     */
    private String shopId;

    /**
     * 商店名
     */
    private String shopName;

    /**
     * 商店地址
     */
    private String shopAddress;

    /**
     * 店主
     */
    private String shopKeeper;

    /**
     * 钱包（保密）
     */
    private BigDecimal wallet;


}
