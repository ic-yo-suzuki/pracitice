package jp.co.iccom.suzuki_yoshihiro.service;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import jp.co.iccom.suzuki_yoshihiro.entity.UserEntity;

@Service
public class BatisDbConnectionTestService {

//	@Autowired
//	UserMapper userMapper;
//
	@Inject
	public SqlSession session;

	public UserEntity getUser(int id){
		UserEntity user = new UserEntity();
		user.setId(id);
		user.setName("子安由。");

		return user;
	}
}
