package com.wt.reggie.dto;

import com.wt.reggie.entity.Setmeal;
import com.wt.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    /**
     * 套餐菜品关系
     */
    private List<SetmealDish> setmealDishes;

    /**
     * 套餐分类名称
     */
    private String categoryName;
}
