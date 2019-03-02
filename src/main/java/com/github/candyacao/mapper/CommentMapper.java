package com.github.candyacao.mapper;

import com.github.candyacao.entity.CommentEntity;

public interface CommentMapper {
    int insert(CommentEntity comment);
    void delete(String id);
}
