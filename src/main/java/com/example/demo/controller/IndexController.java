package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.vo.Rss;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");

        model.addAttribute("rss", Rss.values());

        return "index";
    }

}