package kr.co.heart.service;

import java.util.List;

import kr.co.heart.domain.CommentDto;

public interface CommentService {

	List<CommentDto> getList(Integer bno) throws Exception;

	int remove(Integer cno, Integer bno, String commenter) throws Exception;

}
