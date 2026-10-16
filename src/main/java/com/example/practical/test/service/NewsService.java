package com.example.practical.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practical.test.entity.Comment;
import com.example.practical.test.entity.News;

import java.util.List;
import com.example.practical.test.entity.News;

import java.util.List;
import com.example.practical.test.entity.News;
import com.example.practical.test.entity.NewsCategory;

public interface NewsService {

    News addNews(News news);

    News updateNews(News news, Long id);

    News getNewsById(Long id);

    List<News> getNewsByCategory(NewsCategory category);

    News putComment(Long newsId, String content);
}