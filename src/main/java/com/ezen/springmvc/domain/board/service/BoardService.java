package com.ezen.springmvc.domain.board.service;

import com.ezen.springmvc.domain.board.dto.BoardDTO;

import java.util.List;

/**
 * 게시판 관련 서비스 인터페이스
 *
 * @author 김종원
 */
public interface BoardService {

    /**
     * 신규 게시판 생성
     *
     * @param boardDTO 게시판 정보
     */
    public void regist(BoardDTO boardDTO);

    /**
     * 전체 게시판 목록 검색
     *
     * @return 게시판 목록
     */
    public List<BoardDTO> getBoardList();

    /**
     * 특정 게시판 정보 조회
     *
     * @param boardId 게시판 번호
     * @return 게시판 정보
     */
    public BoardDTO getBoard(int boardId);

}
