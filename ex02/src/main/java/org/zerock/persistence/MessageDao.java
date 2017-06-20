package org.zerock.persistence;

import org.zerock.domain.MessageVo;

public interface MessageDao {
	
	public void create(MessageVo vo) throws Exception;
	
	public MessageVo readMessage(Integer mid) throws Exception;
	
	public void updateState(Integer mid) throws Exception;

}
