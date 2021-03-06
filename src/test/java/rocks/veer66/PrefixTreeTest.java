package rocks.veer66;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

import rocks.veer66.CharNode;
import rocks.veer66.CharPrefixTree;
import rocks.veer66.IntTarget;
import rocks.veer66.StrItem;

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
		var items = Arrays.asList(new StrItem("AB", 2000));
		var tree = new CharPrefixTree(items);
		assertEquals(tree.seek(new CharNode(0,0,'A')), new IntTarget(0, false, 0));
		assertEquals(tree.seek(new CharNode(0,1,'B')), new IntTarget(0, true, 2000));
	}
	
	@Test
	public void testTwoWords() {
		var items = Arrays.asList(new StrItem("A", 1000), new StrItem("AB", 2000));
		var tree = new CharPrefixTree(items);
		assertEquals(tree.seek(new CharNode(0,0,'A')), new IntTarget(0, true, 1000));
		assertEquals(tree.seek(new CharNode(0,1,'B')), new IntTarget(1, true, 2000));
	}
	
    @Test
    public void testThreeWords() {
    	var items = Arrays.asList(new StrItem("A", 1000), new StrItem("AB", 2000),
    			new StrItem("CXX", 3000));
    	var tree = new CharPrefixTree(items);
    	assertEquals(tree.seek(new CharNode(0,0,'A')), new IntTarget(0, true, 1000));
    	assertEquals(tree.seek(new CharNode(0,1,'B')), new IntTarget(1, true, 2000));
    	assertEquals(tree.seek(new CharNode(0,0,'C')), new IntTarget(2, false, 0));
    	assertEquals(tree.seek(new CharNode(2,1,'X')), new IntTarget(2, false, 0));
    	assertEquals(tree.seek(new CharNode(2,2,'X')), new IntTarget(2, true, 3000));
    }

}
