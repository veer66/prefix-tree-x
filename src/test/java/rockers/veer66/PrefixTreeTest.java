package rockers.veer66;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

public class PrefixTreeTest {
	Node<Integer> node0, node1;
	Function<String,Character[]> strToCharArray;
	
	@Before
	public void before() {
		node0 = new Node<>(1, 2, 100);
		node1 = new Node<>(1, 2, 100);
		strToCharArray = s -> s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
	}

	@Test
	public void testNodeEquality() {
		assertEquals(node0, node1);
	}

	
	@Test
	public void testTargetEquality() {
		var t0 = new Target<>(1, false, 'A');
		var t1 = new Target<>(1, false, 'A');
		assertEquals(t0, t1);
	}
	
	@Test
	public void testHashCode() {
		assertEquals(node0.hashCode(), node1.hashCode());
	}

	@Test
	public void testSingleItem() {
		var minItems = Arrays.asList(new Item<>("A", 1000));
		var tree = new PrefixTree<>(minItems, strToCharArray);		
		var target = tree.seek(new Node<>(0,0, Character.valueOf('A')));
		assertEquals(target.payload.intValue(), 1000);		
		var notTarget = tree.seek(new Node<>(0,0, Character.valueOf('B')));
		assertNull(notTarget);
	}
	
	@Test
	public void testOneWord() {
		var items = Arrays.asList(new Item<>("A", 1000), new Item<>("AB", 2000));
	}
}
