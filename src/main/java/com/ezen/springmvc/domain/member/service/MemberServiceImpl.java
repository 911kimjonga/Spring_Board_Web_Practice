package com.ezen.springmvc.domain.member.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.springmvc.domain.member.dto.MemberDTO;
import com.ezen.springmvc.domain.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

/**
 * MemberService 구현체
 *
 * @author 김종원
 */
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    /**
     * 회원 가입
     *
     * @param member 회원 정보
     */
    @Override
    @Transactional
    public void register(MemberDTO member) {
        memberMapper.create(member);
    }

    /**
     * 로그인 시 회원 확인
     *
     * @param id     아이디
     * @param passwd 비밀번호
     * @return 회원 정보
     */
    @Override
    public MemberDTO isMember(String id, String passwd) {
        return memberMapper.findByIdAndPasswd(id, passwd);
    }

    /**
     * 전체 회원 목록 검색
     *
     * @return 회원 목록
     */
    @Override
    public List<MemberDTO> getMemberList() {
        return memberMapper.findByAll();
    }

    /**
     * 회원 상세 정보 조회
     *
     * @param id 회원 아이디
     * @return 회원 정보
     */
    @Override
    public MemberDTO getMember(String id) {
        return memberMapper.findById(id);
    }
}