package com.ezen.springmvc.domain.member.service;

import com.ezen.springmvc.domain.member.dto.MemberDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @Disabled
    void register() {
    }

    @Test
    void isMember() {
        //given
        String id = "monday";
        String passwd = "1111";
        //when
        MemberDTO memberDTO = memberService.isMember(id, passwd);
        //then
        Assertions.assertThat(memberDTO)
                .isNotNull();
    }

    @Test
    void getMemberList() {
        //given
        //when
        List<MemberDTO> list = memberService.getMemberList();
        //then
        Assertions.assertThat(list)
                .isNotNull();
    }

    @Test
    void getMember() {
        //given
        String id = "monday";
        //when
        MemberDTO memberDTO = memberService.getMember(id);
        //then
        Assertions.assertThat(memberDTO)
                .isNotNull();
    }
}