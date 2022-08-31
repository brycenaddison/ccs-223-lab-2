package input.components.point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointNodeTest {

	@Test
	void getXTest() {
		PointNode node = new PointNode(0,0);
		assertEquals(0.0, node.getX());
		
		PointNode posNode = new PointNode(1,1);
		assertEquals(1.0, posNode.getX());

		PointNode negNode = new PointNode(-1,-1);
		assertEquals(-1.0, negNode.getX());
	}
	
	
	@Test
	void testEquals() {
		PointNode node = new PointNode(0,0);
		assertTrue(node.equals(node));
		assertFalse(node.equals(null));
		
		PointNode nodeCopy = new PointNode("Copy", 0, 0);
		assertTrue(node.equals(nodeCopy));
		
		PointNode posNode = new PointNode(2,1);
		assertFalse(node.equals(posNode));
		
		PointNode negNode = new PointNode(-2, -1);
		assertFalse(node.equals(negNode));
		//assertFalse(posNode.equals(negNode));
		System.out.println(posNode.hashCode());
		System.out.println(negNode.hashCode());
		
		
		PointNode negNodeCopy = new PointNode("Copy", -1, -1);
		assertTrue(negNode.equals(negNodeCopy));
		
	}
	
	@Test
	void testToString() {
		PointNode node = new PointNode(0,0);
		assertEquals("__UNNAMED(0.0, 0.0)", node.toString());
		
		PointNode namedNode = new PointNode("Name", 0, 0);
		assertEquals("Name(0.0, 0.0)", namedNode.toString());
		
		PointNode negNode = new PointNode(-2, -5);
		assertEquals("__UNNAMED(-2.0, -5.0)", negNode.toString());

	}
	
	

}
