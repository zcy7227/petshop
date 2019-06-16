package com.mx.petshop.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;

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

    private static final long serialVersionUID = 1L;

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
     * 宠物品种
     */
    private String petVar;

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


}
