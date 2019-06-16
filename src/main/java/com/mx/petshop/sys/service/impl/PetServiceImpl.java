package com.mx.petshop.sys.service.impl;

import com.mx.petshop.sys.entity.Pet;
import com.mx.petshop.sys.mapper.PetMapper;
import com.mx.petshop.sys.service.IPetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
