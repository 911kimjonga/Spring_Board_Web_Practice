package com.ezen.springmvc.domain.board.mapper;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.common.web.PageParams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    @Disabled
    void create() {
        //given
        //when
        //then
    }

    @Test
    @Disabled
    void createReply() {
        //given
        //when
        //then
    }

    @Test
    void findArticleForReply() {
        //given
        int parentArticleId = 1;
        //when
        ArticleDTO articleDTO = articleMapper.findArticleForReply(parentArticleId);
        //then
        Assertions.assertThat(articleDTO)
                .isNotNull();
    }

    @Test
    @Disabled
    void updateOrderNo() {
        //given
        //when
        //then
    }

    @Test
    void getCountAll() {
        //given
        int boardId = 10;
        String keyword = "제목";
        //when
        int count = articleMapper.getCountAll(boardId, keyword);
        //then
        Assertions.assertThat(count)
                .isNotZero();
    }

    @Test
    void findByAll() {
        //given
        PageParams pageParams = PageParams.builder()
                .elementSize(5)
                .pageSize(5)
                .requestPage(1)
                .rowCount(0)
                .boardId(10)
                .keyword("제목")
                .build();
        //when
        List<ArticleDTO> list = articleMapper.findByAll(pageParams);
        //then
        Assertions.assertThat(list)
                .isNotNull();
    }

    @Test
    @Disabled
    void updateHitCount() {
        //given
        //when
        //then
    }

    @Test
    void readArticle() {
        //given
        int articleId = 1;
        //when
        ArticleDTO articleDTO = articleMapper.readArticle(articleId);
        //then
        Assertions.assertThat(articleDTO)
                .isNotNull();
    }

    @Test
    @Disabled
    void update() {
        //given
        //when
        //then
    }

    @Test
    @Disabled
    void delete() {
        //given
        //when
        //then
    }
}