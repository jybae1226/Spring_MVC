package com.example.demo.Service;

import com.example.demo.Model.*;
import com.example.demo.Repository.*;
import java.util.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ArticleService {
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final ArticleRepository articleRepository;


    public ArticleService(MemberRepository memberRepository, BoardRepository boardRepository, ArticleRepository articleRepository) {
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
        this.articleRepository = articleRepository;
    }

    public List<Article> getallArticle(){
        return articleRepository.getallArticles();
    }

    public Optional<Article> getArticleById(Long id){
        return articleRepository.getArticleByid(id);
    }

    public Article addArticle(Article article){
        article.setCreate_date(LocalDateTime.now());
        article.setUpdate_date(LocalDateTime.now());
        return articleRepository.addArticle(article);
    }

    public Article updateArticle(Article article){
        if(article.getId()==null) {
            return null;
        }
        article.setUpdate_date(LocalDateTime.now());
        return articleRepository.updateArticle(article);
    }

    public void deleteArticle(Long id){
        articleRepository.deleteArticle(id);
    }

    public String getMemberName(Long id){
        Optional<Member> member=memberRepository.getmemberByid(id);
        return member.map(Member::getName).orElse(null);
    }

    public String getBoardName(Long id){
        Optional<Board> board=boardRepository.getBoardByid(id);
        return board.map(Board::getName).orElse(null);
    }
}
