package com.company.heartbeatsignal.util;

import com.alibaba.fastjson.JSONObject;
import com.company.heartbeatsignal.dto.other.IdCardDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UnCheckedException;
import com.company.heartbeatsignal.exception.UserException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liquid
 * @类名： idCardVerifiedUtils
 * @描述：
 * @date 2019/5/11
 */
public class IdCardVerifiedUtils {

    private static final String APP_CODE = "ff76f95c53bd45169d49b8f4d221c83f";
    private static final String URL = "http://idcard3.market.alicloudapi.com/idcardAudit";

    public static IdCardDTO idCardVerified(IdCardDTO idCardDTO) throws CheckedException {
//        参数

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + APP_CODE);

        String params = "idcard=" + idCardDTO.getIdCard() + "&name=" + idCardDTO.getRealName();

        String response = HttpRequestUtils.sendGetWithStringParams(URL, params, headers);

        JSONObject responseJson = JsonUtils.toJSONObject(response);
        if ("0".equals(responseJson.get("showapi_res_code").toString())) {
            throw new UnCheckedException("身份证验证失败 " + responseJson.get("showapi_res_error"));
        } else {
            String showApiResBody = responseJson.get("showapi_res_body").toString();
            JSONObject dataJson = JsonUtils.toJSONObject(showApiResBody);
            if (!"0".equals(dataJson.get("msg"))) {
                throw new UserException("身份证和姓名不匹配");
            }
        }

        return idCardDTO;

    }

    public static void main(String[] args) throws CheckedException {
        IdCardDTO idCardDTO = new IdCardDTO();
        idCardDTO.setIdCard("350823199710096318");
        idCardDTO.setRealName("饶旺琦");
        idCardVerified(idCardDTO);
    }
}
