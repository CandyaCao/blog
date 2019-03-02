package com.github.candyacao.service.impl;

import com.github.candyacao.entity.PostEntity;
import com.github.candyacao.mapper.PostMapper;
import com.github.candyacao.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;
    @Override
    public int publish(PostEntity post) {
       return postMapper.insert(post);
    }

    @Override
    public PostEntity select(String id) {
        return postMapper.selectByID(id);
    }

    @Override
    public void delete(String id) {
        postMapper.delete(id);
    }
}
