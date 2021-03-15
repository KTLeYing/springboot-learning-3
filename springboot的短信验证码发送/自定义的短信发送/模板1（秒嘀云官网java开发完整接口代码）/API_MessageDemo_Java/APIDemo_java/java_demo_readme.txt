第一步：确保java环境就绪

第二步：展开压缩包，使用编辑器（如IntelliJ IDEA、Eclipse）导入APIDemo_java工程目录，替换APIDemo_java\src\com\miaodiyun\httpapidemo\common\Config.java以下参数

accountSid=cdc1aabbf2d445108cc13271eexxxxxx;  登陆官网开发者中心界面，可以查询到自己的accountSid,将该参数替换为自己的accountSid
auth_token=5ecbeaa30b6c477cb77c2bedb5xxxxxx;  登陆官网开发者中心界面，可以查询到自己的auth_token，将该参数替换为自己的auth_token
to=186xxxxxxxx;  替换为自己的手机号码
templateid=3284; 登陆官网开发者中心界面,创建模版并审核通过，得到模版ID,将该参数替换为已经审核过的模版ID
param=1234;      替换为自己想下发的动态参数

第三步：打开 APIDemo_java\src\com\miaodiyun\httpapidemo\SmsApiHttpSendTest.java 文件，在编辑器执行RUN操作，查看执行结果