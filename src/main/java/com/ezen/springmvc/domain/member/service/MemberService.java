package com.ezen.springmvc.domain.member.service;

import com.ezen.springmvc.domain.member.dto.MemberDTO;

import java.util.List;

/**
 * 회원 관련 서비스 인터페이스
 *
 * @author 김종원
 */
public interface MemberService {

    /**
     * 회원 가입
     *
     * @param member 회원 정보
     */
    public void register(MemberDTO member);

    /**
     * 로그인 시 회원 확인
     *
     * @param id     아이디
     * @param passwd 비밀번호
     * @return 회원 정보
     */
    public MemberDTO isMember(String id, String passwd);

    /**
     * 전체 회원 목록 검색
     *
     * @return 회원 목록
     */
    public List<MemberDTO> getMemberList();

    /**
     * 회원 상세 정보 조회
     *
     * @param id 회원 아이디
     * @return 회원 정보
     */
    public MemberDTO getMember(String id);

    /**
     * 회원 정보 수정
     * 
     * @param memberDTO 수정할 회원 정보
     */
    public void editMember(MemberDTO memberDTO);
}