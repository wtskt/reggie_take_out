package com.wt.reggie.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.javafx.collections.MappingChange;
import com.wt.reggie.entity.User;
import com.wt.reggie.service.IUserService;
import com.wt.reggie.utils.SMSUtils;
import com.wt.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wt.reggie.common.R;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author wt
 * @since 2023-08-09
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 发送手机短信验证码
     * @param user
     * @return R
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        // 获取手机号
        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)) {
            // 生成验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("用户登录验证码: " + code);

            // 调用阿里云提供的短信API完成发送短信
//        SMSUtils.sendMessage("瑞吉外卖", "SMS_285075068", phone, code);

            // 将手机和短信保存到Session
            session.setAttribute(phone, code);

            return R.success("手机验证码发送成功");
        }
        return R.error("验证码发送失败");
    }

    /**
     * 移动端用户登录
     * @param map
     * @param session
     * @return R
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map<String, String> map, HttpSession session) {
        log.info("移动端用户登录: " + map.toString());
        // 获取手机号
        String phone = map.get("phone");
        // 获取验证码
        String code = map.get("code");

        // 比较session中的验证码
        Object codeInSession = session.getAttribute(phone);
        if (codeInSession != null && codeInSession.equals(code)) {
            // 登录成功,判断是否为第一次登录
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);
            if (user == null) {
                // 第一次登录，创建用户
                user = new User();
                user.setStatus(1);
                user.setPhone(phone);
                userService.save(user);
            }
            // 用户id存入session
            session.setAttribute("user", user.getId());
            // 返回用户给前端
            return R.success(user);
        }
        return R.error("登录失败");
    }
}

