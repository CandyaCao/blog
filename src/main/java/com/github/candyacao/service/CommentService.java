package com.github.candyacao.service;

import com.github.candyacao.entity.CommentEntity;

public interface CommentService {
    int insert(CommentEntity comment);
    void delete(String id);
}
