package com.example.demo.ETC.Service;

import com.example.demo.ETC.Model.*;
import com.example.demo.DAO.*;
import com.example.demo.DTO.*;
import java.util.*;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class ArticleService {
    private ArticleDAO articleDAO;
    private BoardDAO boardDAO;
    private MemberDAO memberDAO;

    private ArticleService(ArticleDAO articleDAO, BoardDAO boardDAO, MemberDAO memberDAO) {
        this.articleDAO = articleDAO;
        this.boardDAO = boardDAO;
        this.memberDAO = memberDAO;
    }


    public List<ArticleResponse> getallArticle() {
        List<Article> articles = articleDAO.getAll();
        return articles.stream().map(article -> {
            Member member = memberDAO.getById(article.getUser_id());
            if (member == null) {
                throw new IllegalArgumentException("Member not found");
            }
            Board board = boardDAO.getById(article.getBoard_id());
            if (board == null) {
                throw new IllegalArgumentException("Board not found");
            }
            return ArticleResponse.of(article, board, member);
        }).toList();
    }

    public ArticleResponse getArticleById(Long id){
        Article article = articleDAO.getById(id);
        if (article == null) {
            throw new IllegalArgumentException("Article not found");
        }
        Member member = memberDAO.getById(article.getUser_id());
        if (member == null) {
            throw new IllegalArgumentException("Member not found");
        }
        Board board = boardDAO.getById(article.getBoard_id());
        if (board == null) {
            throw new IllegalArgumentException("Board not found");
        }
        return ArticleResponse.of(article, board, member);
    }

    public List<ArticleResponse> getArticleByBoardId(Long boardId) {
        List<Article> articles=articleDAO.getByboardId(boardId);
        return articles.stream().map(article -> {
            Member member = memberDAO.getById(article.getUser_id());
            if (member == null) {
                throw new IllegalArgumentException("Member not found");
            }
            Board board = boardDAO.getById(article.getBoard_id());
            if (board == null) {
                throw new IllegalArgumentException("Board not found");
            }
            return ArticleResponse.of(article, board, member);
        }).toList();
    }

    public ArticleResponse addArticle(ArticleRequest request){
        Article article=new Article(
                request.board_id(),
                request.user_id(),
                request.title(),
                request.content()
        );
        articleDAO.create(article);
        Member member=memberDAO.getById(article.getUser_id());
        if(member == null){
            throw new IllegalArgumentException("Member not found");
        }
        Board board=boardDAO.getById(article.getBoard_id());
        if(board == null) {
            throw new IllegalArgumentException("Board not found");
        }
        return ArticleResponse.of(article, board, member);
    }

    public ArticleResponse updateArticle(Long id, ArticleUpdateRequest request){
        Article article = articleDAO.getById(id);
        if(article == null){
            throw new IllegalArgumentException("Article not found");
        }
        article.setBoard_id(request.board_id());
        article.setTitle(request.title());
        article.setContent(request.content());
        article.setUpdate_date(LocalDateTime.now());

        Article updatedArticle = articleDAO.update(id,article);
        Member member=memberDAO.getById(updatedArticle.getUser_id());
        if(member == null){
            throw new IllegalArgumentException("Member not found");
        }
        Board board=boardDAO.getById(updatedArticle.getBoard_id());
        if(board == null) {
            throw new IllegalArgumentException("Board not found");
        }
        return ArticleResponse.of(updatedArticle, board, member);
    }

    public void deleteArticle(Long id) {
        articleDAO.deleteById(id);
    }

    public Board getBoardById(Long id){
        Board board=boardDAO.getById(id);
        if (board == null) {
            throw new IllegalArgumentException("Board not found");
        }
        return board;
    }
}
