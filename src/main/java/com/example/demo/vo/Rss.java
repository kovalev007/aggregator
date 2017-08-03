package com.example.demo.vo;

public enum Rss {

    MEDUZA("https://meduza.io/rss/all"),
    RAMBLER("https://news.rambler.ru/rss/head/"),
    LENTA("https://lenta.ru/rss/news");

    private String url;

    Rss(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}