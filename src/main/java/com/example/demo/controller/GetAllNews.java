package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.FeedMessageRepository;
import com.example.demo.vo.FeedMessage;

@Controller
public class GetAllNews {

    private final FeedMessageRepository feedMessageRepository;

    public GetAllNews(FeedMessageRepository feedMessageRepository) {
        this.feedMessageRepository = feedMessageRepository;
    }

    @RequestMapping("/GetAllNews")
    public @ResponseBody List<FeedMessage> hello(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");

        List<FeedMessage> messages = (List<FeedMessage>) feedMessageRepository.findAll();

        return messages;
    }

}