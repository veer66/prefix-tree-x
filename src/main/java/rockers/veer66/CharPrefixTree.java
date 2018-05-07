package rockers.veer66;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CharPrefixTree {

	Map<CharNode, IntTarget> tab;

	CharPrefixTree(List<StrItem> items) { 			   
		tab = new HashMap<>();
		for (var i = 0; i < items.size(); i++) {
			var item = items.get(i);
			var rowNo = 0;
			var elements = item.getContent().toCharArray();
			for (var j = 0; j < elements.length; j++) {
				var isFinal = (j + 1 == elements.length);
				var elem = elements[j];
				var node = new CharNode(rowNo, j, elem);
				var child = tab.get(node);
				if (child == null) {
					var target = new IntTarget(
							i, isFinal, isFinal ? item.getPayload() : 0);
					tab.put(node, target);
					rowNo = i;
				} else {
					rowNo = child.index;
				}
			}
		}
	}
	
	public IntTarget seek(CharNode node) {
		return tab.get(node);
	}
}
