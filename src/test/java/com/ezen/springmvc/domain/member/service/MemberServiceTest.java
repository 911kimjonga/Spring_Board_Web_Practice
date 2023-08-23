package com.ezen.springmvc.domain.member.service;

import com.ezen.springmvc.domain.member.dto.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    void register() {
        //given
        MemberDTO memberDTO = MemberDTO.builder()
                .id("hong")
                .passwd("1234")
                .name("홍길동")
                .email("hong@gmail.com")
                .build();
        //when
        memberService.register(memberDTO);
        //then
    }

    @Test
    void isMember() {
        //given
        String id = "monday";
        String passwd = "1111";
        //when
        MemberDTO memberDTO = memberService.isMember(id, passwd);
        //then
        assertThat(memberDTO)
                .isNotNull();
    }

    @Test
    void getMemberList() {
        //given
        //when
        List<MemberDTO> list = memberService.getMemberList();
        //then
        assertThat(list)
                .isNotNull();
    }

    @Test
    void getMember() {
        //given
        String id = "monday";
        //when
        MemberDTO memberDTO = memberService.getMember(id);
        //then
        assertThat(memberDTO)
                .isNotNull();
    }
}