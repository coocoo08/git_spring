package kr.co.heart.domain;

import java.util.Date;
import java.util.Objects;

public class BoardDto {
	
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private int view_cnt;
	private int comment_cnt;
	private Date reg_date;
	
	public BoardDto() {
		this("", "", "");
	}
	

	public BoardDto(String title, String content, String writer) {
		//super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}


	@Override
	public int hashCode() {
		return Objects.hash(bno, content, title, writer);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDto other = (BoardDto) obj;
		return Objects.equals(bno, other.bno) && Objects.equals(content, other.content)
				&& Objects.equals(title, other.title) && Objects.equals(writer, other.writer);
	}


	public Integer getBno() {
		return bno;
	}


	public void setBno(Integer bno) {
		this.bno = bno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public int getView_cnt() {
		return view_cnt;
	}


	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}


	public int getComment_cnt() {
		return comment_cnt;
	}


	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}


	public Date getReg_date() {
		return reg_date;
	}


	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}


	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", view_cnt=" + view_cnt + ", comment_cnt=" + comment_cnt + ", reg_date=" + reg_date + "]";
	}

	
}

