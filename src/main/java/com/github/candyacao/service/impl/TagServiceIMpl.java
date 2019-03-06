package com.github.candyacao.service.impl;

import com.github.candyacao.entity.TagEntity;
import com.github.candyacao.mapper.TagMapper;
import com.github.candyacao.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceIMpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public int insert(TagEntity tag) {
        return tagMapper.insert(tag);
    }

    @Override
    public int linkToPost(String tag_id, String post_id) {
        return tagMapper.linkToPost(tag_id, post_id);
    }

    @Override
    public TagEntity selectByName(String name) {
        return tagMapper.selectByName(name);
    }

    @Override
    public List<TagEntity> getTags() {
        return tagMapper.getTags();
    }

    @Override
    public List<TagEntity> getTagsByPostID(String postID) {
        return tagMapper.getTagsByPostID(postID);
    }
}
