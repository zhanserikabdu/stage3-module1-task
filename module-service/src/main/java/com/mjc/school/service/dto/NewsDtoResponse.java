package com.mjc.school.service.dto;

import java.time.LocalDateTime;

public record NewsDtoResponse(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdatedDate, Long authorId) {
    public NewsDtoResponse(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdatedDate, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.authorId = authorId;
    }

    public Long id() {
        return this.id;
    }

    public String title() {
        return this.title;
    }

    public String content() {
        return this.content;
    }

    public LocalDateTime createDate() {
        return this.createDate;
    }

    public LocalDateTime lastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    public Long authorId() {
        return this.authorId;
    }
}

