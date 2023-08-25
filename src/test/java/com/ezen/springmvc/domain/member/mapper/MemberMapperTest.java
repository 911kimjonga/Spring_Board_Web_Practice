package com.ezen.springmvc.domain.member.mapper;

import com.ezen.springmvc.domain.member.dto.MemberDTO;
import com.ezen.springmvc.domain.member.dto.MemberSearchCondition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @Transactional
    void createTest() {
        //given
        MemberDTO memberDTO = MemberDTO.builder()
                .id("park")
                .passwd("1234")
                .name("박길동")
                .email("park@gmail.com")
                .build();
        //when
        memberMapper.create(memberDTO);
        //then
    }

    @Test
    void findByIdTest() {
        //given
        String id = "monday";
        //when
        MemberDTO memberDTO = memberMapper.findById(id);
        //then
        assertThat(memberDTO)
                .isNotNull();
    }

    @Test
    void findByIdAndPasswdTest() {
        //given
        String id = "monday";
        String passwd = "1111";
        //when
        MemberDTO memberDTO = memberMapper.findByIdAndPasswd(id, passwd);
        //then
        assertThat(memberDTO)
                .isNotNull();
    }

    @Test
    void findByAllTest() {
        //when
        List<MemberDTO> list = memberMapper.findByAll();
        //then
        assertThat(list)
                .isNotNull();
    }

    @Test
    void findByNameLikeTest() {
        //given
        String name = "요일";
        //when
        List<MemberDTO> list = memberMapper.findByNameLike(name);
        //then
        assertThat(list)
                .isNotNull();
    }

    @Test
    void findBySearchTypeTest() {
        //given
        String type = "name";
        String keyword = "월요일";
        //when
        List<MemberDTO> list = memberMapper.findBySearchType(type, keyword);
        //then
        assertThat(list)
                .isNotNull();
    }

    @Test
    void findBySearchAllTest() {
        //given
        String keyword = "요일";
        //when
        List<MemberDTO> list = memberMapper.findBySearchAll(keyword);
        //then
        assertThat(list)
                .isNotNull();
    }

    @Test
    void findBySearchConditionTest() {
        //given
        MemberSearchCondition memberSearchCondition = MemberSearchCondition.builder()
                .id(null)
                .name("요일")
                .email(null)
                .build();
        //when
        List<MemberDTO> list = memberMapper.findBySearchCondition(memberSearchCondition);
        //then
        assertThat(list)
                .isNotNull();
    }

    @Test
    @Transactional
    void updateTest() {
        //given
        MemberDTO memberDTO = MemberDTO.builder()
                .id("monday")
                .passwd("1234")
                .build();
        //when
        memberMapper.update(memberDTO);
        //then
    }
}