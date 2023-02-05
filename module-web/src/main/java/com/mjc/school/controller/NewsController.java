package com.mjc.school.controller;

import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.factory.ServiceFactory;
import com.mjc.school.service.interfaces.Service;

import java.util.List;

public class NewsController {
    private final Service<NewsDtoRequest, NewsDtoResponse> newsService = ServiceFactory.getInstance().getNewsService();

    public NewsController() {
    }

    public List<NewsDtoResponse> readAll() {
        return this.newsService.readAll();
    }

    public NewsDtoResponse readById(Long newsId) {
        return (NewsDtoResponse)this.newsService.readById(newsId);
    }

    public NewsDtoResponse create(NewsDtoRequest dtoRequest) {
        return (NewsDtoResponse)this.newsService.create(dtoRequest);
    }

    public NewsDtoResponse update(NewsDtoRequest dtoRequest) {
        return (NewsDtoResponse)this.newsService.update(dtoRequest);
    }

    public Boolean deleteById(Long newsId) {
        return this.newsService.deleteById(newsId);
    }
}

