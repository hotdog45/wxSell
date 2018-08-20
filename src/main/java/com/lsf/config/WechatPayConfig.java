package com.lsf.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by lishunfeng on 2018/8/17.
 */
@Component
public class WechatPayConfig {
    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Bean
    public BestPayServiceImpl bestPayService(){


        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config());
        return bestPayService;
    }

    @Bean
    public WxPayH5Config wxPayH5Config() {
        WxPayH5Config payH5Config = new WxPayH5Config();
        payH5Config.setAppId(wechatAccountConfig.getMpAppId());
        payH5Config.setAppSecret(wechatAccountConfig.getMpAppSecret());
        payH5Config.setKeyPath(wechatAccountConfig.getKeyPath());
        payH5Config.setMchId(wechatAccountConfig.getMchId());
        payH5Config.setMchKey(wechatAccountConfig.getMchKey());
        payH5Config.setNotifyUrl(wechatAccountConfig.getNotifyUrl());
        return payH5Config;
    }

}
