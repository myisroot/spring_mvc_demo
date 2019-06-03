package com.spring.mvc.demo.utils;

import com.spring.mvc.demo.model.User;
import com.spring.mvc.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuery {

    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        User user = userService.get(1);
        System.out.println(user);
    }
}
