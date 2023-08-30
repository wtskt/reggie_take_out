package com.wt.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wt.reggie.common.CustomException;
import com.wt.reggie.entity.Category;
import com.wt.reggie.entity.Dish;
import com.wt.reggie.entity.Setmeal;
import com.wt.reggie.mapper.CategoryMapper;
import com.wt.reggie.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.reggie.service.IDishService;
import com.wt.reggie.service.ISetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜品及套餐分类 服务实现类
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private IDishService dishService;

    @Autowired
    private ISetMealService setMealService;

    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {

        // 查询当前分类是否关联了菜品, 如果已经关联，抛出一个业务异常
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);        // 添加查询条件
        int dishCount = dishService.count(dishLambdaQueryWrapper); // 查询该类别下的菜品数量
        if (dishCount > 0) {
            // 已关联菜品，抛出异常
            throw new CustomException("当前类别关联了菜品，不能删除");
        }

        // 查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setMealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setMealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int setMealCount = setMealService.count(setMealLambdaQueryWrapper);
        if (setMealCount > 0) {
            // 已关联套餐，抛出异常
            throw new CustomException("当前类别关联了套餐，不能删除");
        }

        // 正常删除分类
        this.remove(id);
    }
}
