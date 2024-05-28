package com.example.demo.DAO;

import com.example.demo.ETC.Model.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Repository
public class ArticleDAO {
    private final JdbcTemplate jdbcTemplate;

    public ArticleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<Article> ArticleRowMapper = (resultset, num)->new Article(
            resultset.getLong("id"),
            resultset.getLong("author_id"),
            resultset.getLong("board_id"),
            resultset.getString("Title"),
            resultset.getString("content"),
            resultset.getObject("created_date")
    );

    public void create(Article article) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql="INSERT INTO article (board_id, author_id, title, content) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(connection->{
            PreparedStatement ps=connection.prepareStatement(sql,new String[]{"id"});
                ps.setLong(1, article.getBoard_id());
                ps.setLong(2, article.getauthor_id());
                ps.setString(3, article.getTitle());
                ps.setString(4, article.getContent());
                return ps; }
                , keyHolder);
        Long key= Objects.requireNonNull(keyHolder.getKey()).longValue();
        article.setId(key);
    }

    public List<Article> getAll() {
        String sql = "select * from article";
        return jdbcTemplate.query(sql,ArticleRowMapper);
    }

    public Article getById(Long id) {
        String sql = "select * from article where id = ?";
        return jdbcTemplate.queryForObject(sql,ArticleRowMapper,id);
    }

    public List<Article> getByboardId(Long board_id) {
        String sql = "select * from article where board_id = ?";
        return jdbcTemplate.query(sql,ArticleRowMapper,board_id);
    }

    public Article update(Long id, Article article) {
        String sql = "update article set title = ?, content = ? where id = ?";
        jdbcTemplate.update(sql,article.getTitle(),article.getContent(),id);
        return article;
    }

    public void deleteById(Long id) {
        String sql = "delete from article where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
