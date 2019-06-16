package com.mx.petshop.sys.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PetOrder implements Serializable {

    private static final long serialVersionUID = -2266594631398477548L;


    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 宠物订单Id
     */
    private String petOrderId;

    /**
     * 顾客id
     */
    private String cusId;

    /**
     * 宠物id
     */
    private String petId;

    /**
     * 交易价格
     */
    private BigDecimal tradePrice;

    /**
     * 交易时间
     */
    private LocalDate tradeTime;


}
