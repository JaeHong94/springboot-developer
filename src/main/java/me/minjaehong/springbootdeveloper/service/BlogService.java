package me.minjaehong.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.minjaehong.springbootdeveloper.domain.Article;
import me.minjaehong.springbootdeveloper.dto.AddArticleRequest;
import me.minjaehong.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {

  private final BlogRepository blogRepository;

  public Article save(AddArticleRequest request) {
    return blogRepository.save(request.toEntity());
  }
}