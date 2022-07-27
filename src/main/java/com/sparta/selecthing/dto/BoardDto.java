package com.sparta.selecthing.dto;


import com.sparta.selecthing.model.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
    private Long id;

    private String title;
    private String nickname;
    private String mbti;
    private String content;
    private String image;

    private String createdAt;

    private boolean agree = false;
    private boolean disagree = false;
    private int agreeCount = 0;
    private int disagreeCount = 0;

//    private Board board;

    private List<CommentResponseDto> comments;


    public BoardDto(Board board, List<CommentResponseDto> comments) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.nickname = board.getMember().getNickname();
        this.mbti = board.getMbti();
        this.content = board.getContent();
        this.image = board.getImage();
        this.agreeCount = getAgreeCount();
        this.disagreeCount = getDisagreeCount();
        this.createdAt = board.getCreatedAt();
        this.comments = comments;
    }
}
