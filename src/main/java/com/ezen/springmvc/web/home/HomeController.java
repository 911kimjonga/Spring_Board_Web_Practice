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

import java.util.List;

/**
 * 메인 화면 컨트롤러
 *
 * @author 김종원
 */
@Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final BoardService boardService;

    /**
     * 메인 화면 출력 및 네비게이션 바 세팅
     *
     * @param session 세션
     * @param model   모델
     * @return 뷰 이름
     */
    @GetMapping("")
    public String home(HttpSession session, Model model) {

        List<BoardDTO> boardList = boardService.getBoardList();
        session.setAttribute("boardList", boardList);

        return "index";
    }

}
