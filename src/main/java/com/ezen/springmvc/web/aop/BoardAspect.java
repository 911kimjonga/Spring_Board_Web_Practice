package com.ezen.springmvc.web.aop;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@Component
@Aspect
@RequiredArgsConstructor
@Slf4j
public class BoardAspect {

    private final BoardService boardService;

    @Around(value = "@annotation(org.springframework.web.bind.annotation.GetMapping) && execution(* com.ezen.springmvc.web..*(.., org.springframework.ui.Model, ..)) && args(.., model)")
    public Object addBoardList(ProceedingJoinPoint joinPoint, Model model) {
        Object object = null;

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("-- 세부 컨트롤러 이름 : {}", className);
        log.info("-- 세부 메소드 이름 : {}", methodName);

        try {
            List<BoardDTO> boardList = boardService.getBoardList();
            model.addAttribute("boardList", boardList);

            object = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return object;
    }

}
