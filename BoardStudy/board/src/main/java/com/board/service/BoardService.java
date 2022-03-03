package com.board.service;

import java.util.List;


import com.board.entity.Board;
import com.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Transactional
@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;

    // 글 작성 처리
    public void write(Board board) {    

        // System.out.println("Service write 함수 내부 1 제목 : " + board.getTitle() + "\n");
        // System.out.println("Service write 함수 내부 1 내용 : " + board.getTitle() + "\n");
        boardRepository.save(board);
        // System.out.println("Service write 함수 내부 2 제목 : " + board.getTitle() + "\n");
        // System.out.println("Service write 함수 내부 2 내용 : " + board.getTitle() + "\n");
    }

    
    // 게시글 리스트 처리
    public List<Board> boardList() {

        return boardRepository.findAll();
    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer id) {

        boardRepository.deleteById(id);
    }

}
