package com.example.demo.DAO;

import com.example.demo.ETC.Model.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAO {
    private final JdbcTemplate jdbcTemplate;

    public MemberDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<Member> memberRowMapper = (resultset, num)->new Member(
            resultset.getString("name"),
            resultset.getString("email"),
            resultset.getString("password")
    );

    public List<Member> getAll() {
        String sql = "select * from members";
        return jdbcTemplate.query(sql,memberRowMapper);
    }

    public Member getById(Long id) {
        String sql = "select * from members  where id = ?";
        return jdbcTemplate.queryForObject(sql,memberRowMapper,id);
    }
}
