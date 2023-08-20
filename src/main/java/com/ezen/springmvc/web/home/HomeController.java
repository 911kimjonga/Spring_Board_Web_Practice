package com.ezen.springmvc.web.home;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final BoardService boardService;

    @GetMapping("")
    public String home(HttpSession session, Model model) {
        List<BoardDTO> boardList = boardService.getBoardList();

        session.setAttribute("boardList", boardList);

        return "index";
    }

}
