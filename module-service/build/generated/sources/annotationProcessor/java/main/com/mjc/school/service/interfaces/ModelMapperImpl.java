package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-06T17:36:22+0600",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class ModelMapperImpl implements ModelMapper {

    @Override
    public List<NewsDtoResponse> modelListToDtoList(List<NewsModel> var1) {
        if ( var1 == null ) {
            return null;
        }

        List<NewsDtoResponse> list = new ArrayList<NewsDtoResponse>( var1.size() );
        for ( NewsModel newsModel : var1 ) {
            list.add( modelToDto( newsModel ) );
        }

        return list;
    }

    @Override
    public NewsDtoResponse modelToDto(NewsModel var1) {
        if ( var1 == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        LocalDateTime createDate = null;
        LocalDateTime lastUpdatedDate = null;
        Long authorId = null;

        id = var1.getId();
        title = var1.getTitle();
        content = var1.getContent();
        createDate = var1.getCreateDate();
        lastUpdatedDate = var1.getLastUpdatedDate();
        authorId = var1.getAuthorId();

        NewsDtoResponse newsDtoResponse = new NewsDtoResponse( id, title, content, createDate, lastUpdatedDate, authorId );

        return newsDtoResponse;
    }

    @Override
    public NewsModel dtoToModel(NewsDtoRequest var1) {
        if ( var1 == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        Long authorId = null;

        id = var1.id();
        title = var1.title();
        content = var1.content();
        authorId = var1.authorId();

        LocalDateTime createDate = null;
        LocalDateTime lastUpdatedDate = null;

        NewsModel newsModel = new NewsModel( id, title, content, createDate, lastUpdatedDate, authorId );

        return newsModel;
    }
}
