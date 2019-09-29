package com.kk.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myConfig")
public class MyConfig {

    private static Logger logger = Logger.getLogger(MyConfig.class);

    @Value(value="${upload_type}")
    private String uploadType;

    @Value(value="${ue_upload_prefix}")
    private String ueUploadPrefix;

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public String getUeUploadPrefix() {
        return ueUploadPrefix;
    }

    public void setUeUploadPrefix(String ueUploadPrefix) {
        this.ueUploadPrefix = ueUploadPrefix;
    }

    private static MyConfig instance;
    public static MyConfig getInstance() {
        if (instance == null) {
            logger.info("第一次调用：初始化MyConfig类");
            instance = (MyConfig) SpringContextUtil.getBean("myConfig");
        }
        return instance;
    }

}
