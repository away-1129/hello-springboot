package com.away.springboot01.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HelloSpringbootApplication {


    @RequestMapping(value = "",method = RequestMethod.GET)
    public String sayHi(){
        HashMap map = new HashMap();
        Thread t1 = new Thread(){

            @Override
            public synchronized void run() {

                for (int i=1;i<=10;i++){
                    map.put("a"+i,i);
                    //System.out.println(map);
                    System.out.println("线程1启动次数："+i);

                }
            }
        };


        Thread t2 = new Thread(){
            @Override
            public synchronized void run() {
                for (int i=1;i<=10;i++){
                    map.put("b"+i,i);
                    //System.out.println(map);
                    System.out.println("线程2启动次数："+i);
                }

            }
        };
        t1.start();
        t2.start();
        System.out.println(map);
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringbootApplication.class, args);
        Object o = new Object();
        String str = o.toString();
        System.out.println("这是我新建的Object对象"+str);




    }



}
