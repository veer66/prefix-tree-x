package rockers.veer66;

public class StrItem {
	
	private String content;
	private int payload;

	StrItem(String content, int payload) {
		this.content = content;
		this.payload = payload;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPayload() {
		return payload;
	}

	public void setPayload(int payload) {
		this.payload = payload;
	}	
}
