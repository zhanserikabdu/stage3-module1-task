package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModelMapperImpl implements ModelMapper {
    public ModelMapperImpl() {
    }

    public List<NewsDtoResponse> modelListToDtoList(List<NewsModel> newsModelList) {
        if (newsModelList == null) {
            return null;
        } else {
            List<NewsDtoResponse> list = new ArrayList(newsModelList.size());
            Iterator var3 = newsModelList.iterator();

            while(var3.hasNext()) {
                NewsModel newsModel = (NewsModel)var3.next();
                list.add(this.modelToDto(newsModel));
            }

            return list;
        }
    }

    public NewsDtoResponse modelToDto(NewsModel newsModel) {
        if (newsModel == null) {
            return null;
        } else {
            Long id = null;
            String title = null;
            String content = null;
            LocalDateTime createDate = null;
            LocalDateTime lastUpdatedDate = null;
            Long authorId = null;
            id = newsModel.getId();
            title = newsModel.getTitle();
            content = newsModel.getContent();
            createDate = newsModel.getCreateDate();
            lastUpdatedDate = newsModel.getLastUpdatedDate();
            authorId = newsModel.getAuthorId();
            NewsDtoResponse newsDtoResponse = new NewsDtoResponse(id, title, content, createDate, lastUpdatedDate, authorId);
            return newsDtoResponse;
        }
    }

    public NewsModel dtoToModel(NewsDtoRequest newsModelRequest) {
        if (newsModelRequest == null) {
            return null;
        } else {
            Long id = null;
            String title = null;
            String content = null;
            Long authorId = null;
            id = newsModelRequest.id();
            title = newsModelRequest.title();
            content = newsModelRequest.content();
            authorId = newsModelRequest.authorId();
            LocalDateTime createDate = null;
            LocalDateTime lastUpdatedDate = null;
            NewsModel newsModel = new NewsModel(id, title, content, (LocalDateTime)createDate, (LocalDateTime)lastUpdatedDate, authorId);
            return newsModel;
        }
    }
}

