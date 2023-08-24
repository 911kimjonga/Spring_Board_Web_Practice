package com.ezen.springmvc.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "아이디는 필수 입력 항목입니다.")
    @Size(min = 2, max = 12)
    private String id;
    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    private String passwd;
    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    private String name;
    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    private String email;
    private String regdate;
}