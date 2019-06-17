package com.mx.petshop.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mx.petshop.sys.entity.Pet;
import com.mx.petshop.sys.entity.Shop;
import com.mx.petshop.sys.entity.Variety;
import com.mx.petshop.sys.mapper.PetMapper;
import com.mx.petshop.sys.service.IPetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mx.petshop.sys.service.IShopService;
import com.mx.petshop.sys.service.IVarietyService;
import com.mx.petshop.sys.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 宠物信息 服务实现类
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements IPetService {

    @Autowired
    private IShopService shopService;

    @Autowired
    private IVarietyService varietyService;

    @Override
    public void addPet(Pet pet) {
        String petId = "pet$" + DateUtil.formatFullTime(LocalDateTime.now());
        pet.setPetId(petId);

        this.save(pet);
    }

    @Override
    public void deletePet(String petId) {
        this.remove(new LambdaQueryWrapper<Pet>().eq(Pet::getPetId, petId));
    }

    @Override
    public void updatePet(Pet pet) {
        this.update(pet, new LambdaQueryWrapper<Pet>().eq(Pet::getPetId, pet.getPetId()));
    }

    @Override
    public Pet findPetByPetId(String petId) {
        Pet pet = this.getOne(new LambdaQueryWrapper<Pet>().eq(Pet::getPetId, petId));
        Shop shop = this.shopService.findShopByShopId(pet.getShopId());
        Variety variety = this.varietyService.findVarietyByVarietyId(pet.getVarietyId());

        pet.setShopName(shop.getShopName());

        pet.setVarietyGenus(variety.getVarietyGenus());
        pet.setVarietySubspecies(variety.getVarietySubspecies());
        pet.setOriginalPrice(variety.getOriginalPrice());

        return pet;
    }

    @Override
    public List<Pet> findPetList(Pet pet) {
        return this.baseMapper.petList(pet);
//        return this.list(new LambdaQueryWrapper<Pet>().eq(Pet::getPetState, 0));
    }

}
