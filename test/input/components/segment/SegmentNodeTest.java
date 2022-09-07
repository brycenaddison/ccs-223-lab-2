package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeTest {
	
	@Test
	void testSegmentNode() {
		//create segment node and check node values
		PointNode pt1 = new PointNode(1,1);
		PointNode pt2 = new PointNode(-1,-1);
		SegmentNode node = new SegmentNode(pt1, pt2);
		assertEquals(pt1, node._point1);
		assertEquals(pt2, node._point2);
	}

	@Test
	void testGetPoint1() {
		//create segment node and check get point1 is correct
		PointNode pt1 = new PointNode(1,1);
		PointNode pt2 = new PointNode(-1,-1);
		SegmentNode node = new SegmentNode(pt1, pt2);
		assertEquals(pt1, node.getPoint1());
		
		node = new SegmentNode(null, pt2);
		assertEquals(null, node.getPoint1());
	}
	
	@Test
	void testGetPoint2() {
		//create segment node and check get point2 is correct
		PointNode pt1 = new PointNode(1,1);
		PointNode pt2 = new PointNode(-1,-1);
		SegmentNode node = new SegmentNode(pt1, pt2);
		assertEquals(pt2, node.getPoint2());
		
		node = new SegmentNode(pt1, null);
		assertEquals(null, node.getPoint2());
	}
	
	@Test
	void testEquals() {
		//create segment node and compare to other objects using equals method
		PointNode pt1 = new PointNode(1,1);
		PointNode pt2 = new PointNode(-1,-1);
		SegmentNode node = new SegmentNode(pt1, pt2);
		assertTrue(node.equals(node));
		
		SegmentNode nodeCopy = new SegmentNode(pt1,pt2);
		assertTrue(node.equals(nodeCopy));
		
		SegmentNode nodeFlipped = new SegmentNode(pt2,pt1);
		assertTrue(node.equals(nodeFlipped));
		
		SegmentNode difNode = new SegmentNode(pt1,null);
		assertFalse(node.equals(difNode));
		
		SegmentNode nullNode = new SegmentNode(null,null);
		assertFalse(node.equals(nullNode));
		
		String notNode = "not a segment node";
		assertFalse(node.equals(notNode));
	}
	
	@Test
	void testToString() {
		PointNode pt1 = new PointNode(1,1);
		PointNode pt2 = new PointNode(-1,-1);
		SegmentNode node = new SegmentNode(pt1, pt2);
		assertEquals("<__UNNAMED(1.0, 1.0), __UNNAMED(-1.0, -1.0)>",
						node.toString());
		
		pt1 = new PointNode("PosNode", 1,1);
		pt2 = new PointNode("NegNode", -1,-1);
		node = new SegmentNode(pt1, pt2);
		assertEquals("<PosNode(1.0, 1.0), NegNode(-1.0, -1.0)>",
						node.toString());
	}

}
