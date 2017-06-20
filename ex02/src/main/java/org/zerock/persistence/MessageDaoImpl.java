package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MessageVo;

@Repository
public class MessageDaoImpl implements MessageDao{

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.zerock.mapper.MessageMapper";

	@Override
	public void create(MessageVo vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public MessageVo readMessage(Integer mid) throws Exception {
		return session.selectOne(namespace + ".readMessage", mid);
	}

	@Override
	public void updateState(Integer mid) throws Exception {
		session.update(namespace + ".updateState", mid);
	}
	
	

}
