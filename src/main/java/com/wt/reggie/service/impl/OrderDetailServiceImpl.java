package com.wt.reggie.service.impl;

import com.wt.reggie.entity.OrderDetail;
import com.wt.reggie.mapper.OrderDetailMapper;
import com.wt.reggie.service.IOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

}
