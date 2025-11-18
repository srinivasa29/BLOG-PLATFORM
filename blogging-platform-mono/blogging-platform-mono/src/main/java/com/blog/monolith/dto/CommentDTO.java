package com.blog.monolith.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private String text;
    private Long postId;
    private Long userId;
}
