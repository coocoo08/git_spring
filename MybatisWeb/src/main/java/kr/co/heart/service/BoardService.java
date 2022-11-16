package kr.co.heart.service;

import java.util.List;
import java.util.Map;

import kr.co.heart.domain.BoardDto;
import kr.co.heart.domain.SearchItem;

public interface BoardService {

	List<BoardDto> getPage(Map map) throws Exception;
	int getCount() throws Exception;
	BoardDto read(Integer bno) throws Exception;
	int remove(Integer bno, String writer) throws Exception;
	int write(BoardDto boardDto) throws Exception;
	int modify(BoardDto boardDto) throws Exception;
	int getSearchResultCnt(SearchItem sc) throws Exception;
	List<BoardDto> getsearchResultPage(SearchItem sc) throws Exception;

}
