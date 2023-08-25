package com.ezen.springmvc.domain.board.service;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.common.web.PageParams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    @Transactional
    void writeNewTest() {
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
    void writeReplyTest() {
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
    void getCountArticleTest() {
        //given
        int boardId = 10;
        String type = "";
        String keyword = "제목";
        //when
        int count = articleService.getCountArticle(boardId, type, keyword);
        //then
        assertThat(count)
                .isNotZero();
    }

    @Test
    void getArticleListTest() {
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
        assertThat(list)
                .isNotNull();
    }

    @Test
    void getArticleTest() {
        //given
        int articleId = 1;
        //when
        ArticleDTO articleDTO = articleService.getArticle(articleId);
        //then
        assertThat(articleDTO)
                .isNotNull();
    }

    @Test
    @Transactional
    void updateArticleTest() {
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
    void deleteArticleTest() {
        //given
        int articleId = 1;
        //when
        articleService.deleteArticle(articleId);
        //then
    }
}