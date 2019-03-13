package com.github.candyacao.service.impl;

import com.github.candyacao.entity.PostLike;
import com.github.candyacao.mapper.PostLikeMapper;
import com.github.candyacao.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostLikeServiceImpl implements PostLikeService {
    @Autowired
    private PostLikeMapper postLikeMapper;
    @Override
    public int saveLike(PostLike postLike) {
        return postLikeMapper.saveLike(postLike);
    }

    @Override
    public int delLike(PostLike postLike) {
        return postLikeMapper.delLike(postLike);
    }
}
