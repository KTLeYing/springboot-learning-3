package com.mzl.controller;

import com.alibaba.fastjson.JSONObject;
import com.mzl.utils.SMSCodeUtil;
import com.mzl.utils.SendSMSUtil;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
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
@RequestMapping("MessageVerify3Controller")
public class MessageVerify3Controller {


    @RequestMapping(value = "/sendSMS", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String sendSMS(String phoneNumber, HttpServletRequest request){
        System.out.println(phoneNumber);

        //发送短信
        String result = SMSCodeUtil.getPhonemsg(phoneNumber);

        //获取验证码
        String code = SMSCodeUtil.getCode();
        System.out.println(code);
        //将验证码存入session中
        request.getSession().setAttribute("code", code);
        //将创建时间存入session中
        request.getSession().setAttribute("createTime", System.currentTimeMillis());

        //将验证码生成时间存入SESSION，若超过五分钟则不通过校验
        final HttpSession session = request.getSession();
        try {
            //使用Timer和TimerTask来做定时任务，都在java.util包下
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {  //要做的具体实现的任务
                    session.removeAttribute("code");
                    System.err.println("code删除成功");
                    timer.cancel();
                }
            }, 5 * 60 * 1000); //5分钟。5x60*1000,1000是毫秒转换为秒
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap map = new HashMap();
        if (result == null || !result.equals("true")){
            map.put("msg", "发送失败");
        }else {
            map.put("msg", "发送成功");
        }

        //object转换为json字符串
        String string = JSONObject.toJSONString(map);
        return string;
    }

    @RequestMapping("/getSMS")
    @ResponseBody
    public String getSMS(HttpServletRequest request){
        String code = (String) request.getSession().getAttribute("code");
        System.out.println(code);

        HashMap map = new HashMap();
        map.put("code", code);
        //object转换为json字符串
        String string = JSONObject.toJSONString(map);
        return string;
    }


}
