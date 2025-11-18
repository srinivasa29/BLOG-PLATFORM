package com.blog.comment_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentDTO {

    @NotNull
    private Long postId;

    @NotNull
    private Long userId;

    @NotBlank
    private String content;
}
