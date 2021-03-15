package com.mzl.constant;

/**
 * @ClassName :   ParamConfig
 * @Description: 短信发送的参数配置
 * @Author: mzl
 * @CreateDate: 2020/9/16 16:43
 * @Version: 1.0
 */
public class ParamConfig {

    /**
     * 手机验证部分配置
     */
    // 设置超时时间-可自行调整
    public final static String defaultConnectTimeout  = "sun.net.client.defaultConnectTimeout";
    public final static String defaultReadTimeout = "sun.net.client.defaultReadTimeout";
    public final static String Timeout = "10000";
    // 初始化ascClient需要的几个参数
    public final static String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
    public final static String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
    // 替换成你的AK (产品密)
    public final static String accessKeyId = "LTAI4G5T7a47zr5TeVRkqdc4";// 你的accessKeyId,填你自己的 上文配置所得  自行配置
    public final static String accessKeySecret = "HgB9XGiy73Veh7dC1YSXUDRQ4zIE9J";// 你的accessKeySecret,填你自己的 上文配置所得 自行配置
    // 必填:短信签名-可在短信控制台中找到
    public final static String SignName = "MZL管理系统";    // 阿里云配置你自己的短信签名填入
    // 必填:短信模板-可在短信控制台中找到
    public final static String TemplateCode = "SMS_202810051"; // 阿里云配置你自己的短信模板填入

}
