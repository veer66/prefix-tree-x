package rockers.veer66;

import java.util.Objects;

public class Node<Element> {
	public int index;
	public int offset;
	public Element element;
	
	Node(int index, int offset, Element element) {
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
		var _another = (Node<Element>) another;
		return index == _another.index &&
			   offset == _another.offset &&
			   element == _another.element;
		
	}
}
