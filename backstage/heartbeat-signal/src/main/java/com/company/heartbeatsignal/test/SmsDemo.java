package com.company.heartbeatsignal.test;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsDemo {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIi0RJvaAqHP7c";
    static final String accessKeySecret = "tZrn9qponvfg3NaFkSFWwSz5qpl0GO";

    public static SendSmsResponse sendSms(String phoneNum) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNum);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("心动App");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_164269606");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        String code = SmsDemo.getRandomCode(6);
        request.setTemplateParam("{\"code\":\""+code+"\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");

        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        if (sendSmsResponse.getCode() != null && "OK".equals(sendSmsResponse.getCode())) {
            System.out.println("发送验证码成功！");
        }
        else {
            System.out.println(sendSmsResponse.getCode());
        }
        return sendSmsResponse;
    }

    //随机返回num位数
    public static String getRandomCode(int num)
    {
        String randomCode = "";
        for(;num>0;num--) {
            randomCode += (int)(Math.random()*10);
        }
        return randomCode;
    }

    //获取当前时间戳
    public static String getTimeStamp()
    {
        return  new SimpleDateFormat("yyyy-MM-dd-HH：mm：ss").format(new Date());
    }

    public static void main(String[] args) throws ClientException,NullPointerException {

        //发短信
        SendSmsResponse response = sendSms("15768235796");

        System.out.println(SmsDemo.getTimeStamp());
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());
    }
}