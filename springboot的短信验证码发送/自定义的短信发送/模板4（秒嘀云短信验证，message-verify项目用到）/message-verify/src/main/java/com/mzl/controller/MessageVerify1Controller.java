package com.mzl.controller;

import com.mzl.utils.GetMessageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName :   MessageVerify1Controller
 * @Description: 发送短信验证码控制器
 * @Author: mzl
 * @CreateDate: 2020/9/15 20:35
 * @Version: 1.0
 */
@Controller
@RequestMapping("MessageVerify1Controller")
public class MessageVerify1Controller {

    @RequestMapping(value = "/execute", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String execute(){
        String phone = "13652707142";
        String code = GetMessageUtil.getCode(phone);
        System.out.println(code);
        if (StringUtils.isEmpty(code)){
            return "注册失败";
        }else {
            return "注册成功";
        }
    }

}
