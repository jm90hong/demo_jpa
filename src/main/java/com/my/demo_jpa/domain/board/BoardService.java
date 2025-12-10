package com.my.demo_jpa.domain.board;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    //게시글 전체 조회
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
}
