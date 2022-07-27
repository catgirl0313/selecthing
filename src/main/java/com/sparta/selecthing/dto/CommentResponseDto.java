package com.sparta.selecthing.dto;

import com.sparta.selecthing.model.Comment;
import lombok.Data;

@Data
public class CommentResponseDto {


    private Long id;

    private String content;

    private String nickname;

    private String mbti;

    public CommentResponseDto() {
    }

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.nickname = comment.getMember().getNickname();
        this.mbti = comment.getMember().getMbti();

    }
}