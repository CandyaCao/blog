package com.github.candyacao.service;

import com.github.candyacao.entity.PostLike;

public interface PostLikeService {
    int saveLike(PostLike postLike);
    int delLike(PostLike postLike);
}
