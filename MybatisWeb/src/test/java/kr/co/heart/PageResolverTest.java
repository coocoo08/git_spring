package kr.co.heart;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import kr.co.heart.domain.PageResolver;

public class PageResolverTest {
	
	@Test
	public void test() {
		PageResolver pr = new PageResolver(250, 1);
		pr.print();
		System.err.println("pr = " + pr);
		System.out.println();
		
		assertTrue(pr.getBeginPage() == 1);
		assertTrue(pr.getEndPage() == 10);
	}
	
	@Test
	public void test2() {
		PageResolver pr = new PageResolver(250, 11);
		pr.print();
		System.err.println("pr = " + pr);
		System.out.println();
		
		assertTrue(pr.getBeginPage() == 11);
		assertTrue(pr.getEndPage() == 20);
	}
	
	@Test
	public void test3() {
		PageResolver pr = new PageResolver(255, 25);
		pr.print();
		System.err.println("pr = " + pr);
		System.out.println();
		
		assertTrue(pr.getBeginPage() == 21);
		assertTrue(pr.getEndPage() == 26);
	}
}
