package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.NewsRepository;
import com.example.demo.vo.News;

@Controller
public class GetNews {

    private final NewsRepository feedMessageRepository;

    public GetNews(NewsRepository feedMessageRepository) {
        this.feedMessageRepository = feedMessageRepository;
    }

    @RequestMapping("/GetAllNews")
    public @ResponseBody List<News> getAllNews(HttpServletResponse response, @RequestParam(value="title", required=true) String title) {
        response.setCharacterEncoding("UTF-8");

        List<News> messages = feedMessageRepository.findByTitle(title);

        return messages;
    }

}