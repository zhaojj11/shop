package com.pyjava.shop.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pyjava.shop.user.model.AddressDO;

/**
 * <p>
 * 电商-公司收发货地址表 服务类
 * </p>
 *
 * @author zhaojj11
 * @since 2021-08-16
 */
public interface AddressService extends IService<AddressDO> {
    /**
     * 查询地址
     * @param id 根据id查询地址
     * @return {@link AddressDO} 地址数据对象
     */
    AddressDO findAddress(Long id);
}
