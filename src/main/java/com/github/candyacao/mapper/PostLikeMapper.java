package com.github.candyacao.mapper;

import com.github.candyacao.entity.PostLike;

public interface PostLikeMapper {
    int saveLike(PostLike postLike);
    int delLike(PostLike postLike);
}
