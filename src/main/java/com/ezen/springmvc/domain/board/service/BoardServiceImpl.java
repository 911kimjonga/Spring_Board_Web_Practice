package com.ezen.springmvc.domain.board.service;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BoardService 구현체
 *
 * @author 김종원
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    /**
     * 신규 게시판 생성
     *
     * @param boardDTO 게시판 정보
     */
    @Override
    public void regist(BoardDTO boardDTO) {
        boardMapper.create(boardDTO);
    }

    /**
     * 전체 게시판 목록 검색
     *
     * @return 게시판 목록
     */
    @Override
    public List<BoardDTO> getBoardList() {
        return boardMapper.findAll();
    }

    /**
     * 특정 게시판 정보 조회
     *
     * @param boardId 게시판 번호
     * @return 게시판 정보
     */
    @Override
    public BoardDTO getBoard(int boardId) {
        return boardMapper.findById(boardId);
    }
}
