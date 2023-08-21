package com.ezen.springmvc.web.board;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.service.ArticleService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    // 신규 게시글 작성 화면
    @GetMapping("/write")
    public String writeView(Model model) {
        return "register";
    }
    
    // 신규 게시글 작성 기능
    @PostMapping("/write")
    public String writeArticle(HttpSession session, @ModelAttribute ArticleDTO articleDTO, Model model) {
        BoardDTO boardDTO = (BoardDTO) session.getAttribute("board");
        articleDTO.setBoardId(boardDTO.getBoardId());
        articleService.writeNew(articleDTO);
        session.removeAttribute("board");
        return "redirect:/board/" + boardDTO.getBoardId();
    }
    
    // 게시글 상세 보기
    @GetMapping("/{aid}")
    public String readArticle(@PathVariable("aid") int articleId, Model model) {
        ArticleDTO articleDTO = articleService.getArticle(articleId);
        model.addAttribute("article", articleDTO);
        return "read";
    }
    
    // 리플 작성 화면
    @GetMapping("/{aid}/reply")
    public String replyView(@PathVariable("aid") int articleId, Model model) {
        model.addAttribute("aid", articleId);
        return "reply";
    }
    
    // 리플 작성 기능
    @PostMapping("/{aid}/reply")
    public String writeReply(@PathVariable("aid") int articleId, @ModelAttribute ArticleDTO articleDTO, Model model) {
        ArticleDTO parentArticleDTO = articleService.getArticle(articleId);
        articleDTO.setBoardId(parentArticleDTO.getBoardId());
        articleDTO.setGroupNo(parentArticleDTO.getGroupNo());
        articleDTO.setLevelNo(parentArticleDTO.getLevelNo());
        log.info(articleDTO.toString());
        articleService.writeReply(articleDTO, articleId);
        return "redirect:/board/" + parentArticleDTO.getBoardId();
    }
    
    // 게시글 수정 화면
    @GetMapping("/{aid}/edit")
    public String editView(@PathVariable("aid") int articleId, Model model) {
        ArticleDTO articleDTO = articleService.getArticle(articleId);
        model.addAttribute("article", articleDTO);
        return "edit";
    }
    
    // 게시글 수정 기능
    @PostMapping("/{aid}/edit")
    public String editArticle(@PathVariable("aid") int articleId, @ModelAttribute ArticleDTO articleDTO, Model model) {
        ArticleDTO editArticleDTO = articleService.getArticle(articleId);
        articleDTO.setArticleId(articleId);
        articleDTO.setBoardId(editArticleDTO.getBoardId());
        log.info(articleDTO.toString());
        articleService.updateArticle(articleId, articleDTO);
        return "redirect:/article/" + articleId;
    }
    
    // 게시글 삭제 기능
    @GetMapping("/{aid}/remove")
    public String removeArticle(@PathVariable("aid") int articleId, Model model) {
        ArticleDTO articleDTO = articleService.getArticle(articleId);
        articleService.deleteArticle(articleId);
        return "redirect:/board/" + articleDTO.getBoardId();
    }

}
