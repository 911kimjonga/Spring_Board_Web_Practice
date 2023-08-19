package com.ezen.springmvc.domain.board.mapper;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 게시판 Mapper
 *
 * @author 김종원
 */
@Mapper
public interface BoardMapper {

    /**
     * 신규 게시판 생성
     *
     * @param boardDTO 게시판 정보
     */
    public void create(BoardDTO boardDTO);

    /**
     * 전체 게시판 목록 검색
     *
     * @return 게시판 목록
     */
    public List<BoardDTO> findAll();

    /**
     * 특정 게시판 정보 조회
     *
     * @param boardId 게시판 번호
     * @return 게시판 정보
     */
    public BoardDTO findById(int boardId);

}
