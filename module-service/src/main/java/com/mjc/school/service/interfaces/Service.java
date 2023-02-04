package com.mjc.school.service.interfaces;

import java.util.List;

public interface Service<T1, T2> {
    List<T2> readAll();

    T2 readById(Long var1);

    T2 create(T1 var1);

    T2 update(T1 var1);

    Boolean deleteById(Long var1);
}
