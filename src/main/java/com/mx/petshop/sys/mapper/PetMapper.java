package com.mx.petshop.sys.mapper;

import com.mx.petshop.sys.entity.Pet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 宠物信息 Mapper 接口
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Mapper
public interface PetMapper extends BaseMapper<Pet> {

    List<Pet> findPetList(Pet pet);
}
