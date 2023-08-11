package com.springboot.blog.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T, ID> {
    Object create(Object createDto);

    Object update(ID id, Object updateDto);

    Object getDetail(ID id);

    List<Object> getAll();

    void delete(ID id);

}
