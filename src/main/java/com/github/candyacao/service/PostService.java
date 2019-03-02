package com.github.candyacao.service;

import com.github.candyacao.entity.PostEntity;

public interface PostService {
    int publish(PostEntity post);
    PostEntity select(String id);
    void delete(String id);

}
