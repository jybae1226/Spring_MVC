package com.example.demo.NewController;

import com.example.demo.DTO.ArticleRequest;
import com.example.demo.DTO.ArticleResponse;
import com.example.demo.DTO.ArticleUpdateRequest;
import com.example.demo.ETC.Model.*;
import com.example.demo.ETC.Service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EveryController {
    private final ArticleService articleService;

    public EveryController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/posts")
    public String posts(@RequestParam(name = "board_id") Long board_id, Model model) {
        List<ArticleResponse> articles = articleService.getArticleByBoardId(board_id);
        Board board = articleService.getBoardById(board_id);
        model.addAttribute("articles", articles);
        model.addAttribute("board_name", board.getName());

        List<String> Names=new ArrayList<>();
        for (ArticleResponse article : articles) {
            Member member=articleService.getMemberById(article.author_id());
            Names.add(member.getName());
        }
        model.addAttribute("names", Names);
        return "article";
    }

    @GetMapping("/articles")
    @ResponseBody
    public ResponseEntity<List<ArticleResponse>> findByBoardId(@RequestParam(name = "boardId") Long boardId) {
        List<ArticleResponse> articles = articleService.getArticleByBoardId(boardId);
        return ResponseEntity.ok(articles);
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleResponse> createArticle(@RequestBody ArticleRequest article) {
        ArticleResponse articleResponse = articleService.addArticle(article);
        return ResponseEntity.ok(articleResponse);
    }

    @GetMapping("/articles/{id}")
    @ResponseBody
    public ResponseEntity<ArticleResponse> readArticle(@PathVariable("id") long id) {
        ArticleResponse article = articleService.getArticleById(id);
        if (article == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(article);
    }

    @PutMapping("/articles/{id}")
    @ResponseBody
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable("id") long id, @RequestBody ArticleUpdateRequest newArticle) {
        ArticleResponse article = articleService.getArticleById(id);
        if (article == null)
            return ResponseEntity.notFound().build();
        else {
        ArticleResponse updatedArticle = articleService.updateArticle(id, newArticle);
        return ResponseEntity.ok(updatedArticle);
        }
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable("id") long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

}
