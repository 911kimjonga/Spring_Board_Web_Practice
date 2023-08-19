package com.ezen.springmvc.domain.board.dto;

import lombok.*;

/**
 * 게시글 DTO
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
public class ArticleDTO {
    private int articleId;
    private int boardId;
    private String writer;
    private String subject;
    private String content;
    private String regdate;
    private int hitcount;
    private String passwd;
    private int groupNo;
    private int levelNo;
    private int orderNo;

}
