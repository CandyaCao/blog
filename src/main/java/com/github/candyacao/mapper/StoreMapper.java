package com.github.candyacao.mapper;

import com.github.candyacao.entity.Store;

import java.util.List;

public interface StoreMapper {
    int saveStore(Store store);
    int delStore(Store store);
    List<Store> getStores(String userID);
}
