package com.ezen.springmvc.domain.board.service;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    @Disabled
    void regist() {
    }

    @Test
    void getBoardList() {
        //given
        //when
        List<BoardDTO> list = boardService.getBoardList();
        //then
        Assertions.assertThat(list)
                .isNotNull();
    }

    @Test
    void getBoard() {
        //given
        int boardId = 10;
        //when
        BoardDTO boardDTO = boardService.getBoard(boardId);
        //then
        Assertions.assertThat(boardDTO)
                .isNotNull();
    }
}