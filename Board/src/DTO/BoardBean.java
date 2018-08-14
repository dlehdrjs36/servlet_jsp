package DTO;

public class BoardBean {
	int writeNum;
	String author;
	String subject;
	String content;
	String fileName;
	int reGroup;
	int reLevel;
	int reSequence;
	int readCount;
	String regDate;
	public BoardBean() {
		super();
	}
	public BoardBean(int writeNum, String author, String subject, String content, String fileName, int reGroup,
			int reLevel, int reSequence, int readCount, String regDate) {
		super();
		this.writeNum = writeNum;
		this.author = author;
		this.subject = subject;
		this.content = content;
		this.fileName = fileName;
		this.reGroup = reGroup;
		this.reLevel = reLevel;
		this.reSequence = reSequence;
		this.readCount = readCount;
		this.regDate = regDate;
	}
	public int getWriteNum() {
		return writeNum;
	}
	public void setWriteNum(int writeNum) {
		this.writeNum = writeNum;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getReGroup() {
		return reGroup;
	}
	public void setReGroup(int reGroup) {
		this.reGroup = reGroup;
	}
	public int getReLevel() {
		return reLevel;
	}
	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}
	public int getReSequence() {
		return reSequence;
	}
	public void setReSequence(int reSequence) {
		this.reSequence = reSequence;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
