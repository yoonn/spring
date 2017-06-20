package org.zerock.service;

import org.zerock.domain.LoginDto;
import org.zerock.domain.UserDto;

public interface UserService {
	
	public UserDto login(LoginDto dto) throws Exception;

}
