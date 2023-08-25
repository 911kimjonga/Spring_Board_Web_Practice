package com.ezen.springmvc.domain.board.service;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    @Transactional
    void registTest() {
        //given
        BoardDTO boardDTO = BoardDTO.builder()
                .category(1)
                .title("질문게시판")
                .description("물어보고 싶은 것 질문하는 게시판입니다.")
                .build();
        //when
        boardService.regist(boardDTO);
        //then
    }

    @Test
    void getBoardListTest() {
        //given
        //when
        List<BoardDTO> list = boardService.getBoardList();
        //then
        assertThat(list)
                .isNotNull();
    }

    @Test
    void getBoardTest() {
        //given
        int boardId = 10;
        //when
        BoardDTO boardDTO = boardService.getBoard(boardId);
        //then
        assertThat(boardDTO)
                .isNotNull();
    }
}