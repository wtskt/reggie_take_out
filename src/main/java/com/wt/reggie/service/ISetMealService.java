package com.wt.reggie.service;

import com.wt.reggie.dto.SetmealDto;
import com.wt.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 * 套餐 服务类
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
public interface ISetMealService extends IService<Setmeal> {

    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐,同时删除套餐和菜品的关系
     * @param ids
     */
    public void removeWithDish(List<Long> ids);

}
