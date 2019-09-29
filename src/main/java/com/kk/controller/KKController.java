package com.kk.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kk on 2019-1-25.
 */
@Controller
@RequestMapping("/kk")
public class KKController {

    private static Logger logger = Logger.getLogger(KKController.class);

    private String getCodeUrl = "https://open-oauth.jd.com/oauth2/to_login?app_key=YOUR_APPKEY&response_type=code&redirect_uri=YOUR_REDIRECT_URI&state=STATE&scope=snsapi_base";

    private String getAccessTokenUrl = "https://open-oauth.jd.com/oauth2/access_token?app_key=YOUR_APPKEY&app_secret=YOUR_APPSECRET&grant_type=authorization_code&code=CODE";
    private String YOUR_APPKEY = "xxx";
    private String YOUR_APPSECRET = "xxx";
    private String YOUR_REDIRECT_URI = "http://w223g98500.iok.la/kk/resData";

    @RequestMapping(value = "test")
    @ResponseBody
    public Object test() {
        getCodeUrl = getCodeUrl.replace("YOUR_APPKEY",YOUR_APPKEY);
        getCodeUrl = getCodeUrl.replace("YOUR_REDIRECT_URI",YOUR_REDIRECT_URI);
        return getCodeUrl ;
    }

    @RequestMapping(value = "resData")
    @ResponseBody
    public String listUser(String code, String state ) {
        logger.info(code+ "-----" + state);
        getAccessTokenUrl = getAccessTokenUrl.replace("YOUR_APPKEY",YOUR_APPKEY);
        getAccessTokenUrl = getAccessTokenUrl.replace("YOUR_APPSECRET",YOUR_APPSECRET);
        getAccessTokenUrl = getAccessTokenUrl.replace("CODE",code);
        return getAccessTokenUrl;
    }

    public static void main(String[] args) {
        Md5Hash md5 = new Md5Hash("111");
        System.out.println(md5.toString());
    }

}
