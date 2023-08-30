package com.wt.reggie.service.impl;

import com.wt.reggie.entity.User;
import com.wt.reggie.mapper.UserMapper;
import com.wt.reggie.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
