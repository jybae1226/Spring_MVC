package com.example.demo.DTO;

import java.time.LocalDateTime;
import com.example.demo.ETC.Model.Member;
import com.example.demo.ETC.Model.Board;
import com.example.demo.ETC.Model.Article;

public record ArticleResponse(
    Long id,
    String title,
    String content,
    String board,
    String member,
    LocalDateTime time
) {
    public static ArticleResponse of(Article article, Board board, Member member) {

        return new ArticleResponse(article.getId(), article.getTitle(), article.getContent(), board.getName(), member.getName(), LocalDateTime.now());
    }
}
