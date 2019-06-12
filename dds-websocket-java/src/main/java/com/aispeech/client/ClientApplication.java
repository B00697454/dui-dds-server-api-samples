package com.aispeech.client;

import com.alibaba.fastjson.JSONObject;

public class ClientApplication {

    private static void doDDSWebSocketRequest(String authType, JSONObject authParams) {
        DDSWebSocketClient ddsWSClient = new DDSWebSocketClient(authType, authParams);
        ddsWSClient.textRequest();
        // ddsWSClient.triggerIntent();
        // ddsWSClient.audioRequest("audio/8k.wav", 3200);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ddsWSClient.close();
    }

    /**
     * alias :       分支号
     * productId:    产品ID
     * deviceName:   设备ID
     * deviceSecret: 设备注册后，auth服务下发的设备密钥
     */
    public static void main(String[] args) {
        JSONObject authParams = new JSONObject();
        authParams.put("alias", "prod");
        authParams.put("ddsServer", "dds.dui.ai");

        // 使用自己产品的相关参数替换下列参数。
        authParams.put("productId", "x");

        // 设备对云端。
        // authParams.put("deviceName", "x");
        // authParams.put("deviceSecret", "x");
        // try {
        //     doDDSWebSocketRequest("deviceName", authParams);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // 云端对云端。
        authParams.put("apiKey", "x");
        try {
            doDDSWebSocketRequest("apiKey", authParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

