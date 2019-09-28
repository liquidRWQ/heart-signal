package com.company.heartbeatsignal;

import com.company.heartbeatsignal.context.pay.wechat.WeChatPay;
import com.company.heartbeatsignal.dto.other.PayDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeartbeatSignalApplicationTests {
    @Autowired
    private WeChatPay weChatPay;

    @Test
    public void contextLoads() throws Exception {
        PayDTO payDTO = new PayDTO();
        payDTO.setUserOpenid("oeqGA4grMbK3mSdQ7E9hM3plFgbg");
        payDTO.setProductName("啊哈哈哈");
        payDTO.setTotalFee("50");
        payDTO.setIp("125.90.48.147");
        weChatPay.pay(payDTO);

    }
}
