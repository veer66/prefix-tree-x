package rockers.veer66;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PrefixTreeTest {
	CharNode node0, node1;
	
	@Before
	public void before() {
		node0 = new CharNode(1, 2, 'A');
		node1 = new CharNode(1, 2, 'A');
	}

	@Test
	public void testNodeEquality() {
		assertEquals(node0, node1);
	}

	
	@Test
	public void testTargetEquality() {
		var t0 = new IntTarget(1, false, 2000);
		var t1 = new IntTarget(1, false, 2000);
		assertEquals(t0, t1);
	}
	
	@Test
	public void testHashCode() {
		assertEquals(node0.hashCode(), node1.hashCode());
	}

	@Test
	public void testSingleItem() {
		var minItems = Arrays.asList(new StrItem("A", 1000));
		var tree = new CharPrefixTree(minItems);		
		var target = tree.seek(new CharNode(0,0, 'A'));
		assertEquals(target.payload, 1000);		
		var notTarget = tree.seek(new CharNode(0,0, 'B'));
		assertNull(notTarget);
	}
	
	@Test
	public void testOneWord() {
		var items = Arrays.asList(new StrItem("A", 1000), new StrItem("AB", 2000));
		
	}
}
