package com.github.candyacao.mapper;

import com.github.candyacao.entity.FileEntity;
import com.github.candyacao.utils.Misc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileMapperTest {
    @Autowired
    private FileMapper fileMapper;
    @Test
    public void saveFile(){
        fileMapper.saveFile(new FileEntity(Misc.UUID(),"张三", "jhdfkjadsfh"));
    }

    @Test
    public void select(){
        FileEntity file = fileMapper.getFile("42804cb5-cdfe-47b0-913b-cb080c4507de");
        System.out.println(file);
    }


}
