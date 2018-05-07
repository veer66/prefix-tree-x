package rockers.veer66;

import java.util.Objects;

public class CharNode {
	public int index;
	public int offset;
	public char element;
	
	CharNode(int index, int offset, char element) {
		this.index = index;
		this.offset = offset;
		this.element = element;
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(index, offset, element);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object another) {
		var _another = (CharNode) another;
		return index == _another.index &&
			   offset == _another.offset &&
			   element == _another.element;
		
	}
}
