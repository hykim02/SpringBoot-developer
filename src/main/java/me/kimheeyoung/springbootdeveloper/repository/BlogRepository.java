package me.kimheeyoung.springbootdeveloper.repository;

import me.kimheeyoung.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
