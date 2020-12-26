package com.wiloon.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class HelloWorld {
    @RequestMapping("/")
    @ResponseBody
    public Map<String, Object> hello(HttpSession session) {
        System.out.println("session: " + session.getId());
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        } else {
            System.out.println("uid:" + uid.toString());
        }
        session.setAttribute("uid", uid);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hello", "world");
        return map;
    }
}