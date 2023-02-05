package com.mjc.school.service.dto;

public record NewsDtoRequest(Long id, String title, String content, Long authorId) {
    public NewsDtoRequest(Long id, String title, String content, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    public Long authorId() {
        return this.authorId;
    }
}
