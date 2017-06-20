package org.zerock.domain;

import java.util.Arrays;
import java.util.Date;

public class BoardVo {
	
	private Integer	bno;
	private	String	title;
	private String	content;
	private String	writer;
	private Date	regdt;
	private Integer	viewcnt;
	private Integer replycnt;
	
	private String[]	files;
	
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
	
	public Date getRegdt() {
		return regdt;
	}
	
	public void setRegdt(Date regdt) {
		this.regdt = regdt;
	}
	
	public Integer getViewcnt() {
		return viewcnt;
	}
	
	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	public Integer getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(Integer replycnt) {
		this.replycnt = replycnt;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdt="
				+ regdt + ", viewcnt=" + viewcnt + ", replycnt=" + replycnt + ", files=" + Arrays.toString(files) + "]";
	}

	

}
