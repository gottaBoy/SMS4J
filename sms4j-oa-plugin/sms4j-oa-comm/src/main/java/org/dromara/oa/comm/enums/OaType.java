package org.dromara.oa.comm.enums;

import lombok.Getter;

public enum OaType {
    /**
     * 钉钉
     */
    DINGTALK("dingding", "https://oapi.dingtalk.com/robot/send?access_token=", true),
    /**
     * 微信
     */
    WETALK("wetalk", "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=", true),
    /**
     * 飞书
     */
    BYTETALK("feishu", "https://open.feishu.cn/open-apis/bot/v2/hook/", true),
    ;

    @Getter
    private final String type;
    private final String robotUrl;


    OaType(String type, String robotUrl, boolean enabled) {
        this.type = type;
        this.robotUrl = robotUrl;
    }

    public String getUrl() {
        return robotUrl;
    }
}
