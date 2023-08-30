package com.wt.reggie.mapper;

import com.wt.reggie.entity.AddressBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 地址管理 Mapper 接口
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {

}
