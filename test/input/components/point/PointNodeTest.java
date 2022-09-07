package input.components.point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointNodeTest {

	@Test
	void testPointNode() {
		PointNode node = new PointNode(0,0);
		assertEquals(0.0, node._x);
		assertEquals(0.0, node._y);
		assertEquals("__UNNAMED", node._name);
		
		node = new PointNode("Name", 1.000, -90);
		assertEquals(1.0, node._x);
		assertEquals(-90.0, node._y);
		assertEquals("Name", node._name);
	}
	
	@Test
	void testGetX() {
		PointNode node = new PointNode(0,0);
		assertEquals(0.0, node.getX());
		
		PointNode posNode = new PointNode(1,1);
		assertEquals(1.0, posNode.getX());

		PointNode negNode = new PointNode(-1,-1);
		assertEquals(-1.0, negNode.getX());
	}
	
	@Test
	void testGetY() {
		PointNode node = new PointNode(0,0);
		assertEquals(0.0, node.getY());
		
		PointNode posNode = new PointNode(1,1);
		assertEquals(1.0, posNode.getY());

		PointNode negNode = new PointNode(-1,-1);
		assertEquals(-1.0, negNode.getY());
	}
	
	@Test
	void testGetName() {
		PointNode unnamedNode = new PointNode(0,0);
		assertEquals("__UNNAMED", unnamedNode.getName());
		
		PointNode namedNode = new PointNode("Name",1,1);
		assertEquals("Name", namedNode.getName());

		PointNode nullNameNode = new PointNode(null, -1,-1);
		assertEquals(null, nullNameNode.getName());
	}
	
	@Test
	void testHashCode() {
		
		
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
		assertFalse(posNode.equals(negNode));
		//System.out.println(posNode.hashCode());
		//System.out.println(negNode.hashCode());
	
		PointNode negNodeCopy = new PointNode("Copy", -2, -1);
		assertTrue(negNode.equals(negNodeCopy));
		
		String notNode = "not a node";
		assertFalse(node.equals(notNode));
		
		PointNode nullNode = null;
		assertFalse(node.equals(nullNode));
		
	}
	
	@Test
	void testToString() {
		PointNode node = new PointNode(0,0);
		assertEquals("__UNNAMED(0.0, 0.0)", node.toString());
		
		PointNode namedNode = new PointNode("Name", 0, 0);
		assertEquals("Name(0.0, 0.0)", namedNode.toString());
		
		PointNode posNode = new PointNode(2, 5);
		assertEquals("__UNNAMED(2.0, 5.0)", posNode.toString());
		
		PointNode negNode = new PointNode(-2, -5);
		assertEquals("__UNNAMED(-2.0, -5.0)", negNode.toString());

	}
	
	

}
