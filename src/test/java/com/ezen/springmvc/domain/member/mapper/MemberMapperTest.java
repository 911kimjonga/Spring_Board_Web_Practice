package com.ezen.springmvc.domain.member.mapper;

import com.ezen.springmvc.domain.member.dto.MemberDTO;
import com.ezen.springmvc.domain.member.dto.MemberSearchCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @Disabled
    void create() {
        //given
        //when
        //then
    }

    @Test
    void findById() {
        //given
        String id = "monday";
        //when
        MemberDTO memberDTO = memberMapper.findById(id);
        //then
        Assertions.assertThat(memberDTO)
                .isNotNull();
    }

    @Test
    void findByIdAndPasswd() {
        //given
        String id = "monday";
        String passwd = "1111";
        //when
        MemberDTO memberDTO = memberMapper.findByIdAndPasswd(id, passwd);
        //then
        Assertions.assertThat(memberDTO)
                .isNotNull();
    }

    @Test
    void findByAll() {
        //when
        List<MemberDTO> list = memberMapper.findByAll();
        //then
        Assertions.assertThat(list)
                .isNotNull();
    }

    @Test
    void findByNameLike() {
        //given
        String name = "요일";
        //when
        List<MemberDTO> list = memberMapper.findByNameLike(name);
        //then
        Assertions.assertThat(list)
                .isNotNull();
    }

    @Test
    void findBySearchType() {
        //given
        String type = "name";
        String keyword = "월요일";
        //when
        List<MemberDTO> list = memberMapper.findBySearchType(type, keyword);
        //then
        Assertions.assertThat(list)
                .isNotNull();
    }

    @Test
    void findBySearchAll() {
        //given
        String keyword = "요일";
        //when
        List<MemberDTO> list = memberMapper.findBySearchAll(keyword);
        //then
        Assertions.assertThat(list)
                .isNotNull();
    }

    @Test
    void findBySearchCondition() {
        //given
        MemberSearchCondition memberSearchCondition = MemberSearchCondition.builder()
                .id(null)
                .name("요일")
                .email(null)
                .build();
        //when
        List<MemberDTO> list = memberMapper.findBySearchCondition(memberSearchCondition);
        //then
        Assertions.assertThat(list)
                .isNotNull();
    }

    @Test
    @Disabled
    void update() {
        //given
        //when
        //then
    }
}