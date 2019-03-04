package com.github.candyacao.service.impl;

import com.github.candyacao.entity.CommentEntity;
import com.github.candyacao.mapper.CommentMapper;
import com.github.candyacao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int insert(CommentEntity comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public void delete(String id) {
        commentMapper.delete(id);
    }
}
