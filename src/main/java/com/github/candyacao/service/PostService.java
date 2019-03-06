package com.github.candyacao.service;

import com.github.candyacao.entity.PostEntity;

import java.util.List;

public interface PostService {
    int publish(PostEntity post);
    PostEntity select(String id);
    void delete(String id);
    List<PostEntity> getPosts(String userID);

}
