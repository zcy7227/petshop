package com.mx.petshop.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户Id
     */
    private String cusId;

    /**
     * 登录邮箱
     */
    private String cusEmail;

    /**
     * 密码
     */
    private String cusPw;

    /**
     * 创建时间
     */
    private LocalDateTime createBy;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedBy;


}
