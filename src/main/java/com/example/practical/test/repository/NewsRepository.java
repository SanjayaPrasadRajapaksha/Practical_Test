package com.example.practical.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practical.test.entity.News;
import com.example.practical.test.entity.NewsCategory;

public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findByNewsCategory(NewsCategory category);
}
