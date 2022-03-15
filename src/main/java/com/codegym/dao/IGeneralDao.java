package com.codegym.dao;

import java.util.List;

public interface IGeneralDao<T> {
    List<T> getAll();

    boolean save(T t);

    boolean update(int id,T t);

    boolean delete (int id );

    T findById(int id);
}
