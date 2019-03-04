package com.github.candyacao.mapper;

import com.github.candyacao.entity.TagEntity;
import com.github.candyacao.utils.Misc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagMapperTest {
    @Autowired
    private TagMapper tagMapper;

    @Test
    public void insert(){
        String id = Misc.UUID();

        tagMapper.insert(new TagEntity(id,"张三"));
        tagMapper.linkToPost(id,"post_id");
        tagMapper.insert(new TagEntity(Misc.UUID(),"李四"));
    }
    @Test
    public void getTags(){
        List<TagEntity> tags = tagMapper.getTags();
        for (TagEntity tag:tags) {
            System.out.println(tag);
        }
    }
    @Test
    public void getTagsByPostID(){
        List<TagEntity> tags = tagMapper.getTagsByPostID("post_id");
        for (TagEntity tag:tags) {
            System.out.println(tag);
        }
    }
}
