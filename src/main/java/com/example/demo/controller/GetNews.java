package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.FeedMessageRepository;
import com.example.demo.vo.FeedMessage;

@Controller
public class GetNews {

    private final FeedMessageRepository feedMessageRepository;

    public GetNews(FeedMessageRepository feedMessageRepository) {
        this.feedMessageRepository = feedMessageRepository;
    }

    @RequestMapping("/GetAllNews")
    public @ResponseBody List<FeedMessage> getAllNews(HttpServletResponse response, @RequestParam(value="title", required=true) String title) {
        response.setCharacterEncoding("UTF-8");

        List<FeedMessage> messages = feedMessageRepository.findByTitle(title);

        return messages;
    }

}