package com.example.demo.DAO;

import com.example.demo.ETC.Model.Board;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {
    private final JdbcTemplate jdbcTemplate;

    public BoardDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<Board> boardRowMapper = (resultset, num)->new Board(
            resultset.getLong("id"),
            resultset.getString("name")
    );

    public List<Board> getAll() {
        String sql = "select * from board";
        return jdbcTemplate.query(sql,boardRowMapper);
    }

    public Board getById(Long id) {
        String sql = "select * from board where id = ?";
        try {
            return jdbcTemplate.queryForObject(sql,boardRowMapper,id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
