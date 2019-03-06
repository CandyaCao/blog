package com.github.candyacao.mapper;

import com.github.candyacao.entity.PostEntity;
import com.github.candyacao.entity.TagEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {
    int insert(TagEntity tag);
    int linkToPost(@Param("tag_id") String tag_id, @Param("post_id") String post_id);
    TagEntity selectByName(String name);
    List<TagEntity> getTags();
    List<TagEntity> getTagsByPostID(String postID);
}
