package com.ezen.springmvc.web.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @GetMapping("/{aid}")
    public String readArticle(@PathVariable int aid, Model model) {
        Map<String, Object> article = new HashMap<>();
        article.put("aid", aid);
        article.put("bid", 10);
        article.put("asubject", "글 제목");
        article.put("acontent", "글 내용");
        article.put("awriter", "작성자");
        article.put("aregdate", "2323-01-01");
        model.addAttribute("article", article);

        return "read";
    }

}
