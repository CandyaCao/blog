package com.github.candyacao.service;

import com.github.candyacao.entity.TagEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagService {
    int insert(TagEntity tag);
    int linkToPost(@Param("tag_id") String tag_id, @Param("post_id") String post_id);
    List<TagEntity> getTags();
    List<TagEntity> getTagsByPostID(String postID);
}
