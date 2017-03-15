package edu.project.services;

import java.util.List;

/**
 * Created by Marango on 03/03/2017.
 *
 */
public interface CRUDService<T> {
    List<?> listAll();
    T getById(Integer id);
    T saveOrUpdate(T domainObject);
    void delete(Integer id);
}
