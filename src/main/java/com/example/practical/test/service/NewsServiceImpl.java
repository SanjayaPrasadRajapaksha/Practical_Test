package com.example.practical.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.practical.test.entity.Comment;
import com.example.practical.test.entity.News;
import com.example.practical.test.entity.NewsCategory;
import com.example.practical.test.repository.CommentRepository;
import com.example.practical.test.repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public News addNews(News news) {

        if (news.getHeadline() == null ||
            news.getHeadline().isBlank() ||
            news.getDescription() == null ||
            news.getDescription().isBlank() ||
            news.getNewsCategory() == null) {

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Required all fields"
            );
        }

        return newsRepository.save(news);
    }

    @Override
    public News updateNews(News news, Long id) {

        News existingNews = newsRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "News not found with id: " + id
            ));

        if (news.getHeadline() == null ||
            news.getHeadline().isBlank() ||
            news.getDescription() == null ||
            news.getDescription().isBlank() ||
            news.getNewsCategory() == null) {

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Required all fields"
            );
        }

        existingNews.setHeadline(news.getHeadline());
        existingNews.setDescription(news.getDescription());
        existingNews.setNewsCategory(news.getNewsCategory());

        return newsRepository.save(existingNews);
    }

    @Override
    public News getNewsById(Long id) {

        return newsRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "News not found with id: " + id
            ));
    }

    @Override
    public List<News> getNewsByCategory(NewsCategory category) {

        return newsRepository.findByNewsCategory(category);
    }

    @Override
    public News putComment(Long newsId, String content) {

        News existingNews = newsRepository.findById(newsId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "News not found with id: " + newsId
            ));

        if (content == null || content.isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Comment content is required"
            );
        }

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setNews(existingNews);

        commentRepository.save(comment);

        return existingNews;
    }
}