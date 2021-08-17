package com.pyjava.shop.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pyjava.shop.user.mapper.AddressMapper;
import com.pyjava.shop.user.model.AddressDO;
import com.pyjava.shop.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电商-公司收发货地址表 服务实现类
 * </p>
 *
 * @author zhaojj11
 * @since 1.0
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, AddressDO> implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public AddressDO findAddress(Long id) {
        return addressMapper.selectOne(new QueryWrapper<AddressDO>().eq("id",id));
    }

}
