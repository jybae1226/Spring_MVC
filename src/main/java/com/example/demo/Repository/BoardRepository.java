package com.example.demo.Repository;

import com.example.demo.Model.Board;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class BoardRepository {
    private Map<Long, Board> boards;
    private long current_id=0;

    public BoardRepository() {
        this.boards = new HashMap<Long, Board>();
    }

    public List<Board> getallBoard() {
        return new ArrayList<Board>(boards.values());
    }

    public Optional<Board> getBoardByid(Long id) {
        return Optional.ofNullable(boards.get(id));
    }

    public Board addBoard(Board board) {
        board.setId(++current_id);
        return boards.put(board.getId(), board);
    }

    public Board updateBoard(Board board) {
        if (boards.containsKey(board.getId())) {
            return boards.put(board.getId(), board);
        }
        return null;
    }

    public void deleteBoard(Long id) {
        boards.remove(id);
    }
}
