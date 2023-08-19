package com.ezen.springmvc.domain.board.mapper;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @Disabled
    void create() {
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