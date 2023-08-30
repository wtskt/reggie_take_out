package com.wt.reggie.service.impl;

import com.wt.reggie.entity.ShoppingCart;
import com.wt.reggie.mapper.ShoppingCartMapper;
import com.wt.reggie.service.IShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements IShoppingCartService {

}
