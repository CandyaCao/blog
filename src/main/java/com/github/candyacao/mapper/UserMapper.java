package com.github.candyacao.mapper;

import java.util.List;

import com.github.candyacao.entity.UserEntity;

public interface UserMapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(String id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(String id);

}