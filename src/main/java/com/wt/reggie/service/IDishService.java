package com.wt.reggie.service;

import com.wt.reggie.dto.DishDto;
import com.wt.reggie.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜品管理 服务类
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
public interface IDishService extends IService<Dish> {

    public void saveWithFlavor(DishDto dishDto);

    /**
     * 根据id查询菜品信息和对应的口味信息
     * @param id
     * @return
     */
    public DishDto getByIdWithFlavor(Long id);

    /**
     * 修改菜品
     * @param dishDto
     */
    public void updateWithFlavor(DishDto dishDto);
}
