package me.minjaehong.springbootdeveloper.contorller;

import lombok.RequiredArgsConstructor;
import me.minjaehong.springbootdeveloper.domain.Article;
import me.minjaehong.springbootdeveloper.dto.AddArticleRequest;
import me.minjaehong.springbootdeveloper.dto.ArticleResponse;
import me.minjaehong.springbootdeveloper.dto.UpdateArticleRequest;
import me.minjaehong.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/api/articles")
  public ResponseEntity<List<ArticleResponse>> findAllArticles() {
    List<ArticleResponse> articles = blogService.findAll()
            .stream()
            .map(ArticleResponse::new)
            .toList();

    return ResponseEntity.ok().body(articles);
  }

  @GetMapping("/api/articles/{id}")
  public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
    Article article = blogService.findById(id);

    return ResponseEntity.ok().body(new ArticleResponse(article));
  }

  @DeleteMapping("/api/articles/{id}")
  public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
    blogService.delete(id);

    return ResponseEntity.ok().build();
  }

  @PutMapping("/api/articles/{id}")
  public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
    Article updateArticle = blogService.update(id, request);

    return ResponseEntity.ok().body(updateArticle);
  }
}
