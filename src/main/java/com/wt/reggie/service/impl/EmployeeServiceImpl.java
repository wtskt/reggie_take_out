package com.wt.reggie.service.impl;

import com.wt.reggie.entity.Employee;
import com.wt.reggie.mapper.EmployeeMapper;
import com.wt.reggie.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息 服务实现类
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
