package com.wt.reggie.service;

import com.wt.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜品及套餐分类 服务类
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
public interface ICategoryService extends IService<Category> {

    public void remove(Long id);

}
