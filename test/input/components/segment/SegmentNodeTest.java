package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeTest {
	
	@Test
	void testSegmentNode() {
		PointNode pt1 = new PointNode(1,1);
		PointNode pt2 = new PointNode(-1,-1);
		SegmentNode node = new SegmentNode(pt1, pt2);
		assertEquals(pt1, node._point1);
		assertEquals(pt2, node._point2);
	}

	@Test
	void testGetPoint1() {
		PointNode pt1 = new PointNode(1,1);
		PointNode pt2 = new PointNode(-1,-1);
		SegmentNode node = new SegmentNode(pt1, pt2);
		assertEquals(pt1, node.getPoint1());
		
		node = new SegmentNode(null, pt2);
		assertEquals(null, node.getPoint1());
	}
	
	@Test
	void testGetPoint2() {
		PointNode pt1 = new PointNode(1,1);
		PointNode pt2 = new PointNode(-1,-1);
		SegmentNode node = new SegmentNode(pt1, pt2);
		assertEquals(pt2, node.getPoint2());
		
		node = new SegmentNode(pt1, null);
		assertEquals(null, node.getPoint2());
	}
	
	@Test
	void testEquals() {
		PointNode pt1 = new PointNode(1,1);
		PointNode pt2 = new PointNode(-1,-1);
		SegmentNode node = new SegmentNode(pt1, pt2);
		assertTrue(node.equals(node));
		
		SegmentNode nodeCopy = new SegmentNode(pt1,pt2);
		assertTrue(node.equals(nodeCopy));
		
		SegmentNode difNode = new SegmentNode(null,null);
		assertFalse(node.equals(difNode));
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
