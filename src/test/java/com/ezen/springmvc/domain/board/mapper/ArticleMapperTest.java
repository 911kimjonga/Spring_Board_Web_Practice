package com.ezen.springmvc.domain.board.mapper;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.common.web.PageParams;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
//    @Transactional
    void create() {
        //given
        ArticleDTO articleDTO = ArticleDTO.builder()
                .boardId(10)
                .writer("monday")
                .subject("테스트 신규 월요일2 제목")
                .content("테스트 신규 월요일2 내용")
                .passwd("1234")
                .build();
        //when
        articleMapper.create(articleDTO);
        //then
    }

    @Test
    @Transactional
    void createReply() {
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
        articleMapper.createReply(articleDTO, parentArticleId);
        //then
    }

    @Test
    void findArticleForReply() {
        //given
        int parentArticleId = 1;
        //when
        ArticleDTO articleDTO = articleMapper.findArticleForReply(parentArticleId);
        //then
        assertThat(articleDTO)
                .isNotNull();

    }

    @Test
    @Transactional
    void updateOrderNo() {
        //given
        ArticleDTO replyArticleDTO = ArticleDTO.builder()
                .boardId(10)
                .writer("monday")
                .subject("테스트 리플 월요일 제목")
                .content("테스트 리플 월요일 내용")
                .passwd("1234")
                .groupNo(1)
                .levelNo(1)
                .build();
        //when
        articleMapper.updateOrderNo(replyArticleDTO);
        //then
    }

    @Test
    void getCountAll() {
        //given
        int boardId = 20;
        String type = "all";
        String keyword = "신";
        //when
        int count = articleMapper.getCountAll(boardId, type, keyword);
        //then
        log.info("{}", count);
        assertThat(count)
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
                .type("all")
                .keyword("제목")
                .build();
        //when
        List<ArticleDTO> list = articleMapper.findByAll(pageParams);
        //then
        assertThat(list)
                .isNotNull();
    }

    @Test
    @Transactional
    void updateHitCount() {
        //given
        int articleId = 1;
        //when
        articleMapper.updateHitCount(articleId);
        //then
    }

    @Test
    void readArticle() {
        //given
        int articleId = 1;
        //when
        ArticleDTO articleDTO = articleMapper.readArticle(articleId);
        //then
        assertThat(articleDTO)
                .isNotNull();
    }

    @Test
    @Transactional
    void update() {
        //given
        int articleId = 1;
        ArticleDTO articleDTO = ArticleDTO.builder()
                .boardId(10)
                .subject("수정 제목")
                .content("수정 내용")
                .passwd("2345")
                .build();
        //when
        articleMapper.update(articleId, articleDTO);
        //then
    }

    @Test
    @Transactional
    void delete() {
        //given
        int articleId = 1;
        //when
        articleMapper.delete(articleId);
        //then
    }
}