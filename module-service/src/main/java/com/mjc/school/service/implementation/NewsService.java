package com.mjc.school.service.implementation;

import com.mjc.school.repository.factory.RepositoryFactory;
import com.mjc.school.repository.interfaces.Repository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.exceptions.NotFoundException;
import com.mjc.school.service.exceptions.ServiceErrorCode;
import com.mjc.school.service.interfaces.ModelMapper;
import com.mjc.school.service.interfaces.Service;
import com.mjc.school.service.validator.NewsValidator;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.mapstruct.factory.Mappers;

public class NewsService implements Service<NewsDtoRequest, NewsDtoResponse> {
    private final Repository<NewsModel> newsRepository = RepositoryFactory.getInstance().getNewsRepository();
    private final NewsValidator newsValidator = NewsValidator.getNewsValidator();
    private ModelMapper mapper = (ModelMapper)Mappers.getMapper(ModelMapper.class);

    public NewsService() {
    }

    public List<NewsDtoResponse> readAll() {
        return this.mapper.modelListToDtoList(this.newsRepository.readAll());
    }

    public NewsDtoResponse readById(Long newsId) {
        this.newsValidator.validateNewsId(newsId);
        if (this.newsRepository.isExistById(newsId)) {
            NewsModel newsModel = (NewsModel)this.newsRepository.readById(newsId);
            return this.mapper.modelToDto(newsModel);
        } else {
            throw new NotFoundException(String.format(String.valueOf(ServiceErrorCode.NEWS_ID_DOES_NOT_EXIST.getMessage()), newsId));
        }
    }

    public NewsDtoResponse create(NewsDtoRequest dtoRequest) {
        this.newsValidator.validateNewsDto(dtoRequest);
        NewsModel model = this.mapper.dtoToModel(dtoRequest);
        LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        model.setCreateDate(date);
        model.setLastUpdatedDate(date);
        NewsModel newsModel = (NewsModel)this.newsRepository.create(model);
        return this.mapper.modelToDto(newsModel);
    }

    public NewsDtoResponse update(NewsDtoRequest dtoRequest) {
        this.newsValidator.validateNewsId(dtoRequest.id());
        this.newsValidator.validateNewsDto(dtoRequest);
        if (this.newsRepository.isExistById(dtoRequest.id())) {
            NewsModel model = this.mapper.dtoToModel(dtoRequest);
            LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            model.setLastUpdatedDate(date);
            NewsModel newsModel = (NewsModel)this.newsRepository.update(model);
            return this.mapper.modelToDto(newsModel);
        } else {
            throw new NotFoundException(String.format(ServiceErrorCode.NEWS_ID_DOES_NOT_EXIST.getMessage(), dtoRequest.id()));
        }
    }

    public Boolean deleteById(Long newsId) {
        this.newsValidator.validateNewsId(newsId);
        if (this.newsRepository.isExistById(newsId)) {
            return this.newsRepository.deleteById(newsId);
        } else {
            throw new NotFoundException(String.format(ServiceErrorCode.NEWS_ID_DOES_NOT_EXIST.getMessage(), newsId));
        }
    }
}

