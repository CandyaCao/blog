package com.github.candyacao.mapper;

import com.github.candyacao.entity.CommentEntity;
import com.github.candyacao.entity.UserEntity;
import com.github.candyacao.utils.Misc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    private CommentMapper commentMapper;
    @Test
    public void insertTest(){
        UserEntity user = new UserEntity();
        user.setId(Misc.UUID());
        commentMapper.insert(new CommentEntity(Misc.UUID(), new Date(), "张海飞是个王八蛋", user,Misc.UUID()));
    }
}
