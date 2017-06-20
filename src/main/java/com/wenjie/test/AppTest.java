package com.wenjie.test;

import com.wenjie.dubboconsumer.ConsumerThd;

/**
 * Created by wenjie.zhou on 2017/6/19.
 */
public class AppTest {
    public static void main(String[] args){   //用于启动客户端Consumer
        ConsumerThd thd = new ConsumerThd();
        thd.run();
    }
}
