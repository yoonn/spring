package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyDto;

public interface ReplyDao {
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 댓글 목록 불러오기
	 * 2. 처리내용	: 글번호를 받아와서 글번호에 해당하는 댓글 목록 불러오기
	 * </pre>
	 * @Method Name : list
	 * @param 		  bno
	 * @return		  List<ReplyDto>
	 * @throws 		  Exception
	 ***************************************************/
	public List<ReplyDto> list(Integer bno) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 댓글 등록
	 * 2. 처리내용	: 사용자가 입력한 ReplyDto를 받아와서 댓글 등록
	 * </pre>	 * @Method Name : create
	 * @param 		  rDto
	 * @throws 		  Exception
	 ***************************************************/
	public void create(ReplyDto rDto) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 댓글 수정
	 * 2. 처리내용	: 사용자가 입력한 수정정보, ReplyDto를 받아와서 댓글 수정
	 * </pre>
	 * @Method Name : update
	 * @param 		  rDto
	 * @throws 		  Exception
	 ***************************************************/
	public void update(ReplyDto rDto) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 댓글 삭제
	 * 2. 처리내용	: 댓글 번호(rno)를 받아와서 댓글 삭제
	 * </pre>
	 * @Method Name : delete
	 * @param 		  rno
	 * @throws 		  Exception
	 ***************************************************/
	public void delete(Integer rno) throws Exception;

	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 페이지 리스트 출력
	 * 2. 처리내용	: 페이징 처리가 된 리스트 출력
	 * </pre>
	 * @Method Name : listPage
	 * @param 		  bno
	 * @param 		  cri
	 * @return		  List<ReplyList>
	 * @throws 		  Exception
	 ***************************************************/
	public List<ReplyDto> listPage(Integer bno, Criteria cri) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 전체 댓글 수 출력
	 * 2. 처리내용	: 페이징 처리를 위한 전체 댓글 수 출력
	 * </pre>
	 * @Method Name : count
	 * @param 		  bno
	 * @return		  Integer
	 * @throws 		  Exception
	 ***************************************************/
	public int count(Integer bno) throws Exception;

	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 게시글 번호 알아내기
	 * 2. 처리내용	: 댓글이 삭제될 때 해당 게시글 번호 알아내기
	 * </pre>
	 * @Method Name : getBno
	 * @param rno
	 * @return
	 * @throws Exception
	 ***************************************************/
	public int getBno(Integer rno) throws Exception;
	
}
