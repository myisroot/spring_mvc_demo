package com.spring.mvc.demo.controller;

import com.spring.mvc.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * springMVC demo
 *
 * @author Route
 */
@SessionAttributes({"user"})
@RequestMapping(value = "/hello")
@Controller // 指定需要被扫描Controller类
public class HelloSpringMVC {

    private final static String SUCCESS = "helloword";

    // 访问路径
    // 当访问字符串始,表示返回一个视图的路径
    // params = {"username"} 指定访问时需要username参数,也可定义表达式
    // headers  指定什么样的请求头才能访问到
    @RequestMapping(value = "/word")
    public String helloWord() {
        return SUCCESS;
    }

    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        User user = new User();
        user.setId(5);
        user.setSex("男");
        user.setUsername("admin");
        map.put("user", user);
        return SUCCESS;
    }

    /**
     * 跳转页面并且将数据放到域中方式2
     * 参数传递map类型（model类型/modelMap）
     *
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("names", Arrays.asList("tom", "root", "admin"));
        return SUCCESS;
    }

    /**
     * @return 跳转页面并且将数据放到域中
     * 原理:addObject,将数据放到request中
     */
    @RequestMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    //Ant通配符
    @RequestMapping("/*/ant")
    public String testAntPath() {

        return SUCCESS;
    }

    @RequestMapping("/login.do")
    public String loginFrom() {
        return "login";
    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        return SUCCESS;
    }

    /**
     * 请求转发,跳转页面
     *
     * @param username
     * @param password
     * @return
     * @RequestParam映射参数值,required:可指定参数是否是必须的,如果不设置并且没有参数是将会报错,defaultValue:指定默认值
     */
//    @RequestMapping("/login")
//    // 获取前端请求参数
//    public String login(@RequestParam(value = "username", required = false) String username, @RequestParam("password") String password) {
//        System.out.println(username);
//        System.out.println(password);
//        // 跳转前加入redirect:然后为路径
//        return "redirect:word";
//    }

    /**
     * 将请求参数封装成一个实体类
     *
     * @return
     */
    @RequestMapping("/login")
    // 获取前端请求参数
    public String login(User user) {
        System.out.println(user);
        // 跳转前加入redirect:然后为路径
        return "redirect:word";
    }

    /**
     * <a href="hello/testPathVariable/1====>id</a>"> Test PathVariable</a>
     * <p>
     * 通过url的占位符获取传递的参数id
     *
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        return SUCCESS;
    }

    /**
     * @param id
     * @return Rest格式的url
     * CRUD:
     * 可将POST请求转化为PUT,DELETE请求;
     * <form action="hello/testREST">
     * <input type="hidden" name="_method" value="PUT">
     * <input type="submit" value="Test PUT">
     * </form>
     * PUT  修改
     * POST 增加
     * DELETE 删除
     * GET  查询
     * web.xml配置
     * 如果要使用,需要传递一个请求方式名
     * <filter>
     * <filter-name>HiddenHttpMethodFilter</filter-name>
     * <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
     * </filter>
     * <filter-mapping>
     * <filter-name>HiddenHttpMethodFilter</filter-name>
     * <url-pattern>/*</url-pattern>
     * </filter-mapping>
     * <p>
     * <p>
     * 传递id/testREST/{id}
     * testREST(@PathVariable("id") Integer id)
     */
    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.GET)
    public String testREST(@PathVariable("id") Integer id) {
        System.out.println("testREST Get" + id);
        return SUCCESS;
    }


    /**
     * 获取cookie值
     *
     * @param sessionId
     * @return
     */
    @RequestMapping(value = "/testCookValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println(sessionId);
        return SUCCESS;
    }
}
