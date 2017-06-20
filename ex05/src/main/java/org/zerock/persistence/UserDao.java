package org.zerock.persistence;

import org.zerock.domain.LoginDto;
import org.zerock.domain.UserDto;

public interface UserDao {
	
	public UserDto login(LoginDto dto) throws Exception;

}
