package com.wt.reggie.service;

import com.wt.reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
public interface IOrdersService extends IService<Orders> {

    /**
     * 用户提交订单
     * @param orders
     */
    public void sumbit(Orders orders);
}
