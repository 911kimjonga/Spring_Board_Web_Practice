package com.ezen.springmvc.web.board;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @GetMapping("/{bid}")
    public String board(@PathVariable int bid, Model model) {
        model.addAttribute("bid", bid);
        return "list";
    }

    @GetMapping("/{bid}/article/write")
    public String writeView(@PathVariable int bid, Model model) {
        model.addAttribute("bid", bid);
        return "register";
    }

    @PostMapping("/{bid}/article/write")
    public String writeArticle(@PathVariable int bid, @ModelAttribute ArticleDTO articleDTO, Model model) {
        log.info("{}", articleDTO);
//        return "redirect:/article/" + aid;
        return "redirect:/board/" + bid;
    }

}
