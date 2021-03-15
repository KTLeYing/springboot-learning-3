package com.mzl.smsdemo1.controller;

import com.mzl.smsdemo1.result.Result;
import com.mzl.smsdemo1.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName :   SmsController
 * @Description: TODO
 * @Author: mzl
 * @CreateDate: 2020/10/25 9:46
 * @Version: 1.0
 */
@RestController
@CrossOrigin  //可以跨域请求
public class SmsController {

    @Autowired
    private SmsService smsService;

    /**
     * 发送短信
     * @param phone
     * @return
     */
    @RequestMapping("/sendSms")
    public Result sendSms1(String phone){
        return smsService.sendSms(phone);
    }

}
