package com.board.controller;

import javax.swing.text.AbstractDocument.Content;

import com.board.entity.Board;
import com.board.repository.BoardRepository;
import com.board.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.engine.AttributeName;

import net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable;

@Controller
public class BoardController {
    
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // localhost:8080/board/write
    public String boardWriteForm() {

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {

        // System.out.println("Controller 내부 1 제목 : " + board.getTitle()+ "\n");
        // System.out.println("Controller 내부 1 내용 : " + board.getContent()+ "\n");
        boardService.write(board);
        // System.out.println("Controller 내부 2 제목 : " + board.getTitle()+ "\n");
        // System.out.println("Controller 내부 2 내용 : " + board.getContent()+ "\n");
        return "";
    }

    // @PostMapping("/board/writepro")
    // public String boardWritePro(String title, String content) {

    //     System.out.println("제목 : " + title);
    //     System.out.println("내용 : " + content);
    //     return "";
    // }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {

        boardService.boardDelete(id);

        return "redirect:/board/list";
    }
}
