package com.example.pay.config.pay;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ligen
 * @title: AliPayConfig
 * @projectName demo
 * @description:
 * @date 2019/6/1014:20
 */
@Configuration
public class AliPayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
//    netapp映射的地址，，，根据自己的需要修改
    private static String neturl = "http://6dynnj.natappfree.cc";

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号 按照我文章图上的信息填写
    public static String app_id = "2016092800619078";

    // 商户私钥，您的PKCS8格式RSA2私钥  刚刚生成的私钥直接复制填写
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCbcKDceiSoZyzXR+tC0/zlZesV6YHFViiDP0lzVrk2tpU2yY/+znq8M26dRS/2THuKUeaC7aGSUXzAoDgfvwiqQp6qxo/0nYK/bVnC1ucvBkyb9MnK0DCDSfrmModGwF4WfjEDL9DvU7HTagID5qjrdgZz6LIQlUFrm7ecS1hSwSxbnx6+1EO4VihemazGOK4lCBQ16hVjPIfrHEwzR9VW3zbXjw8hHHG3Q26FrwaL03l4ZG8C6Cux3kMp+dOGitQBFMwLjr+GNzxDyArsT+h7LNgrMCvf2ZQ4plHlidqPOizlNP4cprB2yccmf2CmVztl5LZVQgI4OYPzvx02INVZAgMBAAECggEAGr8lnuqRljyytZSVgdlSYfLIoeudPeSWcgcYz3Tzx9thD51dXr4O1oWPGhbGqv38IA/5tzvGmpPVAJxRK/1GM23lOYOTT8cusVvSnzk1bJ0L36Yedvyd7Gl1d9jn+B+v0PUD4AWBUT04kyVhlWRCWsnjUFyRD1Nvf2G7FXTNjOeUlnOhmqRACwDRsSLhxSNwmBaLFL9i27F3k/ZjW+kgorlgNXCS8HWIFupLqAcObQAH43OOWXMaWf3NoxTe8tP1HD8BRcacl6tnLrC1ElcGMJ1yrEJ2hzvYa8qSuB2cOYuuy2ljYlLzIXvvYJEFqnSrTcaNt2nNRBVCbmPRzhjVgQKBgQDyF6Y9iEVFvFNQLvSCNvtppYl7CNm+BEfaEAS3U2+nn0JSj19okvhQ5IuMiGb3kH5NQKT+3eyH8tPGIKcmiPVkjF/WjmxZXVrihBiko6Tk9Pl3t8sQKJI5ln10kizfqdjgdzu+AYF8GCtk+pBsaKimWxGp6Gqn5f2WI7jigKZAsQKBgQCkXp5HSyyoglYkQif+oerkNfZu99eHinGTA27E4WCIEiT8dnqCmJKrhDtgimALE25OKulfGIhSnEg4mGVy58UniMWh6I74TYAYxrPJSDwJ9PHa3JDheMwBFgDailxEwwNDUwX3uAZdvmpsgw0St7cfjdu1jIUo1eNtshk/l25JKQKBgDx1mYe+c4Zh7PCWeWvXrVwKAlaetDpXOVaFL5hVFwpmpJqXwb0ND0Ssfwleu1BSXqiOX2ZjKAIfq7HMT9I43Af7Yqfjs71xqhPt53WehLzFTVQPq3/ikfod0kD9jIVjFo2gWWQvXhYOty+lv9HDJXM+RSAIsjIyJu2LCE5Q0LRRAoGBAIlsVjbTIiZMukqcSSX6KBHfEAddDYTT+frpDs5qhDOfv+6X+/t+JnpiFuazKnN4LmwKMo2ATFGNOlCfEYqNPme8UUf50LbGzQdp8dyimRfWA/NxH2xze1SZGeOddGFFDlBWdJHU+PWdgwrwUpjIosEt8HiMYLRwhzIqijOBnwJpAoGBAKF1G5Nzzx7Zan/Hm/KEr3drDvUlZQOU1e/tIQZE3JEnHRwK3rfXsCNMSBqb6+d0FPP6oys1cnupQD9c1lU4UhIyBrxoe/hkoseBceDc4WhpBjcgZ4tYdUjTd1ppDEtGeXq1nUJBaE7f1yD45gSfbM1cQKlnXjr3WMJH8IjirNka";

    // 支付宝公钥,对应APPID下的支付宝公钥。 按照我文章图上的信息填写支付宝公钥，别填成商户公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm3Cg3HokqGcs10frQtP85WXrFemBxVYogz9Jc1a5NraVNsmP/s56vDNunUUv9kx7ilHmgu2hklF8wKA4H78IqkKeqsaP9J2Cv21ZwtbnLwZMm/TJytAwg0n65jKHRsBeFn4xAy/Q71Ox02oCA+ao63YGc+iyEJVBa5u3nEtYUsEsW58evtRDuFYoXpmsxjiuJQgUNeoVYzyH6xxMM0fVVt82148PIRxxt0Nuha8Gi9N5eGRvAugrsd5DKfnThorUARTMC46/hjc8Q8gK7E/oeyzYKzAr39mUOKZR5Ynajzos5TT+HKawdsnHJn9gplc7ZeS2VUICODmD878dNiDVWQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
    public static String notify_url = neturl+"/alipay/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
    public static String return_url = neturl+"/alipay/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
