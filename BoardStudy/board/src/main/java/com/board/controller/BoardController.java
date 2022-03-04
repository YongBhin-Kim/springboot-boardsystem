package com.board.controller;

// import javax.swing.text.AbstractDocument.Content;

import com.board.entity.Board;
// import com.board.repository.BoardRepository;
import com.board.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.thymeleaf.engine.AttributeName;

// import net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable;

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

        boardService.write(board);
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

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {

        Board boardtmp = boardService.boardView(id);
        boardtmp.setTitle(board.getTitle());
        boardtmp.setContent(board.getContent());

        boardService.write(boardtmp);

        return "redirect:/board/list";
    }
}
