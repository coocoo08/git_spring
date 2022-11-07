package kr.co.heart;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.heart.dao.BoardDao;
import kr.co.heart.domain.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest {

	@Autowired
	private BoardDao boardDao;
	
	//@Test
	public void selectTest() throws Exception{
		assertTrue(boardDao != null);
		System.out.println("boardDao = " + boardDao);
		
		BoardDto boardDto = boardDao.select(1);
		System.out.println("boardDto = " + boardDto);
		assertTrue(boardDto.getBno().equals(1));
		
		boardDao.deleteAll();
		boardDto = new BoardDto("Pioneering", "Ready for Action", "ezen");
		boardDao.insert(boardDto);
		
		boardDto = boardDao.select(2);
		System.out.println("boardDto = " + boardDto);
		assertTrue(boardDto.getBno().equals(2));
	}
	
	@Test
	public void selectPageTest() throws Exception {
		boardDao.deleteAll();
		
		for (int i = 1; i <= 10; i++) {
			BoardDto boardDto = new BoardDto("Pioneering" + i, "취업 준비" + i, "ezen");
			boardDao.insert(boardDto);
		}
		
		Map map = new HashMap();
		map.put("offset", 0);
		map.put("pageSize",	3);
		
		List<BoardDto> list = boardDao.selectPage(map);
		assertTrue(list.get(0).getTitle().equals("Pioneering10"));
		assertTrue(list.get(1).getTitle().equals("Pioneering9"));
		assertTrue(list.get(2).getTitle().equals("Pioneering8"));
	}
	
	
}
