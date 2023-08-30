package com.wt.reggie.mapper;

import com.wt.reggie.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 员工信息 Mapper 接口
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
