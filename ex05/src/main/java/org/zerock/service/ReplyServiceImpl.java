package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyDto;
import org.zerock.persistence.BoardDao;
import org.zerock.persistence.ReplyDao;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyDao rDao;
	
	@Inject
	private BoardDao bDao;
	
	@Transactional
	@Override
	public void addReply(ReplyDto rDto) throws Exception {
		rDao.create(rDto);
		bDao.updateReplyCnt(rDto.getBno(), 1);
	}

	@Override
	public List<ReplyDto> listReply(Integer bno) throws Exception {
		return rDao.list(bno);
	}

	@Override
	public void modifyReply(ReplyDto rDto) throws Exception {
		rDao.update(rDto);
	}

	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {
		
		int bno = rDao.getBno(rno);
		rDao.delete(rno);
		bDao.updateReplyCnt(bno, -1);
		
	}

	@Override
	public List<ReplyDto> listReplyPage(Integer bno, Criteria cri) throws Exception {
		return rDao.listPage(bno, cri);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return rDao.count(bno);
	}
	

}
