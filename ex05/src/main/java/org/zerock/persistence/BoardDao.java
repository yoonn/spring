package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

/****************************************************
 * <pre>
 * org.zerock.persistence
 * BoardDao.java
 * </pre>
 * @author  : 오윤진
 * @Date    : 2017. 4. 19.
 * @Version : 1.0
 ***************************************************/
public interface BoardDao {
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 게시글 등록
	 * 2. 처리내용	: 게시글 데이터 베이스에 Insert
	 * </pre>
	 * @Method Name : create
	 * @param 		  BoardVo vo
	 * @throws 		  Exception
	 ***************************************************/
	public void create(BoardVo vo) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 게시글 조회
	 * 2. 처리내용	: 게시글 데이터 베이스에서 Select
	 * </pre>
	 * @Method Name : read
	 * @param 		  bno (글번호)
	 * @return 		  BoardVo
	 * @throws 		  Exception
	 ***************************************************/
	public BoardVo read(Integer bno) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 게시글 수정
	 * 2. 처리내용	: 게시글 데이터베이스에서 수정
	 * </pre>
	 * @Method Name : update
	 * @param 		  Boardvo vo
	 * @throws 		  Exception
	 ***************************************************/
	public void update(BoardVo vo) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 게시글 삭제
	 * 2. 처리내용	: 게시글 데이터베이스에서 삭제
	 * </pre>
	 * @Method Name : delete
	 * @param 		  bno (글번호)
	 * @throws 		  Exception
	 ***************************************************/
	public void delete(Integer bno) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 게시글 목록
	 * 2. 처리내용	: 데이터베이스에서 게시글 목록 처리
	 * </pre>
	 * @Method Name : listAll
	 * @return		  List<BoardVo>
	 * @throws 		  Exception
	 ***************************************************/
	public List<BoardVo> listAll() throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 게시글 목록 페이징
	 * 2. 처리내용	: 데이터베이스에서 게시글 목록 처리, 페이징 처리
	 * </pre>
	 * @Method Name : listPage
	 * @param		  page
	 * @return		  List<BoardVo>
	 * @throws 		  Exception
	 ***************************************************/
	public List<BoardVo> listPage(int page) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: Criteria 게시글 목록 페이징
	 * 2. 처리내용	: 데이터베이스에서 게시글 목록 처리, Criteria 처리
	 * </pre>
	 * @Method Name : listCriteria
	 * @param 		  cri
	 * @return		  List<BoardVo>
	 * @throws		  Exception
	 ***************************************************/
	public List<BoardVo> listCriteria(Criteria cri) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 페이징 Criteria 게시글 목록 페이징
	 * 2. 처리내용	: 데이터베이스에서 게시글 목록 처리, 페이징 처리, Criteria 처리
	 * </pre>
	 * @Method Name : countPaging
	 * @param 		  cri
	 * @return		  int
	 * @throws 		  Exception
	 ***************************************************/
	public int countPaging(Criteria cri) throws Exception;
	
	
	public List<BoardVo> listSearch(SearchCriteria cri) throws Exception;
	
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 댓글 수 증가
	 * 2. 처리내용	: 댓글의 숫자를 변경
	 * </pre>
	 * @Method Name : updateReplyCnt
	 * @param 		  bno
	 * @param 		  amount
	 * @throws 		  Exception
	 ***************************************************/
	public void updateReplyCnt(Integer bno, int amount) throws Exception;
	
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: 조회 수 1 증가
	 * 2. 처리내용	: 특정 게시글의 조회 수를 1씩 증가
	 * </pre>
	 * @Method Name : updateViewCnt
	 * @param 		  bno
	 * @throws		  Exception
	 ***************************************************/
	public void updateViewCnt (Integer bno) throws Exception;
	
	/****************************************************
	 * <pre>
	 * 1. 개요	: BoardDao에 첨부파일 저장
	 * 2. 처리내용	: auto_increment로 생성되는 bno를 알아내기 위해서 LAST_INSERT_ID()를 이용하여 저장
	 * </pre>
	 * @Method Name : addAttach
	 * @param		  fullName
	 * @throws		  Exception
	 ***************************************************/
	public void addAttach(String fullName) throws Exception;

	/****************************************************
	 * <pre>
	 * 1. 개요	: 첨부파일 리스트를 가져온다.
	 * 2. 처리내용	: 특정 게시글의 첨부파일을 시간 순서대로 가져온다.
	 * </pre>
	 * @Method Name : getAttach
	 * @param		  bno
	 * @return		  List<String>
	 * @throws		  Exception
	 ***************************************************/
	public List<String> getAttach(Integer bno) throws Exception;
	
}
