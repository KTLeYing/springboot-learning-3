package com.mzl.test;

import com.mzl.constant.ConfigConstant;
import com.mzl.utils.GetMessageUtil;
import com.mzl.utils.HttpUtil;
import com.mzl.utils.NumberUtil;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.net.URLEncoder;

/**
 * @ClassName :   SmsApiHttpSendTest
 * @Description: 短信API发送
 * @Author: mzl
 * @CreateDate: 2020/9/14 21:49
 * @Version: 1.0
 */
public class SmsApiHttpSendTest {

    /**
     * 验证码通知短信
     */
    @Test
    public void execute2(){
        String phone = "13652707142";
        String code = GetMessageUtil.getCode(phone);
        System.out.println(code);
        if (StringUtils.isEmpty(code)){
            System.out.println("注册失败");
        }else {
            System.out.println("注册成功");
        }
    }

}
