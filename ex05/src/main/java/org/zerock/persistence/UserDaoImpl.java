package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.LoginDto;
import org.zerock.domain.UserDto;

@Repository
public class UserDaoImpl implements UserDao{

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.zerock.mapper.UserMapper";
	
	@Override
	public UserDto login(LoginDto dto) throws Exception {
		return session.selectOne(namespace + ".login", dto);
	}
	
}
