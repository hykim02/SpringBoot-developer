package me.kimheeyoung.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.kimheeyoung.springbootdeveloper.domain.Article;
import me.kimheeyoung.springbootdeveloper.dto.AddArticleRequest;
import me.kimheeyoung.springbootdeveloper.dto.ArticleResponse;
import me.kimheeyoung.springbootdeveloper.dto.UpdateArticleRequest;
import me.kimheeyoung.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final이나 @NotNull이 붙은 필드의 생성자 추가
@RestController // http responseBody에 객체 데이터를 json 형식으로 반환
public class BlogApiController {

    private final BlogService blogService;

    // 블로그 글 생성 api
    // http 메서드가 post일 때 전달받은 url과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    // requestBody로 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED) // 응답코드 201
                .body(savedArticle);
    }

    // 블로그 글 전체 조회 api
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    // 블로그 글 하나 조회 api
    @GetMapping("/api/articles/{id}")
    // URL 경로에서 값 추출
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    // 블로그 글 삭제
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    // 블로그 글 수정
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                 @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}
