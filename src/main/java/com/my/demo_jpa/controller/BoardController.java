package com.my.demo_jpa.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.my.demo_jpa.domain.board.BoardService;
import com.my.demo_jpa.domain.board.Board;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;
import java.util.List;



@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllBoards() {
        List<Board> boards = boardService.getAllBoards();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "게시글 전체 조회 성공");
        response.put("boards", boards);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
