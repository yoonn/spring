package org.zerock.service;

import org.zerock.domain.MessageVo;

public interface MessageService {
	
	public void addMessage(MessageVo vo) throws Exception;
	
	public MessageVo readMessage(String uid, Integer mid) throws Exception;

}
