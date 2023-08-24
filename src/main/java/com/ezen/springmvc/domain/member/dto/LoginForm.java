package com.ezen.springmvc.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class LoginForm {
	@NotBlank(message = "아이디를 입력하여 주세요.")
	@Size(min = 2, max = 12, message = "아이디는 6~12자 사이여야 합니다.")
	private String loginId;
	@Size(min = 4, max = 8, message = "비밀번호는 4~8자 사이여야 합니다.")
	@NotBlank(message = "비밀번호를 입력하여 주세요")
	private String passwd;
	private Boolean remember;
	
}





