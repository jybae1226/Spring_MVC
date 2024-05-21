package com.example.demo.Service;

import com.example.demo.Repository.BoardRepository;
import com.example.demo.Model.Board;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getallBoard() {
        return boardRepository.getallBoard();
    }

    public Optional<Board> getBoardById(Long id) {
        return boardRepository.getBoardByid(id);
    }

    public Board addBoard(Board board) {
        return boardRepository.addBoard(board);
    }

    public Board updateBoard(Long id,Board board) {
        Optional<Board> updated = boardRepository.getBoardByid(id);
        if(updated.isPresent()){
            return boardRepository.updateBoard(id, board);
        } else {
            return null;
        }
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteBoard(id);
    }
}
