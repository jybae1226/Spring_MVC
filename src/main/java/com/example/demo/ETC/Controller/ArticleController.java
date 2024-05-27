/*package com.example.demo.ETC.Controller;

import com.example.demo.DTO.ArticleResponse;
import com.example.demo.ETC.Model.Article;
import com.example.demo.ETC.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    private final Map<Long, Article> articles = new HashMap<>();

    @Autowired
    private ArticleService;

    @GetMapping("/posts")
    public String post(Model model){
        List<ArticleResponse> articles=articleService.getallArticle();
        model.addAttribute("articles",articles);
        return "article";
    }

    @GetMapping("/articles")
    public ResponseEntity<Map<Long, Article>> getArticles() {
        List<ArticleResponse> articles=articleService.getallArticle();
        if (articles.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Map<Long, Article> map = new HashMap<>();
            for (ArticleResponse article : articles) {
                map.put(article.getId(), article);
            }
            return ResponseEntity.ok().body(map);
        }
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable Long id) {
        ArticleResponse article = articleService.getArticleById(id);
        if (article!=null) {
            return ResponseEntity.ok().body(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleResponse> createArticle(@RequestBody Article article) {
        ArticleResponse created=articleService.addArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable Long id, @RequestBody Article article) {
            ArticleResponse updated=articleService.updateArticle(id, article);
            return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
            articleService.deleteArticle(id);
            return ResponseEntity.noContent().build();
    }
}*/