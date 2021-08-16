package com.pyjava.shop.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pyjava.shop.user.model.AddressDO;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 电商-公司收发货地址表 Mapper 接口
 * </p>
 *
 * @author zhaojj11
 * @since 2021-08-16
 */
@Component
public interface AddressMapper extends BaseMapper<AddressDO> {

}
