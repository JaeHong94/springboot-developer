package me.minjaehong.springbootdeveloper.repository;

import me.minjaehong.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
