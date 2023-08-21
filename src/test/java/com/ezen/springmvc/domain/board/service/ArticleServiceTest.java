package com.ezen.springmvc.domain.board.service;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.common.web.PageParams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    @Transactional
    void writeNew() {
        //given
        ArticleDTO articleDTO = ArticleDTO.builder()
                .boardId(10)
                .writer("monday")
                .subject("테스트 신규 월요일 제목")
                .content("테스트 신규 월요일 내용")
                .passwd("1234")
                .build();
        //when
        articleService.writeNew(articleDTO);
        //then
    }

    @Test
    @Transactional
    void writeReply() {
        //given
        ArticleDTO articleDTO = ArticleDTO.builder()
                .boardId(10)
                .writer("monday")
                .subject("테스트 리플 월요일 제목")
                .content("테스트 리플 월요일 내용")
                .passwd("1234")
                .groupNo(1)
                .levelNo(1)
                .build();
        int parentArticleId = 1;
        //when
        articleService.writeReply(articleDTO, parentArticleId);
        //then
    }

    @Test
    void getCountArticle() {
        //given
        int boardId = 10;
        String type = "";
        String keyword = "제목";
        //when
        int count = articleService.getCountArticle(boardId, type, keyword);
        //then
        Assertions.assertThat(count)
                .isNotZero();
    }

    @Test
    void getArticleList() {
        //given
        PageParams pageParams = PageParams.builder()
                .elementSize(5)
                .pageSize(5)
                .requestPage(1)
                .rowCount(0)
                .boardId(10)
                .type("all")
                .keyword("제목")
                .build();
        //when
        List<ArticleDTO> list = articleService.getArticleList(pageParams);
        //then
        Assertions.assertThat(list)
                .isNotNull();
    }

    @Test
    void getArticle() {
        //given
        int articleId = 1;
        //when
        ArticleDTO articleDTO = articleService.getArticle(articleId);
        //then
        Assertions.assertThat(articleDTO)
                .isNotNull();
    }

    @Test
    @Transactional
    void updateArticle() {
        //given
        int articleId = 1;
        ArticleDTO articleDTO = ArticleDTO.builder()
                .boardId(10)
                .subject("수정 제목")
                .content("수정 내용")
                .passwd("2345")
                .build();
        //when
        articleService.updateArticle(articleId, articleDTO);
        //then
    }

    @Test
    @Transactional
    void deleteArticle() {
        //given
        int articleId = 1;
        //when
        articleService.deleteArticle(articleId);
        //then
    }
}