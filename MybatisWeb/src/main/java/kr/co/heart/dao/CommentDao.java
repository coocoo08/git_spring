package kr.co.heart.dao;

import java.util.List;

import kr.co.heart.domain.CommentDto;

public interface CommentDao {
	
	int delete(Integer bno) throws Exception;

	List<CommentDto> selectAll(Integer bno) throws Exception;

	int delete(Integer cno, String commenter) throws Exception;
}