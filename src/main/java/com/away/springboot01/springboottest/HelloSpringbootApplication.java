package com.away.springboot01.springboottest;

import com.away.springboot01.springboottest.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HelloSpringbootApplication {


    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView sayHi(){
        HashMap map = new HashMap();
        Thread t1 = new Thread(){
            StringBuffer buffer = new StringBuffer();
            @Override
            public synchronized void run() {
                for (int i=1;i<=10;i++){
                    map.put("a"+i,i);
                    buffer.append(i);
                    //System.out.println(map);11
                    System.out.println(buffer+"线程1启动次数："+i);

                }
            }
        };


        Thread t2 = new Thread(){
            StringBuilder builder = new StringBuilder();
            @Override
            public synchronized void run() {
                for (int i=1;i<=10;i++){
                    map.put("b"+i,i);
                    builder.append(i);
                    //System.out.println(map);
                    System.out.println(builder+"线程2启动次数111："+i);
                }

            }
        };
        t1.start();
        t2.start();
        System.out.println(map);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("");
        return modelAndView;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringbootApplication.class, args);
        Object o = new Object();
        String str = o.toString();
        System.out.println("这是我新建的Object对象测试"+str);

        Person person = new Person();
        person.setAge(11);
        person.setName("away");
        System.out.println(person);

        change(person);
        System.out.println(person);




    }

    public static void change(Person person){
            person.setName("abc");
            person.setAge(22);
    }



}
