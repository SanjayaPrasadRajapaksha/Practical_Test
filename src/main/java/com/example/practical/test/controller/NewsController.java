package com.example.practical.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.practical.test.entity.News;
import com.example.practical.test.entity.NewsCategory;
import com.example.practical.test.service.NewsService;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping
    public ResponseEntity<News> addNews(
            @RequestBody News news) {

        return ResponseEntity.status(201)
                .body(newsService.addNews(news));
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(
            @RequestBody News news,
            @PathVariable Long id) {

        return ResponseEntity.ok(
                newsService.updateNews(news, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                newsService.getNewsById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<News>> getNewsByCategory(
            @PathVariable NewsCategory category) {

        return ResponseEntity.ok(
                newsService.getNewsByCategory(category));
    }

    @PostMapping("/{newsId}/comments")
    public ResponseEntity<News> putComment(
            @PathVariable Long newsId,
            @RequestBody Map<String, String> request) {

        return ResponseEntity.status(201).body(
                newsService.putComment(
                        newsId,
                        request.get("content")));
    }
}