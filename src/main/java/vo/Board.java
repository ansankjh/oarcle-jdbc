package vo;

public class Board { // vo는 전계층에서 매개변수나 반환값으로 쓰인다.
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String memberId;
	private String updatedate;
	private String createdate;
	

	
	
	
	public Board() {}
	
	public Board(int boardNo, String boardTitle, String boardContent, String memberId, String updatedate,
			String createdate) {
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memberId = memberId;
		this.updatedate = updatedate;
		this.createdate = createdate;
	}

	@Override // 디버깅용 어떤 메소드를 호출하면 한번에 no부터 createdate까지 다 나오게 하는거(객체멤버를 출력)
	public String toString() { // 부모가 가진 메소드를 재정의 하는걸 오버라이딩이라 한다.
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", memberId=" + memberId + ", updatedate=" + updatedate + ", createdate=" + createdate + "]";
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
	
}
