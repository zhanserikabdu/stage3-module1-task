package com.mjc.school.repository.interfaces;

import java.util.List;

public interface Repository<T> {
    List<T> readAll();

    T readById(Long var1);

    T create(T var1);

    T update(T var1);

    Boolean deleteById(Long var1);

    Boolean isExistById(Long var1);
}

