package com.github.candyacao.mapper;

import java.util.List;

import com.github.candyacao.entity.UserEntity;
import com.github.candyacao.utils.Misc;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.candyacao.enums.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		UserMapper.insert(new UserEntity(Misc.UUID(), "aa", "a123456", UserSexEnum.MAN, "张三"));
		UserMapper.insert(new UserEntity(Misc.UUID(), "bb", "b123456", UserSexEnum.WOMAN, "张海飞"));
		UserMapper.insert(new UserEntity(Misc.UUID(), "cc", "b123456", UserSexEnum.WOMAN, "李四"));

		Assert.assertEquals(3, UserMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne("hjkh");
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne("hjkh").getNickName())));
	}

}