package com.ezen.springmvc.domain.board.mapper;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @Transactional
    void create() {
        //given
        BoardDTO boardDTO = BoardDTO.builder()
                .category(1)
                .title("질문게시판")
                .description("물어보고 싶은 것 질문하는 게시판입니다.")
                .build();
        //when
        boardMapper.create(boardDTO);
        //then
    }

    @Test
    void findAll() {
        //given
        //when
        List<BoardDTO> list = boardMapper.findAll();
        //then
        Assertions.assertThat(list)
                .isNotNull();
    }

    @Test
    void findById() {
        //given
        int boardId = 10;
        //when
        BoardDTO boardDTO = boardMapper.findById(boardId);
        //then
        Assertions.assertThat(boardDTO)
                .isNotNull();
    }
}