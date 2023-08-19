package com.ezen.springmvc.domain.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ezen.springmvc.domain.member.dto.MemberDTO;
import com.ezen.springmvc.domain.member.dto.MemberSearchCondition;

/**
 * 회원 Mapper
 *
 * @author 김종원
 */
@Mapper
public interface MemberMapper {

    /**
     * 회원 가입
     *
     * @param member 회원 정보
     */
    public void create(MemberDTO member);

    /**
     * 특정 회원 정보 조회
     *
     * @param id 회원 아이디
     * @return 회원 정보
     */
    public MemberDTO findById(String id);

    /**
     * 로그인 시 회원 확인
     *
     * @param id     회원 아이디
     * @param passwd 회원 비밀번호
     * @return 회원 정보
     */
    public MemberDTO findByIdAndPasswd(@Param("id") String id, @Param("passwd") String passwd);

    /**
     * 전체 회원 목록 검색
     *
     * @return 회원 목록
     */
    public List<MemberDTO> findByAll();

    /**
     * 회원 이름(와일드카드 적용)으로 회원 검색
     *
     * @param name 회원 이름 키워드
     * @return 회원 목록
     */
    public List<MemberDTO> findByNameLike(String name);

    /**
     * 특정 조건에서 키워드로 회원 검색
     *
     * @param type    검색 타입
     * @param keyword 검색 키워드
     * @return 회원 목록
     */
    public List<MemberDTO> findBySearchType(@Param("type") String type, @Param("keyword") String keyword);

    /**
     * 모든 조건에서 키워드로 회원 검색
     *
     * @param keyword 검색 키워드
     * @return 회원 목록
     */
    public List<MemberDTO> findBySearchAll(String keyword);

    /**
     * 필터링한 조건에서 키워드로 회원 검색
     *
     * @param searchCondition 검색 조건
     * @return 회원 목록
     */
    public List<MemberDTO> findBySearchCondition(MemberSearchCondition searchCondition);

    /**
     * 회원 정보 수정
     *
     * @param member 회원 정보
     */
    public void update(MemberDTO member);

}