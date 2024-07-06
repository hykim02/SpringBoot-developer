package me.kimheeyoung.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
// 블로그 글 수정
public class UpdateArticleRequest {
    private String title;
    private String content;
}
