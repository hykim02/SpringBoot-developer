package me.kimheeyoung.springbootdeveloper.dto;

import lombok.Getter;
import me.kimheeyoung.springbootdeveloper.domain.Article;

@Getter
// 블로그 글 목록 조회
public class ArticleResponse {

    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }

}
