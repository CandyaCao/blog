package com.github.candyacao.mapper;

import com.github.candyacao.entity.PostEntity;
import com.github.candyacao.utils.Misc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostMapperTest {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void insertTest(){
//        postMapper.insert(new PostEntity("5","shjfahl","28","hsdkfhal","dklfhakl","hdfkahf",new Date()));
//        postMapper.insert(new PostEntity("2","长得帅JFK和","28","hsdkfhal","dklfhakl","hdfkahf",new Date()));
//        postMapper.insert(new PostEntity("3","在每年需加快第三方","28","hsdkfhal","dklfhakl","hdfkahf",new Date()));
//        postMapper.insert(new PostEntity("4","是JFK哈尔我","28","hsdkfhal","dklfhakl","hdfkahf",new Date()));
        String uuid = Misc.UUID();
        int ret = postMapper.insert(new PostEntity(uuid,"我","28","hsdkfhal","dklfhakl","hdfkahf",new Date()));
        System.out.println(ret);
    }

    @Test
    public void selectTest(){
        PostEntity post = postMapper.selectByID("66034467-6731-4e12-bba0-c8566e530a8f");
        System.out.println(post);
    }
    @Test
    public void deleteTest(){  postMapper.delete("3");}

}
