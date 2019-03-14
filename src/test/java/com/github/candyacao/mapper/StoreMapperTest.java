package com.github.candyacao.mapper;

import com.github.candyacao.entity.Store;
import com.github.candyacao.utils.Misc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreMapperTest {
    @Autowired
    private StoreMapper storeMapper;
    @Test
    public void saveStore(){
        storeMapper.saveStore(new Store(Misc.UUID(),"0061761b-dbd8-40e7-bdec-c1687e9d43fd","66034467-6731-4e12-bba0-c8566e530a8f", new Date()));
        storeMapper.saveStore(new Store(Misc.UUID(),"6e978908-675c-465b-8719-90eab583fa32","66034467-6731-4e12-bba0-c8566e530a8f", new Date()));
        storeMapper.saveStore(new Store(Misc.UUID(),"7f57da35-eef8-43ce-9ac4-05df25edc6dc","66034467-6731-4e12-bba0-c8566e530a8f", new Date()));

    }
    @Test
    public void delStore(){
        storeMapper.delStore(new Store("0061761b-dbd8-40e7-bdec-c1687e9d43fd","66034467-6731-4e12-bba0-c8566e530a8f"));
    }

    @Test
    public void getStors(){
        List<Store> stores = storeMapper.getStores("0061761b-dbd8-40e7-bdec-c1687e9d43fd");
        for(Store s: stores){
            System.out.println(s);
        }
    }
}
