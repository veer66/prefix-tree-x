package rockers.veer66;

public class IntTarget {
	public int index;
	public boolean isFinal;
	public int payload;
	
	IntTarget(int index, boolean isFinal, int payload) {
		this.index = index;
		this.isFinal = isFinal;
		this.payload = payload;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object another) {
		var _another = (IntTarget) another;
		return index == _another.index &&
			   isFinal == _another.isFinal &&
			   payload == _another.payload;
		
	}
}
