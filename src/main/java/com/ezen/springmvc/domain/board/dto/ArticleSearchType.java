package com.ezen.springmvc.domain.board.dto;

import lombok.*;

/**
 * 검색 조건 클래스
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
public class ArticleSearchType {

    private String writer;
    private String subject;
    private String content;

}
