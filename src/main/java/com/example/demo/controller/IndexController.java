package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.FeedMessageRepository;
import com.example.demo.vo.FeedMessage;
import com.example.demo.vo.Rss;

@Controller
public class IndexController {

    private final FeedMessageRepository feedMessageRepository;

    public IndexController(FeedMessageRepository feedMessageRepository) {
        this.feedMessageRepository = feedMessageRepository;
    }

    @RequestMapping("/")
    public String hello(Model model, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");

        model.addAttribute("rss", Rss.values());

        Iterable<FeedMessage> messages = feedMessageRepository.findAll();
        model.addAttribute("messages", messages);

        Long messagesCnt = feedMessageRepository.count();
        model.addAttribute("messagesCnt", messagesCnt);

        return "index";
    }

}