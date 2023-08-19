package com.ezen.springmvc.web.home;

import jakarta.servlet.http.HttpSession;
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
public class HomeController {

    @GetMapping("")
    public String home(HttpSession session, Model model) {
        Map<String, Object> board = new HashMap<>();
        board.put("bid", 10);
        board.put("bname", "자유게시판");

        List<Map<String, Object>> boardList = new ArrayList<>();
        boardList.add(board);

        session.setAttribute("boardList", boardList);

        return "index";
    }

}
