package com.pyjava.shop.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pyjava.shop.user.mapper.UserMapper;
import com.pyjava.shop.user.model.UserDO;
import com.pyjava.shop.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaojj11
 * @since 2021-08-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

}
