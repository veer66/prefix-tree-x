package rockers.veer66;

public class Target<Payload> {
	public int index;
	public boolean isFinal;
	public Payload payload;
	
	Target(int index, boolean isFinal, Payload payload) {
		this.index = index;
		this.isFinal = isFinal;
		this.payload = payload;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object another) {
		var _another = (Target<Payload>) another;
		return index == _another.index &&
			   isFinal == _another.isFinal &&
			   payload == _another.payload;
		
	}
}
