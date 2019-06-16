package com.mx.petshop.sys.service.impl;

import com.mx.petshop.sys.entity.Variety;
import com.mx.petshop.sys.mapper.VarietyMapper;
import com.mx.petshop.sys.service.IVarietyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品种信息 服务实现类
 * </p>
 *
 * @author mxwbq
 * @since 2019-06-13
 */
@Service
public class VarietyServiceImpl extends ServiceImpl<VarietyMapper, Variety> implements IVarietyService {

    @Override
    public void addVariety(Variety variety) {

    }

    @Override
    public void deleteVariety(String varietyId) {

    }

    @Override
    public void updateVariety(Variety variety) {

    }

    @Override
    public Variety findVarietyByVarietyId(String varietyId) {
        return null;
    }

    @Override
    public List<Variety> findVarietyList(Variety variety) {
        return null;
    }
}
