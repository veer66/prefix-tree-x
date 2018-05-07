package rockers.veer66;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class PrefixTree<Content,Element,Payload> {

	Map<Node<Element>, Target<Payload>> tab;

	PrefixTree(List<Item<Content, Payload>> items, 
			   Function<Content, Element[]> contentToElements) {
		tab = new HashMap<>();
		for (var i = 0; i < items.size(); i++) {
			var item = items.get(i);
			var rowNo = 0;
			var elements = contentToElements.apply(item.getContent());
			for (var j = 0; j < elements.length; j++) {
				var isFinal = (j + 1 == elements.length);
				var elem = elements[j];
				var node = new Node<Element>(rowNo, j, elem);
				var child = tab.get(node);
				if (child == null) {
					var target = new Target<Payload>(
							i, isFinal, item.getPayload());
					tab.put(node, target);
				} else {
					rowNo = child.index;
				}
			}
		}
	}
	
	public Target<Payload> seek(Node<Element> node) {
		return tab.get(node);
	}
}
