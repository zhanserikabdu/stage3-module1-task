package com.mjc.school.repository.utils;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.model.data.AuthorData;
import com.mjc.school.repository.model.data.NewsData;
import java.util.List;

public class DataSource {
    private final List<NewsModel> news;

    private DataSource() {
        List<AuthorModel> authorList = AuthorData.getAuthorData().getAuthorList();
        this.news = NewsData.getNewsData(authorList).getNewsList();
    }

    public static DataSource getInstance() {
        return DataSource.LazyDataSource.INSTANCE;
    }

    public List<NewsModel> getNews() {
        return this.news;
    }

    private static class LazyDataSource {
        static final DataSource INSTANCE = new DataSource();

        private LazyDataSource() {
        }
    }
}