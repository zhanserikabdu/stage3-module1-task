package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ModelMapper {
    List<NewsDtoResponse> modelListToDtoList(List<NewsModel> var1);

    NewsDtoResponse modelToDto(NewsModel var1);

    @Mappings({@Mapping(
            target = "createDate",
            ignore = true
    ), @Mapping(
            target = "lastUpdatedDate",
            ignore = true
    )})
    NewsModel dtoToModel(NewsDtoRequest var1);
}
