package com.example.demo.NewController;

import com.example.demo.DTO.ArticleRequest;
import com.example.demo.DTO.ArticleResponse;
import com.example.demo.DTO.ArticleUpdateRequest;
import com.example.demo.ETC.Model.*;
import com.example.demo.ETC.Service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Controller
public class EveryController {
    private final ArticleService articleService;

    public EveryController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/posts")
    public String posts(@RequestParam(name="board_id") Long board_id, Model model) {
        List<ArticleResponse> articles=articleService.getArticleByBoardId(board_id);
        Board board=articleService.getBoardById(board_id);
        model.addAttribute("articles",articles);
        model.addAttribute("board_name",board.getName());

        for(ArticleResponse article : articles) {
            Member member=articleService.getMemberById(article.id());
            model.addAttribute("user_name",member.getName());
        }
        return "article";
    }

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> getArticleByBoradId(@RequestParam(name="board_id") Long board_id) {
        List<ArticleResponse> articles;
        if (board_id != null) {
            articles=articleService.getArticleByBoardId(board_id);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable Long id) {
        ArticleResponse article=articleService.getArticleById(id);
        if (article==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(article,HttpStatus.OK);
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleResponse> addArticle(@RequestBody ArticleRequest article) {
        ArticleResponse articleResponse=articleService.addArticle(article);
        return new ResponseEntity<>(articleResponse,HttpStatus.CREATED);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable Long id, @RequestBody ArticleUpdateRequest article) {
        ArticleResponse articleResponse=articleService.updateArticle(id,article);
        return new ResponseEntity<>(articleResponse,HttpStatus.OK);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
