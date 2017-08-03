package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.NewsParser;
import com.example.demo.dao.NewsRepository;
import com.example.demo.vo.News;
import com.example.demo.vo.Rss;

@Controller
public class DownloadNews {

    private final NewsRepository feedMessageRepository;

    public DownloadNews(NewsRepository feedMessageRepository) {
        this.feedMessageRepository = feedMessageRepository;
    }

    @RequestMapping("/DownloadNews")
    public @ResponseBody String downloadNews(@RequestParam(value = "rss", required = true) Rss rss) throws Exception {
        NewsParser parser = new NewsParser(rss.getUrl());

        List<News> messages = parser.readNews();
        for (News message : messages) {
            feedMessageRepository.save(message);
        }

        return "";
    }

}