package com.github.candyacao.mapper;

import com.github.candyacao.entity.RelationShip;
import com.github.candyacao.utils.Misc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationShipMapperTest {
    @Autowired
    private RelationShipMapper relationShipMapper;

    @Test
    public void saveFan(){
        relationShipMapper.saveFan(new RelationShip(Misc.UUID(),"0061761b-dbd8-40e7-bdec-c1687e9d43fd","53cc8352-26dd-4604-bd20-1ab1175f17b9"));
        relationShipMapper.saveFan(new RelationShip(Misc.UUID(),"53cc8352-26dd-4604-bd20-1ab1175f17b9","0061761b-dbd8-40e7-bdec-c1687e9d43fd"));
        relationShipMapper.saveFan(new RelationShip(Misc.UUID(),"53cc8352-26dd-4604-bd20-1ab1175f17b9","6e978908-675c-465b-8719-90eab583fa32"));
        relationShipMapper.saveFan(new RelationShip(Misc.UUID(),"0061761b-dbd8-40e7-bdec-c1687e9d43fd","6e978908-675c-465b-8719-90eab583fa32"));
        relationShipMapper.saveFan(new RelationShip(Misc.UUID(),"7f57da35-eef8-43ce-9ac4-05df25edc6dc","0061761b-dbd8-40e7-bdec-c1687e9d43fd"));
        relationShipMapper.saveFan(new RelationShip(Misc.UUID(),"bd8f41d8-3a49-458a-a780-78e7e8a84107","0061761b-dbd8-40e7-bdec-c1687e9d43fd"));
        relationShipMapper.saveFan(new RelationShip(Misc.UUID(),"7f57da35-eef8-43ce-9ac4-05df25edc6dc","bd8f41d8-3a49-458a-a780-78e7e8a84107"));
    }
    @Test
    public void getFans(){
        List<RelationShip> fans = relationShipMapper.getFans("0061761b-dbd8-40e7-bdec-c1687e9d43fd");
        System.out.println(fans.size());
    }

    @Test
    public void getFollows(){
        List<RelationShip> follows = relationShipMapper.getFollows("7f57da35-eef8-43ce-9ac4-05df25edc6dc");
        System.out.println(follows.size());
    }
    @Test
    public void delFan(){
        relationShipMapper.delFan(new RelationShip("0061761b-dbd8-40e7-bdec-c1687e9d43fd","53cc8352-26dd-4604-bd20-1ab1175f17b9"));
    }

}
