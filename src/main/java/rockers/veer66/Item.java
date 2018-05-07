package rockers.veer66;

public class Item<Content, Payload> {
	
	private Content content;
	private Payload payload;

	Item(Content text, Payload payload) {
		this.content = text;
		this.payload = payload;
	}
	
	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}	
}
