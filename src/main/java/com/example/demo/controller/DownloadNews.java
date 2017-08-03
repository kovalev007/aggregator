package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.FeedParser;
import com.example.demo.dao.FeedMessageRepository;
import com.example.demo.vo.Feed;
import com.example.demo.vo.FeedMessage;
import com.example.demo.vo.Rss;

@Controller
public class DownloadNews {

    private final FeedMessageRepository feedMessageRepository;

    public DownloadNews(FeedMessageRepository feedMessageRepository) {
        this.feedMessageRepository = feedMessageRepository;
    }

    @RequestMapping("/DownloadNews")
    public @ResponseBody Feed hello(@RequestParam(value = "rss", required = true) Rss rss) {
        FeedParser parser = new FeedParser(rss.getUrl());
        Feed feed = parser.readFeed();
        for (FeedMessage message : feed.getMessages()) {
            feedMessageRepository.save(message);
        }

        return feed;
    }

}