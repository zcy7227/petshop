package com.mx.petshop.sys.service;

import com.mx.petshop.sys.entity.Pet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宠物信息 服务类
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
public interface IPetService extends IService<Pet> {

    /**
     * 添加宠物
     * @param pet 宠物
     */
    void addPet(Pet pet);

    /**
     * 删除宠物
     * @param petId 宠物Id
     */
    void deletePet(String petId);

    /**
     * 更新宠物信息
     * @param pet 宠物
     */
    void updatePet(Pet pet);

    /**
     * 根据宠物Id，查询宠物
     * @param petId 宠物Id
     * @return 宠物
     */
    Pet findPetByPetId(String petId);

    /**
     * 根据宠物信息，查询宠物列表
     * @param pet 宠物信息
     * @return 宠物列表
     */
    List<Pet> findPetList(Pet pet);
}
