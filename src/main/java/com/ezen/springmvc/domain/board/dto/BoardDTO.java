package com.ezen.springmvc.domain.board.dto;

import lombok.*;

/**
 * 게시판 DTO
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
public class BoardDTO {
    private int boardId;
    private int category;
    private String title;
    private String description;

}
