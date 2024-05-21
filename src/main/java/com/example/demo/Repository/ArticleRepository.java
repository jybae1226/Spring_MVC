package com.example.demo.Repository;

import com.example.demo.Model.Article;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ArticleRepository {
    private Map<Long, Article> articles;
    private long currentId=0;

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
        article.setId(++currentId);
        return articles.put(currentId, article);
    }

    public Article updateArticle(Article article) {
        if (articles.containsKey(article.getId())) {
            return articles.put(article.getId(), article);
        }
        return null;
    }

    public void deleteArticle(Long id) {
        articles.remove(id);
    }
}
