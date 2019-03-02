package com.github.candyacao.mapper;

import com.github.candyacao.entity.PostEntity;

import java.util.List;

public interface PostMapper {
    List<PostEntity> getAllPosts(String anthorID);
    int insert(PostEntity post);
    void delete(String id);
    PostEntity selectByID(String id);
}
