package com.mzl.controller;

import com.alibaba.fastjson.JSONObject;
import com.mzl.utils.SendSMSUtil;
import org.apache.http.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName :   MessageVerify2Controller
 * @Description: 发送短信控制器（阿里云的短信服务平台）
 * @Author: mzl
 * @CreateDate: 2020/9/16 1:27
 * @Version: 1.0
 */
@Controller
@RequestMapping("MessageVerify2Controller")
public class MessageVerify2Controller {

    /**
     * 验证码通知短信(阿里云短信服务)
     * @return
     */
    @RequestMapping(value = "/sendSMS", produces = "application/json;charset=utf-8")
    public ResponseEntity<String> sendSMS(String phoneNumber, HttpServletRequest request) throws Exception{
        //发送的目标用户手机号
        System.out.println(phoneNumber);

        // 发送短信
        SendSMSUtil sendSMS = new SendSMSUtil();
        String result = sendSMS.senSMSUtil(phoneNumber);

        // 获取验证码
        int code = sendSMS.getCode();
        System.out.println("code:" + code);
        request.getSession().setAttribute("code", code);
        request.getSession().setAttribute("createTime", System.currentTimeMillis());

        // 将验证码生成时间存入SESSION，若超过五分钟则不通过校验
        final HttpSession session=request.getSession();
        try {
            // Timer 和 TimerTask都是java.util包下
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    session.removeAttribute("code");
                    System.err.println("code删除成功");
                    timer.cancel();
                }
            }, 5 * 60 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap map = new HashMap();
        if (result == null || !result.equals("OK")) {// 发送不成功
            System.out.println("发送失败");
            map.put("msg", "发送失败");
//            return ResponseEntity.ok("发送失败");
        }else {
            System.out.println("发送成功");
            map.put("msg", "发送成功");
//            return ResponseEntity.ok("发送成功");
        }

        //hashMap转换为json字符串
        String string = JSONObject.toJSONString(map);
        return ResponseEntity.ok(string);
    }

    /**
     * 验证码通知短信(阿里云短信服务)
     * @return
     */
    @RequestMapping("/getSMS")
    public ResponseEntity<String> getSMS(HttpServletRequest request){
        Integer code = (Integer) request.getSession().getAttribute("code");
        System.out.println(code);
        HashMap hashMap = new HashMap();
        hashMap.put("code", code);
        String string = JSONObject.toJSONString(hashMap);
        return ResponseEntity.ok(string);
    }


}
