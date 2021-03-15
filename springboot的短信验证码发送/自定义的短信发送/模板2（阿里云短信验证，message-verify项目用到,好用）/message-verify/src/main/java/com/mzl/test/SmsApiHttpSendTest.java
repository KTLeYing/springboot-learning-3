package com.mzl.test;

import com.mzl.constant.ConfigConstant;
import com.mzl.utils.GetMessageUtil;
import com.mzl.utils.HttpUtil;
import com.mzl.utils.NumberUtil;
import com.mzl.utils.SendSMSUtil;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
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
     * 验证码通知短信(阿里云短信服务)
     */
    @Test
    public void execute3(){
        //发送的目标用户手机号
        String phoneNumber = "13652707142";

        // 发送短信
        SendSMSUtil sendSMS = new SendSMSUtil();
        String result = sendSMS.senSMSUtil(phoneNumber);

        if (result == null || !result.equals("OK")) {// 发送不成功
            System.out.println("发送失败");
        }else {
            System.out.println("发送成功");
        }

        // 获取验证码
        int code = sendSMS.getCode();
        System.out.println("checkCode:" + code);
    }

}
