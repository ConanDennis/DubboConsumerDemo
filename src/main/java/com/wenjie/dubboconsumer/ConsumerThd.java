package com.wenjie.dubboconsumer;

import com.wenjie.bean.User;
import com.wenjie.dubboserver.HelloWorldInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * Created by wenjie.zhou on 2017/6/19.
 */
public class ConsumerThd implements Runnable {
    public void run() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationConsumer.xml" });
        context.start();
        context.getBean("demoService");

        HelloWorldInterface helloWorld = (HelloWorldInterface) context.getBean("demoService");
        String answer = helloWorld.sayHello("Dennis");
        System.out.println(answer);

        List<User> list  =  helloWorld.getUsers();
        if (list != null && list.size()>0) {
            for (int i=0 ; i<list.size(); i++) {
                System.out.println(list.get(i));
            }
        }

        System.out.println("执行完毕");
    }

    public static void main(String[] args) {
        new Thread(new ConsumerThd()).start();
    }
}
