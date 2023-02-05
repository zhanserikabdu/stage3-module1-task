package com.mjc.school.repository.implementation;

import com.mjc.school.repository.interfaces.Repository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.utils.DataSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NewsRepository implements Repository<NewsModel> {
    private final DataSource dataSource = DataSource.getInstance();

    public NewsRepository() {
    }

    public List<NewsModel> readAll() {
        return this.dataSource.getNews();
    }

    public NewsModel readById(Long newsId) {
        return (NewsModel)this.dataSource.getNews().stream().filter((news) -> {
            return newsId.equals(news.getId());
        }).findFirst().get();
    }

    public NewsModel create(NewsModel model) {
        List<NewsModel> newsModel = this.dataSource.getNews();
        newsModel.sort(Comparator.comparing(NewsModel::getId));
        if (!newsModel.isEmpty()) {
            model.setId(((NewsModel)newsModel.get(newsModel.size() - 1)).getId() + 1L);
        } else {
            model.setId(1L);
        }

        newsModel.add(model);
        return model;
    }

    public NewsModel update(NewsModel model) {
        NewsModel newsModel = this.readById(model.getId());
        newsModel.setTitle(model.getTitle());
        newsModel.setContent(model.getContent());
        newsModel.setLastUpdatedDate(model.getLastUpdatedDate());
        newsModel.setAuthorId(model.getAuthorId());
        return newsModel;
    }

    public Boolean deleteById(Long newsId) {
        List<NewsModel> deleteList = new ArrayList();
        deleteList.add(this.readById(newsId));
        return this.dataSource.getNews().removeAll(deleteList);
    }

    public Boolean isExistById(Long newsId) {
        return this.dataSource.getNews().stream().anyMatch((news) -> {
            return newsId.equals(news.getId());
        });
    }
}

