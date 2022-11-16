package kr.co.heart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.heart.domain.CommentDto;

@Repository
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace ="kr.co.heart.dao.CommentMapper.";
	
	@Override
	public int delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.delete(namespace + "delete", bno);
	}

	@Override
	public List<CommentDto> selectAll(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + "selectAll", bno);
	}

	@Override
	public int delete(Integer cno, String commenter) throws Exception {
		Map map = new HashMap();
		map.put("cno", cno);
		map.put("commenter", commenter);
		
		return session.delete(namespace+"delete", map);
	}

}
