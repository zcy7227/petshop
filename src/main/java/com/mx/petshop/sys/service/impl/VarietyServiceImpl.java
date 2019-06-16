package com.mx.petshop.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mx.petshop.sys.entity.Variety;
import com.mx.petshop.sys.mapper.VarietyMapper;
import com.mx.petshop.sys.service.IVarietyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mx.petshop.sys.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        String varietyId = "variety$" + DateUtil.formatFullTime(LocalDateTime.now());
        variety.setVarietyId(varietyId);

        this.save(variety);
    }

    @Override
    public void deleteVariety(String varietyId) {
        this.remove(new LambdaQueryWrapper<Variety>().eq(Variety::getVarietyId, varietyId));
    }

    @Override
    public void updateVariety(Variety variety) {
        this.update(variety, new LambdaQueryWrapper<Variety>().eq(Variety::getVarietyId, variety.getVarietyId()));
    }

    @Override
    public Variety findVarietyByVarietyId(String varietyId) {
        return this.getOne(new LambdaQueryWrapper<Variety>().eq(Variety::getVarietyId, varietyId));
    }

    @Override
    public List<Variety> findVarietyList(Variety variety) {
        LambdaQueryWrapper<Variety> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(variety.getVarietyGenus())) {
            queryWrapper.eq(Variety::getVarietyGenus, variety.getVarietyGenus());
        }
        if (StringUtils.isNotBlank(variety.getVarietySubspecies())) {
            queryWrapper.eq(Variety::getVarietySubspecies, variety.getVarietySubspecies());
        }
        return this.list(queryWrapper);
    }
}
