package com.example.demo.Controller;

import com.example.demo.Model.Article;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ArticleController {
    private final Map<Long, Article> articles = new HashMap<>();
    @Autowired
    private ArticleService articleService;

    @GetMapping("/posts")
    public String post(Model model){
        List<Article> articles=articleService.getallArticle();
        String Board_name=articleService.getBoardName(articles.get(0).getBoard_id());
        String User_name=articleService.getMemberName(articles.get(0).getUser_id());
        model.addAttribute("Board_name",Board_name);
        model.addAttribute("User_name",User_name);
        model.addAttribute("articles",articles);
        return "article";
    }

    @GetMapping("/articles")
    public ResponseEntity<Map<Long, Article>> getArticles() {
        List<Article> articles=articleService.getallArticle();
        if (articles.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Map<Long, Article> map = new HashMap<>();
            for (Article article : articles) {
                map.put(article.getId(), article);
            }
            return ResponseEntity.ok().body(map);
        }
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Optional<Article>> getArticle(@PathVariable Long id) {
        Optional<Article> article = articleService.getArticleById(id);
        if (article.isPresent()) {
            return ResponseEntity.ok().body(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article created=articleService.addArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article article) {
            Article updated=articleService.updateArticle(id, article);
            return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
            articleService.deleteArticle(id);
            return ResponseEntity.noContent().build();
    }
}