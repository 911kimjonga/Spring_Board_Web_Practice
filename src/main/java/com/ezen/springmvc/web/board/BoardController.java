package com.ezen.springmvc.web.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @GetMapping("/{id}")
    public String board(@PathVariable int id, Model model) {
        model.addAttribute("bid", id);
        return "list";
    }

    @GetMapping("/{id}/article/regist")
    public String registViewArticle(@PathVariable int id, Model model) {
        return "register";
    }

    @PostMapping("/{bid}/article/regist")
    public String registArticle(@PathVariable int bid, Model model, RedirectAttributes redirectAttributes) {
        int aid = 1;
        return "redirect:/article/" + aid;
    }

}
