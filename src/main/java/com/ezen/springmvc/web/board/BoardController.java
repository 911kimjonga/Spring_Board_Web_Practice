package com.ezen.springmvc.web.board;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.service.ArticleService;
import com.ezen.springmvc.domain.board.service.BoardService;
import com.ezen.springmvc.domain.common.web.PageParams;
import com.ezen.springmvc.domain.common.web.Pagination;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 게시판 관련 컨트롤러
 *
 * @author 김종원
 */
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;
    private final ArticleService articleService;

    // 한 페이지에 보여지는 목록 갯수 설정
    private static final int ELEMENT_SIZE = 3;
    // 한페이지에 보여지는 페이지 갯수 설정
    private static final int PAGE_SIZE = 5;

    /**
     * 게시판 화면 출력
     *
     * @param bid     게시판 번호
     * @param page    페이지 번호
     * @param type    검색 타입
     * @param keyword 검색 키워드
     * @param session 세션
     * @param model   모델
     * @return 뷰 이름
     */
    @GetMapping("/{bid}")
    public String board(@PathVariable int bid,
                        @RequestParam(value = "page", required = false) String page,
                        @RequestParam(value = "type", required = false) String type,
                        @RequestParam(value = "keyword", required = false) String keyword,
                        HttpSession session, Model model) {
        BoardDTO boardDTO = boardService.getBoard(bid);

        log.info("페이지 정보 : {}", page);
        log.info("검색 타입 : {}", type);
        log.info("검색 키워드 : {}", keyword);

        // 사용자 선택페이지
        if (page == null || page.isEmpty()) {
            page = "1";
        }
        int selectPage = Integer.parseInt(page);

        int count = articleService.getCountArticle(bid, type, keyword);
        log.info("글 갯수 : {}", count);
        PageParams pageParams = PageParams.builder()
                .elementSize(ELEMENT_SIZE)
                .pageSize(PAGE_SIZE)
                .requestPage(selectPage)
                .rowCount(count)
                .boardId(bid)
                .type(type)
                .keyword(keyword)
                .build();
        Pagination pagination = new Pagination(pageParams);
        List<ArticleDTO> list = articleService.getArticleList(pageParams);
        log.info(pageParams.toString());
        log.info(pagination.toString());

        session.setAttribute("board", boardDTO);
        model.addAttribute("bid", bid);
        model.addAttribute("articleList", list);
        model.addAttribute("pagination", pagination);
        return "list";
    }

}
