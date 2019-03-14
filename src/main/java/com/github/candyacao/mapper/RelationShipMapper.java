package com.github.candyacao.mapper;

import com.github.candyacao.entity.RelationShip;

import java.util.List;

public interface RelationShipMapper {
    int saveFan(RelationShip relationShip);
    int delFan(RelationShip relationShip);
    List<RelationShip> getFollows(String fromUserID);
    List<RelationShip> getFans(String toUserID);
}
