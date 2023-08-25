package com.ezen.springmvc.domain.board.mapper;

import com.ezen.springmvc.domain.board.dto.BoardDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @Transactional
    void createTest() {
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
    void findAllTest() {
        //given
        //when
        List<BoardDTO> list = boardMapper.findAll();
        //then
        assertThat(list)
                .isNotNull();
    }

    @Test
    void findByIdTest() {
        //given
        int boardId = 10;
        //when
        BoardDTO boardDTO = boardMapper.findById(boardId);
        //then
        assertThat(boardDTO)
                .isNotNull();
    }
}