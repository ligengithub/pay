package com.example.pay.controller;

import com.alipay.api.AlipayApiException;
import com.example.pay.config.pay.AliPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author ligen
 * @title: PayController
 * @projectName demo
 * @description:
 * @date 2019/6/1013:25
 */

@Api(tags = "支付宝测试")
@RestController
public class PayController {

    Logger logger = LoggerFactory.getLogger("PayController.class");

    @Autowired
    AliPayService aliPayService;

    @ApiOperation("支付接口")
    @RequestMapping(value = "alipay/toPay/{amount}", method = RequestMethod.GET)
    public String alipay(@PathVariable(value = "amount") Integer amount) throws AlipayApiException {
        return aliPayService.aliPay(amount);
    }

    @ApiOperation("支付异步通知接口")
    @GetMapping("alipay/notify_url")
    public String notifyAlipay() {

        logger.info("----notify-----");
        return " a li pay notify ";
    }

    @ApiOperation("支付完成以后的回调接口")
    @GetMapping("alipay/return_url")
    public String returnAlipay() {
        logger.info("----return-----");
        return " a li pay return ";
    }
}
