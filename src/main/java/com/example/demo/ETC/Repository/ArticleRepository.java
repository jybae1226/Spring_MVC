package com.example.demo.ETC.Repository;

import com.example.demo.ETC.Model.Article;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ArticleRepository {
    private Map<Long, Article> articles;
    private long currentId=1;

    public ArticleRepository() {
        this.articles = new HashMap<Long, Article>();
    }

    public List<Article> getallArticles() {
        return new ArrayList<Article>(articles.values());
    }

    public Optional<Article> getArticleByid(Long id) {
        return Optional.ofNullable(articles.get(id));
    }

    public Article addArticle(Article article) {
        article.setId(currentId++);
        articles.put(article.getId(), article);
        return article;
    }

    public Article updateArticle(Long id, Article article) {
        if (articles.containsKey(id)) {
            article.setId(id);
            articles.put(id, article);
            return article;
        }
        return null;
    }

    public void deleteArticle(Long id) {
        articles.remove(id);
    }
}
