package com.ezen.springmvc.domain.board.service;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.board.mapper.ArticleMapper;
import com.ezen.springmvc.domain.common.web.PageParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;

    /**
     * 신규 게시글 등록
     *
     * @param articleDTO 게시글 정보
     */
    @Override
    @Transactional
    public void writeNew(ArticleDTO articleDTO) {
        articleMapper.create(articleDTO);
    }

    /**
     * 댓글 등록
     *
     * @param articleDTO      댓글 정보
     * @param parentArticleId 부모글 번호
     */
    @Override
    @Transactional
    public void writeReply(ArticleDTO articleDTO, int parentArticleId) {
        ArticleDTO parentArticleDTO = articleMapper.findArticleForReply(parentArticleId);
        articleMapper.updateOrderNo(parentArticleDTO);
        articleMapper.createReply(articleDTO, parentArticleId);
    }

    /**
     * 페이징 계산 후 게시글 전체 갯수 조회
     *
     * @param boardId 게시판 번호
     * @param keyword 검색 키워드
     * @return 게시글 갯수
     */
    @Override
    public int getCountArticle(int boardId, String type, String keyword) {
        return articleMapper.getCountAll(boardId, type, keyword);
    }

    /**
     * 페이징 계산 후 게시글 목록 검색
     *
     * @param pageParams 페이징 정보
     * @return 게시글 목록
     */
    @Override
    public List<ArticleDTO> getArticleList(PageParams pageParams) {
        return articleMapper.findByAll(pageParams);
    }

    /**
     * 게시글 상세 조회
     *
     * @param articleId 게시글 번호
     * @return 게시글 정보
     */
    @Override
    public ArticleDTO getArticle(int articleId) {
        articleMapper.updateHitCount(articleId);
        return articleMapper.readArticle(articleId);
    }

    /**
     * 게시글 수정
     *
     * @param articleId  게시글 번호
     * @param articleDTO 수정할 게시글 정보
     */
    @Override
    @Transactional
    public void updateArticle(int articleId, ArticleDTO articleDTO) {
        articleMapper.update(articleId, articleDTO);
    }

    /**
     * 게시글 삭제
     *
     * @param articleId 삭제할 게시글 번호
     */
    @Override
    @Transactional
    public void deleteArticle(int articleId) {
        articleMapper.delete(articleId);
    }
}
