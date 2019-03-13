package com.github.candyacao.mapper;

import com.github.candyacao.entity.PostLike;
import com.github.candyacao.enums.LikedStatusEnum;
import com.github.candyacao.utils.Misc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostLikeMapperTest {

    @Autowired
    private PostLikeMapper postLikeMapper;
    PostLike poL = new PostLike(Misc.UUID(), "53cc8352-26dd-4604-bd20-1ab1175f17b9", "66034467-6731-4e12-bba0-c8566e530a8f");

    @Test
    public void saveLike(){
        poL.setStatus(LikedStatusEnum.LIKE.getCode());
        postLikeMapper.saveLike(poL);
    }
    @Test
    public void delLike(){
        postLikeMapper.delLike(poL);
    }
}
