package kr.co.heart.dao;

import java.util.List;
import java.util.Map;

import kr.co.heart.domain.BoardDto;
import kr.co.heart.domain.SearchItem;

public interface BoardDao {

	BoardDto select(Integer bno) throws Exception; 
	
	int insert(BoardDto dto) throws Exception;
	int count() throws Exception;
	int deleteAll() throws Exception;
	
	List<BoardDto> selectPage(Map map) throws Exception;

	int increaseViewCnt(Integer bno) throws Exception;

	int delete(Integer bno, String writer) throws Exception;

	int update(BoardDto boardDto) throws Exception;
	
	int searchResultCnt(SearchItem sc) throws Exception;
	List<BoardDto> searchSelectPage(SearchItem sc) throws Exception;

	int updateCommentCnt(Integer bno, int cnt) throws Exception;
}
