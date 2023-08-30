package com.wt.reggie.service.impl;

import com.wt.reggie.entity.AddressBook;
import com.wt.reggie.mapper.AddressBookMapper;
import com.wt.reggie.service.IAddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地址管理 服务实现类
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements IAddressBookService {

}
