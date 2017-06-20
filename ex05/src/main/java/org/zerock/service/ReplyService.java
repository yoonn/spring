package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyDto;

public interface ReplyService {

	public void addReply(ReplyDto rDto) throws Exception;
	
	public List<ReplyDto> listReply(Integer bno) throws Exception;
	
	public void modifyReply(ReplyDto rDto) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
	
	public List<ReplyDto> listReplyPage(Integer bno, Criteria cri) throws Exception;
	
	public int count(Integer bno) throws Exception;
	
}
