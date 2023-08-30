package com.wt.reggie.mapper;

import com.wt.reggie.entity.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单明细表 Mapper 接口
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}
