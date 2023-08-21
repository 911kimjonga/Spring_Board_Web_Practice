package com.ezen.springmvc.domain.board.service;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.common.web.PageParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    /**
     * 신규 게시글 등록
     *
     * @param articleDTO 게시글 정보
     */
    public void writeNew(ArticleDTO articleDTO);

    /**
     * 댓글 등록
     *
     * @param articleDTO      댓글 정보
     * @param parentArticleId 부모글 번호
     */
    public void writeReply(@Param("articleDTO") ArticleDTO articleDTO, @Param("parentArticleId") int parentArticleId);

    /**
     * 페이징 계산 후 게시글 전체 갯수 조회
     *
     * @param boardId 게시판 번호
     * @param keyword 검색 키워드
     * @return 게시글 갯수
     */
    public int getCountArticle(@Param("boardId") int boardId, @Param("type") String type, @Param("keyword") String keyword);

    /**
     * 페이징 계산 후 게시글 목록 검색
     *
     * @param pageParams 페이징 정보
     * @return 게시글 목록
     */
    public List<ArticleDTO> getArticleList(PageParams pageParams);

    /**
     * 게시글 상세 조회
     *
     * @param articleId 게시글 번호
     * @return 게시글 정보
     */
    public ArticleDTO getArticle(int articleId);

    /**
     * 게시글 수정
     *
     * @param articleId  게시글 번호
     * @param articleDTO 수정할 게시글 정보
     */
    public void updateArticle(@Param("articleId") int articleId, @Param("articleDTO") ArticleDTO articleDTO);

    /**
     * 게시글 삭제
     *
     * @param articleId 삭제할 게시글 번호
     */
    public void deleteArticle(int articleId);

}
