package com.ezen.springmvc.domain.member.dto;

import lombok.*;

/**
 * 회원 DTO
 *
 * @author 김종원
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class MemberDTO {
    private String id;
    private String passwd;
    private String name;
    private String email;
    private String regdate;
}