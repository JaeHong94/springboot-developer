package me.minjaehong.springbootdeveloper.contorller;

import lombok.RequiredArgsConstructor;
import me.minjaehong.springbootdeveloper.domain.Article;
import me.minjaehong.springbootdeveloper.dto.AddArticleRequest;
import me.minjaehong.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

  private final BlogService blogService;

  @PostMapping("/api/articles")
  public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
    Article savedArticle = blogService.save(request);
    // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
    return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
  }
}