package id.actualtraining.restwithjpa.service;

import java.util.List;

public interface CRUD<T> {
    List<T> GetAll();
    T GetById(Long id);
    T create(T t);
    T update(Long id,T t);
    void delete(Long id);
}
