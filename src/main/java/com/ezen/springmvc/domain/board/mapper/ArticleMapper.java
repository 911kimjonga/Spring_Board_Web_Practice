package com.ezen.springmvc.domain.board.mapper;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.common.web.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 게시글 Mapper
 *
 * @author 김종원
 */
@Mapper
public interface ArticleMapper {

    /**
     * 신규 게시글 등록
     *
     * @param articleDTO 게시글 정보
     */
    public void create(ArticleDTO articleDTO);

    /**
     * 댓글 등록
     *
     * @param articleDTO      댓글 정보
     * @param parentArticleId 댓글 번호
     */
    public void createReply(@Param("articleDTO") ArticleDTO articleDTO, @Param("parentArticleId") int parentArticleId);

    /**
     * 댓글 등록을 위한 부모 게시글 조회
     *
     * @param parentArticleId 부모 게시글 번호
     * @return 부모 게시글 정보
     */
    public ArticleDTO findArticleForReply(int parentArticleId);

    /**
     * 댓글 등록 전 orderNo 업데이트
     *
     * @param articleDTO 게시글 정보
     */
    public void updateOrderNo(ArticleDTO articleDTO);

    /**
     * 페이징 계산 후 게시글 전체 갯수 조회
     *
     * @param boardId 게시판 번호
     * @param keyword 검색 키워드
     * @return 게시글 갯수
     */
    public int getCountAll(@Param("boardId") int boardId, @Param("type") String type, @Param("keyword") String keyword);

    /**
     * 페이징 계산 후 게시글 목록 검색
     *
     * @param pageParams 페이징 정보
     * @return 게시글 목록
     */
    public List<ArticleDTO> findByAll(PageParams pageParams);

    /**
     * 게시글 조회 시 조회수 갱신
     *
     * @param articleId 게시글 번호
     */
    public void updateHitCount(int articleId);

    /**
     * 게시글 상세 조회
     *
     * @param articleId 게시글 번호
     * @return 게시글 정보
     */
    public ArticleDTO readArticle(int articleId);

    /**
     * 게시글 수정
     *
     * @param articleId  수정할 게시글 번호
     * @param articleDTO 수정할 게시글 정보
     */
    public void update(@Param("articleId") int articleId, @Param("articleDTO") ArticleDTO articleDTO);

    /**
     * 게시글 삭제
     *
     * @param articleId 삭제할 게시글 번호
     */
    public void delete(int articleId);

}
