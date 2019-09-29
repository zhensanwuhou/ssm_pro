package com.kk.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.File;

/**
 * @ClassName: QiniuUtil
 * @Description:
 * @author: tianpengw
 * @date 2018年4月24日 下午4:28:31
 */
public class QiniuUtil {
    /**
     * 设置七牛云存储区域
     * Zone.zone0() ：华东
     * Zone.zone1() ：华北
     * Zone.zone2() ：华南
     */
    private static Configuration cfg = new Configuration(Zone.zone0());
    /**
     * 上传控制器
     */
    private final static UploadManager uploadManager = new UploadManager(cfg);
    /**
     * 七牛云外链地址
     */
    private static String qiniu_outside_url = "http://pm1b78h8p.bkt.clouddn.com";

    /**
     * 七牛云账号对应的密钥
     */
    private static final Auth qiniu_auth =
            Auth.create("X728m6YGOOHIGZ2lQK9qhKZXFCC6Fqvgax8zZ_xH",
                        "clKtQ30Cw-Q4cB_gdElRz85_VPvoxgSGI-XiZr6L");
    /**
     * 七牛云上传空间名
     */
    private static final String qiniu_bucket = "zhensan";

    /**
     * @return
     * @Description: 简单上传，使用默认策略
     * @author: tianpengw
     */
    public static String getUpTokenDefault() {
        return qiniu_auth.uploadToken(qiniu_bucket);
    }

    /**
     * @param key
     * @return
     * @Description: 覆盖上传
     * @author: tianpengw
     */
    public static String getUpTokenCover(String key) {
        return qiniu_auth.uploadToken(qiniu_bucket, key);
    }

    /**
     * @param fileFullName 文件全路径
     * @param keyPath      上传文件的路径
     * @param upToken      七牛云上传token
     * @Description: 上传磁盘文件
     * @author: tianpengw
     */
    private static String qiniuUploadFile(String fileFullName, String fileName, String keyPath, String upToken) {
        try {
            if (null != fileFullName && !"".equals(fileFullName) && new File(fileFullName).exists()) {
                if (null == keyPath || "".equals(keyPath)) {
                    keyPath = "file/";
                }
                String key = keyPath + fileName;
                boolean result = upload(fileFullName, key, upToken);
                if (result) {
                    return qiniu_outside_url + "/" + key;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param filePath
     * @param key
     * @param upToken
     * @return
     * @Description: 上传磁盘中的文件
     * @author: tianpengw
     */
    private static boolean upload(String filePath, String key, String upToken) {
        try {
            Response res = uploadManager.put(filePath, key, upToken);
            System.out.println(res.bodyString());
            if (res.isOK()) {
                return true;
            }
        } catch (QiniuException e) {
            System.out.println("上传磁盘文件异常！");
        }
        return false;
    }

    /**
     * @param fileFullName
     * @param keyPath
     * @param keyName      如果覆盖上传此值不为空，如果为空默认上传
     * @return
     * @Description: 上传文件
     * @author: tianpengw
     */
    public static String uploadFile(String fileFullName, String fileName, String keyPath, String keyName) {

        if (null != keyName && !"".equals(keyName)) {
            return qiniuUploadFile(fileFullName, fileName, keyPath, getUpTokenCover(keyName));
        } else {
            return qiniuUploadFile(fileFullName, fileName, keyPath, getUpTokenDefault());
        }
    }

    public static void main(String[] args) {
        System.out.println(uploadFile("d:/123.png", "qwe",null, null));
    }
}