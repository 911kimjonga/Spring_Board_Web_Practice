package com.ezen.springmvc.web.board;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.service.ArticleService;
import com.ezen.springmvc.domain.member.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 게시글 관련 컨트롤러
 *
 * @author 김종원
 */
@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    /**
     * 신규 게시글 작성 화면 출력
     *
     * @param model 모델
     * @return 뷰 이름
     */
    @GetMapping("/write")
    public String writeView(@SessionAttribute(value = "loginMember", required = false) MemberDTO member, Model model) {
        if (member == null) {
            return "redirect:/member/login";
        }
        model.addAttribute("state", "writeview");
        return "article/register";
    }

    /**
     * 신규 게시글 작성 기능
     *
     * @param articleDTO 작성할 게시글 정보
     * @param session    세션
     * @param model      모델
     * @return 뷰 이름
     */
    @PostMapping("/write")
    public String writeArticle(@ModelAttribute ArticleDTO articleDTO, HttpSession session, Model model) {
        BoardDTO boardDTO = (BoardDTO) session.getAttribute("board");
        articleDTO.setBoardId(boardDTO.getBoardId());
        articleService.writeNew(articleDTO);
        session.removeAttribute("board");
        return "redirect:/board/" + boardDTO.getBoardId();
    }

    /**
     * 게시글 상세 조회 기능
     *
     * @param articleId 게시글 번호
     * @param model     모델
     * @return 뷰 이름
     */
    @GetMapping("/{aid}")
    public String readArticle(@PathVariable("aid") int articleId, Model model) {
        ArticleDTO articleDTO = articleService.getArticle(articleId);
        model.addAttribute("article", articleDTO);
        return "article/read";
    }

    /**
     * 답글 작성 화면 출력
     *
     * @param parentArticleId 부모 글 번호
     * @param model           모델
     * @return 뷰 이름
     */
    @GetMapping("/{aid}/reply")
    public String replyView(@SessionAttribute(value = "loginMember", required = false) MemberDTO member, @PathVariable("aid") int parentArticleId, Model model) {
        if (member == null) {
            return "redirect:/member/login";
        }

        model.addAttribute("state", "replyview");
        model.addAttribute("aid", parentArticleId);
        return "article/register";
    }

    /**
     * 답글 작성 기능
     *
     * @param parentArticleId 부모 글 번호
     * @param articleDTO      작성할 답글 정보
     * @param model           모델
     * @return 뷰 이름
     */
    @PostMapping("/{aid}/reply")
    public String writeReply(@PathVariable("aid") int parentArticleId, @ModelAttribute ArticleDTO articleDTO, Model model) {
        ArticleDTO parentArticleDTO = articleService.getArticle(parentArticleId);
        articleDTO.setBoardId(parentArticleDTO.getBoardId());
        articleDTO.setGroupNo(parentArticleDTO.getGroupNo());
        articleDTO.setLevelNo(parentArticleDTO.getLevelNo());
        log.info(articleDTO.toString());
        articleService.writeReply(articleDTO, parentArticleId);
        return "redirect:/board/" + parentArticleDTO.getBoardId();
    }

    /**
     * 게시글 수정 화면 출력
     *
     * @param articleId 수정할 게시글 번호
     * @param model     모델
     * @return 뷰 이름
     */
    @GetMapping("/{aid}/edit")
    public String editView(@PathVariable("aid") int articleId, Model model) {
        ArticleDTO articleDTO = articleService.getArticle(articleId);
        model.addAttribute("article", articleDTO);
        model.addAttribute("state", "editview");
        return "article/register";
    }

    /**
     * 게시글 수정 기능
     *
     * @param articleId  수정할 게시글 번호
     * @param articleDTO 수정 후 게시글 정보
     * @param model      모델
     * @return 뷰 이름
     */
    @PostMapping("/{aid}/edit")
    public String editArticle(@PathVariable("aid") int articleId, @ModelAttribute ArticleDTO articleDTO, Model model) {
        ArticleDTO editArticleDTO = articleService.getArticle(articleId);
        articleDTO.setArticleId(articleId);
        articleDTO.setBoardId(editArticleDTO.getBoardId());
        log.info(articleDTO.toString());
        articleService.updateArticle(articleId, articleDTO);
        return "redirect:/article/" + articleId;
    }

    /**
     * 게시글 삭제 기능
     *
     * @param articleId 삭제할 게시글 번호
     * @param model     모델
     * @return 뷰 이름
     */
    @GetMapping("/{aid}/remove")
    public String removeArticle(@PathVariable("aid") int articleId, Model model) {
        ArticleDTO articleDTO = articleService.getArticle(articleId);
        articleService.deleteArticle(articleId);
        return "redirect:/board/" + articleDTO.getBoardId();
    }

}
